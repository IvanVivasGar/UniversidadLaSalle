document.addEventListener("DOMContentLoaded", function () {
    // Variables globales
    let map, heatLayer, markersLayer, osmLayer, satelliteLayer, baseLayers, lastSearchQuery = '';
    const currentProjectionKey = 'currentProjection';
    let currentProjection = localStorage.getItem(currentProjectionKey) || "EPSG:3857";

    if (currentProjection === "EPSG:4326") {
        currentProjection = "EPSG:3857";
    }

    // Configuración centralizada
    const config = {
        projectionDescriptions: {
            "EPSG:3857": "Web Mercator: Proyección estándar para mapas web. Buena para navegación, distorsiona áreas en latitudes altas.",
            "EPSG:3395": "Mercator: Proyección conforme que preserva ángulos. Útil para navegación marítima."
        },
        projections: {
            "EPSG:3857": {
                name: "Web Mercator",
                crs: L.CRS.EPSG3857,
                tileLayer: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
            },
            "EPSG:3395": {
                name: "Mercator",
                crs: L.CRS.EPSG3395,
                tileLayer: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
            }
        },
        defaultLocation: {
            lat: 19.4326,
            lng: -99.1332,
            zoom: 12,
            name: "Zócalo, Ciudad de México"
        },
        heatmapOptions: {
            radius: 25,
            blur: 15,
            maxZoom: 17,
            gradient: {0.4: 'blue', 0.65: 'lime', 1: 'red'}
        },
        pois: [
            {name: "Zócalo", lat: 19.4326, lng: -99.1332, desc: "Plaza principal de la Ciudad de México"},
            {name: "Chapultepec", lat: 19.4200, lng: -99.1813, desc: "Parque urbano más grande de América Latina"},
            {name: "Bellas Artes", lat: 19.4352, lng: -99.1413, desc: "Palacio de Bellas Artes"}
        ]
    };

    // Inicializar el mapa
    initializeMap();

    // Función para inicializar el mapa
    function initializeMap() {
        // Crear mapa con la proyección configurada
        map = L.map('map', {
            crs: config.projections[currentProjection].crs
        }).setView([config.defaultLocation.lat, config.defaultLocation.lng], config.defaultLocation.zoom);

        setupMapLayers();
        setupEvents();
        updateUI();

        // Buscar la dirección del Zócalo al inicio
        if (currentProjection === "EPSG:3857") {
            geocodeAddress(config.defaultLocation.name);
        }
    }

    // Configuración de capas del mapa
    function setupMapLayers() {
        // Capa base OSM
        osmLayer = L.tileLayer(config.projections[currentProjection].tileLayer, {
            attribution: '&copy; OpenStreetMap contributors',
            maxZoom: 18,
            detectRetina: true
        }).addTo(map);

        // Capa de satélite
        satelliteLayer = L.tileLayer('https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}', {
            attribution: 'Tiles &copy; Esri &mdash; Source: Esri, i-cubed, USDA, USGS, AEX, GeoEye, Getmapping, Aerogrid, IGN, IGP, UPR-EGP, and the GIS User Community',
            maxZoom: 18
        });

        baseLayers = {
            "OpenStreetMap": osmLayer,
            "Satélite": satelliteLayer
        };

        // Capa de marcadores
        markersLayer = L.layerGroup().addTo(map);

        // Solo crear mapa de calor en proyección Web Mercator
        if (currentProjection === "EPSG:3857" && typeof L.heatLayer === 'function') {
            const initialHeatData = generateHeatmapData(
                config.defaultLocation.lat,
                config.defaultLocation.lng,
                2, 20
            );
            heatLayer = L.heatLayer(initialHeatData, config.heatmapOptions).addTo(map);
        }
    }

    // Configuración unificada de eventos
    function setupEvents() {
        // Eventos del mapa
        map.on('click', e => {
            const lat = e.latlng.lat.toFixed(5);
            const lng = e.latlng.lng.toFixed(5);
            updateInfoPanel(lat, lng, null);

            // Solo hacer geocodificación inversa en Web Mercator
            if (currentProjection === "EPSG:3857") {
                reverseGeocode(lat, lng);
            }
        });

        // Eventos de UI
        const elements = {
            osmRadio: document.getElementById('osm'),
            satelliteRadio: document.getElementById('satellite'),
            heatmapCheckbox: document.getElementById('heatmap'),
            markersCheckbox: document.getElementById('markers'),
            searchButton: document.getElementById('search-button'),
            addressInput: document.getElementById('address-input'),
            projectionSelector: document.getElementById('projection-selector')
        };

        // Cambio de capa base
        elements.osmRadio?.addEventListener('change', function() {
            if(this.checked) {
                map.removeLayer(satelliteLayer);
                osmLayer.addTo(map);
            }
        });

        elements.satelliteRadio?.addEventListener('change', function() {
            if(this.checked) {
                map.removeLayer(osmLayer);
                satelliteLayer.addTo(map);
            }
        });

        // Mostrar/ocultar mapa de calor
        elements.heatmapCheckbox?.addEventListener('change', function() {
            if (currentProjection === "EPSG:3857") {
                this.checked && heatLayer ? map.addLayer(heatLayer) : map.removeLayer(heatLayer);
            }
        });

        // Mostrar/ocultar marcadores
        elements.markersCheckbox?.addEventListener('change', function() {
            if (currentProjection === "EPSG:3857") {
                if(this.checked) {
                    addSampleMarkers();
                } else {
                    markersLayer.clearLayers();
                }
            }
        });

        // Configuración de búsqueda
        if (elements.searchButton && elements.addressInput) {
            elements.addressInput.placeholder = "Ingrese dirección o coordenadas (lat, lng)";

            elements.searchButton.addEventListener('click', () => {
                if (currentProjection === "EPSG:3857") {
                    const input = elements.addressInput.value.trim();
                    input && processSearchInput(input);
                }
            });

            elements.addressInput.addEventListener('keyup', event => {
                if (event.key === 'Enter' && currentProjection === "EPSG:3857") {
                    const input = event.target.value.trim();
                    input && processSearchInput(input);
                }
            });
        }

        // Cambio de proyección
        elements.projectionSelector?.addEventListener('change', function() {
            changeProjection(this.value);
        });
    }

    // Actualizar interfaz según la proyección
    function updateUI() {
        // Actualizar selector de proyección
        const projectionSelector = document.getElementById('projection-selector');
        if (projectionSelector) {
            // Remover la opción WGS84 si existe
            const wgs84Option = projectionSelector.querySelector('option[value="EPSG:4326"]');
            if (wgs84Option) {
                wgs84Option.remove();
            }

            projectionSelector.value = currentProjection;

            // Actualizar descripción
            const descElement = document.getElementById('projection-description');
            if (descElement) {
                descElement.textContent = config.projectionDescriptions[currentProjection];
            }
        }

        // Mostrar/ocultar secciones específicas para Web Mercator
        const searchSection = document.querySelector('.menu-section:nth-of-type(4)');
        const layersSection = document.querySelector('.menu-section:nth-of-type(3)');

        if (searchSection && layersSection) {
            const isWebMercator = currentProjection === "EPSG:3857";
            searchSection.style.display = isWebMercator ? 'block' : 'none';
            layersSection.style.display = isWebMercator ? 'block' : 'none';
        }

        // Actualizar estado de los checkboxes
        const heatmapCheckbox = document.getElementById('heatmap');
        const markersCheckbox = document.getElementById('markers');

        if (heatmapCheckbox) {
            // Solo deshabilitar si no es Web Mercator
            heatmapCheckbox.disabled = currentProjection !== "EPSG:3857";

            if (currentProjection !== "EPSG:3857") {
                heatmapCheckbox.checked = false;
            }
        }

        if (markersCheckbox) {
            // Solo deshabilitar si no es Web Mercator
            markersCheckbox.disabled = currentProjection !== "EPSG:3857";

            if (currentProjection !== "EPSG:3857") {
                markersCheckbox.checked = false;
            }
        }
    }

    // Generar datos de calor aleatorios
    function generateHeatmapData(lat, lng, radiusKm, points) {
        const heatData = [];
        const earthRadius = 6371;

        for (let i = 0; i < points; i++) {
            const radius = Math.random() * radiusKm;
            const angle = Math.random() * 2 * Math.PI;

            const latOffset = (radius / earthRadius) * (180 / Math.PI);
            const lngOffset = (radius / earthRadius) * (180 / Math.PI) / Math.cos(lat * Math.PI / 180);

            const newLat = lat + latOffset * Math.sin(angle);
            const newLng = lng + lngOffset * Math.cos(angle);
            const intensity = 0.3 + Math.random() * 0.7;

            heatData.push([newLat, newLng, intensity]);
        }
        return heatData;
    }

    // Actualizar mapa de calor en la ubicación
    function updateHeatmapAtLocation(lat, lng) {
        if (currentProjection !== "EPSG:3857") return;

        const newHeatData = generateHeatmapData(lat, lng, 2, 20);

        if (heatLayer) {
            map.removeLayer(heatLayer);
        }

        heatLayer = L.heatLayer(newHeatData, config.heatmapOptions).addTo(map);

        const heatmapCheckbox = document.getElementById('heatmap');
        if (heatmapCheckbox && !heatmapCheckbox.checked) {
            map.removeLayer(heatLayer);
        }
    }

    // Obtener dirección desde coordenadas
    function getAddressFromCoordinates(lat, lon, callback) {
        if (currentProjection !== "EPSG:3857") return;

        fetch(`https://nominatim.openstreetmap.org/reverse?format=json&lat=${lat}&lon=${lon}`)
            .then(response => response.json())
            .then(data => {
                if (data?.display_name && callback) {
                    callback(data.display_name, data);
                    return data.display_name;
                }
                throw new Error("No se pudo obtener la dirección");
            })
            .catch(error => {
                console.error('Error en geocodificación inversa:', error);
                callback?.(null, error);
                return null;
            });
    }

    // Actualizar panel de información
    function updateInfoPanel(lat, lng, address) {
        const infoPanel = document.getElementById('info-panel');
        if (infoPanel) {
            infoPanel.innerHTML = `
                <p><strong>Latitud:</strong> ${lat}</p>
                <p><strong>Longitud:</strong> ${lng}</p>
                <p><strong>Dirección:</strong> ${currentProjection === "EPSG:3857" ? (address || 'Obteniendo...') : 'No disponible'}</p>
                <p><strong>Proyección:</strong> ${config.projections[currentProjection].name}</p>
            `;
        }
    }

    // Procesar entrada de búsqueda
    function processSearchInput(input) {
        if (currentProjection !== "EPSG:3857") return;

        lastSearchQuery = input;

        // Verificar si son coordenadas
        const coordsMatch = input.match(/^(-?\d+\.?\d*),\s*(-?\d+\.?\d*)$/);

        if (coordsMatch) {
            const lat = parseFloat(coordsMatch[1]);
            const lon = parseFloat(coordsMatch[2]);

            if (!isNaN(lat) && !isNaN(lon) && lat >= -90 && lat <= 90 && lon >= -180 && lon <= 180) {
                map.setView([lat, lon], 15);

                markersLayer.clearLayers();
                L.marker([lat, lon])
                    .addTo(markersLayer)
                    .bindPopup(`<b>Coordenadas:</b> ${lat}, ${lon}`)
                    .openPopup();

                updateInfoPanel(lat, lon, null);
                getAddressFromCoordinates(lat, lon, (address) => address && updateInfoPanel(lat, lon, address));
                updateHeatmapAtLocation(lat, lon);

                return true;
            }
        }

        // Si no son coordenadas, buscar como dirección
        geocodeAddress(input);
        return true;
    }

    // Geocodificación (buscar direcciones)
    function geocodeAddress(address) {
        if (currentProjection !== "EPSG:3857") return;

        fetch(`https://nominatim.openstreetmap.org/search?format=json&q=${encodeURIComponent(address)}`)
            .then(response => response.json())
            .then(data => {
                if (data.length > 0) {
                    const lat = parseFloat(data[0].lat);
                    const lon = parseFloat(data[0].lon);

                    map.setView([lat, lon], 15);

                    markersLayer.clearLayers();
                    L.marker([lat, lon])
                        .addTo(markersLayer)
                        .bindPopup(`<b>Dirección:</b> ${address}<br><b>Lat:</b> ${lat}<br><b>Lon:</b> ${lon}`)
                        .openPopup();

                    updateInfoPanel(lat, lon, address);
                    updateHeatmapAtLocation(lat, lon);
                } else {
                    alert("Dirección no encontrada.");
                }
            })
            .catch(error => {
                console.error('Error en geocodificación:', error);
                alert("Error al buscar la dirección. Por favor, inténtelo de nuevo.");
            });
    }

    // Geocodificación inversa
    function reverseGeocode(lat, lon) {
        if (currentProjection !== "EPSG:3857") return;

        getAddressFromCoordinates(lat, lon, (address) => {
            updateInfoPanel(lat, lon, address || "No se pudo obtener la dirección");
        });
    }

    // Añadir marcadores de ejemplo
    function addSampleMarkers() {
        if (currentProjection !== "EPSG:3857") return;

        markersLayer.clearLayers();

        config.pois.forEach(poi => {
            L.marker([poi.lat, poi.lng])
                .bindPopup(`<b>${poi.name}</b><br>${poi.desc}`)
                .addTo(markersLayer);
        });
    }

    // Cambiar proyección
    function changeProjection(projectionCode) {
        // Verificar que la proyección exista en la configuración
        if (!config.projections[projectionCode]) {
            console.error(`La proyección ${projectionCode} no está disponible`);
            return;
        }

        const currentCenter = map.getCenter();
        const currentZoom = map.getZoom();

        // Guardar el estado de los checkboxes antes de cambiar
        const heatmapCheckbox = document.getElementById('heatmap');
        const markersCheckbox = document.getElementById('markers');

        // Guarda el estado anterior solo si estamos cambiando desde Web Mercator
        let previousHeatmapState = false;
        let previousMarkersState = false;

        if (currentProjection === "EPSG:3857") {
            previousHeatmapState = heatmapCheckbox?.checked || false;
            previousMarkersState = markersCheckbox?.checked || false;
        }

        if (projectionCode !== "EPSG:3857") {
            // Desactivar mapa de calor y marcadores al cambiar a otra proyección
            if (heatmapCheckbox) heatmapCheckbox.checked = false;
            if (markersCheckbox) markersCheckbox.checked = false;

            // Limpiar capas existentes
            if (heatLayer && map.hasLayer(heatLayer)) map.removeLayer(heatLayer);
            markersLayer.clearLayers();
        }

        currentProjection = projectionCode;
        localStorage.setItem(currentProjectionKey, projectionCode);

        map.remove();

        map = L.map('map', {
            crs: config.projections[projectionCode].crs
        }).setView([currentCenter.lat, currentCenter.lng], currentZoom);

        setupMapLayers();
        setupEvents();
        updateUI();

        // Restaurar estado anterior si volvemos a Web Mercator
        if (projectionCode === "EPSG:3857") {
            // Restauramos los estados de los checkboxes
            if (heatmapCheckbox) {
                heatmapCheckbox.disabled = false;
            }

            if (markersCheckbox) {
                markersCheckbox.disabled = false;
            }

            // Procesar la última consulta primero
            if (lastSearchQuery) {
                processSearchInput(lastSearchQuery);
            }

            // Restaurar estado del mapa de calor
            setTimeout(() => {
                if (heatmapCheckbox && previousHeatmapState) {
                    heatmapCheckbox.checked = true;
                    if (heatLayer) map.addLayer(heatLayer);
                }

                // Restaurar marcadores
                if (markersCheckbox && previousMarkersState) {
                    markersCheckbox.checked = true;
                    addSampleMarkers();
                }
            }, 100);
        }
    }
});
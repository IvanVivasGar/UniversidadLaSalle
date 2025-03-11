// Asegurar que el script se ejecute después de que el DOM esté cargado
document.addEventListener("DOMContentLoaded", function () {

    // Definir el sistema de coordenadas correcto antes de crear el mapa
    var crs = new L.Proj.CRS('EPSG:4326',
        '+proj=longlat +datum=WGS84 +no_defs',
        { resolutions: [0.001, 0.0005, 0.00025] });

    // Inicializar el mapa con la proyección correcta
    var map = L.map('map', { crs: crs }).setView([19.4326, -99.1332], 12); // CDMX

    // Agregar capa base de OpenStreetMap
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; OpenStreetMap contributors',
        maxZoom: 18,
        detectRetina: true
    }).addTo(map);

    // Función para geocodificación (buscar direcciones)
    function geocodeAddress(address) {
        var url = `https://nominatim.openstreetmap.org/search?format=json&q=${address}`;

        fetch(url)
            .then(response => response.json())
            .then(data => {
                if (data.length > 0) {
                    var lat = parseFloat(data[0].lat);
                    var lon = parseFloat(data[0].lon);
                    map.setView([lat, lon], 15); // Centrar mapa
                    L.marker([lat, lon]).addTo(map).bindPopup(address).openPopup();
                } else {
                    alert("Dirección no encontrada.");
                }
            })
            .catch(error => console.error('Error en geocodificación:', error));
    }

    // Llamar la función con una dirección de prueba
    geocodeAddress("Zócalo, Ciudad de México");

    // Verificar que Leaflet.heat está cargado antes de usarlo
    if (typeof L.heatLayer !== "undefined") {
        var heatMapData = [
            [19.42847, -99.12766, 0.8], // Mayor tráfico
            [19.43528, -99.14168, 0.5], // Medio tráfico
            [19.44362, -99.15448, 0.3]  // Bajo tráfico
        ];

        var heat = L.heatLayer(heatMapData, { radius: 25 }).addTo(map);
    } else {
        console.warn("Leaflet.heat no está cargado. Verifica la importación de la librería.");
    }

});
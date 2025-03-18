# Aplicación Georreferenciada

## 1. Descripción General

Esta aplicación web permite la visualización y análisis de datos geoespaciales mediante un mapa interactivo. Ofrece funcionalidades de geolocalización, geocodificación, visualización de capas temáticas y cambio de proyecciones cartográficas.

## 2. Arquitectura

La aplicación está desarrollada como una aplicación web de una sola página (SPA) utilizando HTML, CSS y JavaScript vanilla. No depende de frameworks JavaScript como React, Angular o Vue.

### 2.1 Estructura de Archivos

```
/
├── index.html      # Estructura principal de la aplicación
├── style.css       # Estilos CSS
└── app.js          # Lógica principal de la aplicación
```

## 3. Tecnologías y Librerías

### 3.1 Librerías Externas

| Librería | Versión | Propósito |
|----------|---------|-----------|
| Leaflet | 1.9.4 | Biblioteca principal para mapas interactivos |
| Leaflet.heat | 0.2.0 | Plugin para visualización de mapas de calor |

### 3.2 APIs Externas

| API | Propósito |
|-----|-----------|
| OpenStreetMap Tiles | Provisión de mapas base |
| Nominatim | Geocodificación y geocodificación inversa |
| ESRI World Imagery | Imágenes satelitales |

## 4. Componentes Principales

### 4.1 Sistema de Mapas

La aplicación utiliza Leaflet.js para renderizar mapas interactivos. El componente principal es el elemento `<div id="map"></div>` que contiene el mapa.

#### Proyecciones Cartográficas

La aplicación soporta múltiples proyecciones cartográficas:

- **EPSG:3857 (Web Mercator)**: Proyección estándar para mapas web
- **EPSG:3395 (Mercator)**: Proyección conforme que preserva ángulos

### 4.2 Sistema de Capas

La aplicación implementa un sistema de capas múltiples:

**Capas Base:**
- OpenStreetMap: Mapa base de calles y carreteras
- Satélite: Imágenes satelitales de ESRI

**Capas Temáticas:**
- Mapa de Calor: Visualización de densidad (simulando tráfico)
- Marcadores: Puntos de interés predefinidos

### 4.3 Sistema de Geocodificación

La aplicación integra servicios de geocodificación mediante la API de Nominatim de OpenStreetMap:

- **Geocodificación**: Conversión de direcciones textuales a coordenadas geográficas
- **Geocodificación Inversa**: Conversión de coordenadas a direcciones textuales

## 5. Funcionalidades Principales

### 5.1 Inicialización del Mapa

```javascript
function initializeMap() {
    map = L.map('map', {
        crs: config.projections[currentProjection].crs
    }).setView([config.defaultLocation.lat, config.defaultLocation.lng], config.defaultLocation.zoom);

    setupMapLayers();
    setupEvents();
    updateUI();

    if (currentProjection === "EPSG:3857") {
        geocodeAddress(config.defaultLocation.name);
    }
}
```

### 5.2 Cambio de Proyecciones

```javascript
function changeProjection(projectionCode) {
    // Verificar que la proyección exista en la configuración
    if (!config.projections[projectionCode]) {
        console.error(`La proyección ${projectionCode} no está disponible`);
        return;
    }

    const currentCenter = map.getCenter();
    const currentZoom = map.getZoom();

    // Lógica para cambiar la proyección
    // ...

    currentProjection = projectionCode;
    localStorage.setItem(currentProjectionKey, projectionCode);

    // Recrear el mapa con la nueva proyección
    map.remove();
    map = L.map('map', {
        crs: config.projections[projectionCode].crs
    }).setView([currentCenter.lat, currentCenter.lng], currentZoom);

    setupMapLayers();
    setupEvents();
    updateUI();
}
```

### 5.3 Geocodificación y Búsqueda

```javascript
function geocodeAddress(address) {
    if (currentProjection !== "EPSG:3857") return;

    fetch(`https://nominatim.openstreetmap.org/search?format=json&q=${encodeURIComponent(address)}`)
        .then(response => response.json())
        .then(data => {
            if (data.length > 0) {
                const lat = parseFloat(data[0].lat);
                const lon = parseFloat(data[0].lon);

                // Centrar mapa y crear marcador
                // ...
            }
        });
}
```

### 5.4 Generación de Mapas de Calor

```javascript
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
```

## 6. Persistencia de Datos

La aplicación utiliza localStorage para guardar preferencias del usuario:

```javascript
const currentProjectionKey = 'currentProjection';
let currentProjection = localStorage.getItem(currentProjectionKey) || "EPSG:3857";
```

## 7. Limitaciones y Consideraciones

- **Dependencia de Servicios Externos**: La aplicación depende de servicios externos como OpenStreetMap para tiles y Nominatim para geocodificación, lo que puede afectar su disponibilidad.
- **Compatibilidad**: Algunas funcionalidades (como mapas de calor) solo funcionan con proyección Web Mercator (EPSG:3857).
- **Uso de APIs**: El uso de Nominatim está sujeto a sus términos de servicio, incluyendo límites de peticiones.

## 8. Instalación y Configuración

### 8.1 Requisitos Previos

- Servidor web para alojar archivos estáticos (Apache, Nginx, etc.)
- Conexión a Internet para cargar las librerías y datos

### 8.2 Instalación

1. Clonar o descargar los archivos del proyecto.
2. Colocar los archivos en un directorio accesible por el servidor web.
3. Acceder a la aplicación a través del navegador.

### 8.3 Configuración

La configuración principal se encuentra en el objeto `config` dentro de `app.js`:

```javascript
const config = {
    projectionDescriptions: { /* ... */ },
    projections: { /* ... */ },
    defaultLocation: { /* ... */ },
    heatmapOptions: { /* ... */ },
    pois: [ /* ... */ ]
};
```

## 9. Guía de Desarrollo

### 9.1 Añadir una Nueva Proyección

Para añadir una nueva proyección:

1. Añadir la proyección al objeto `config.projections`:

```javascript
"EPSG:XXXX": {
    name: "Nombre Proyección",
    crs: L.CRS.EPSGXXXX, // Debe existir en Leaflet o ser creado
    tileLayer: 'URL_del_servicio_de_tiles'
}
```

2. Añadir la descripción en `config.projectionDescriptions`:

```javascript
"EPSG:XXXX": "Descripción de la proyección"
```

3. Añadir la opción al selector en `index.html`:

```html
<option value="EPSG:XXXX">Nombre Proyección (EPSG:XXXX)</option>
```

### 9.2 Añadir Nuevos Puntos de Interés

Actualizar el array `config.pois`:

```javascript
pois: [
    // Añadir nuevos POIs
    {name: "Nuevo POI", lat: XX.XXXX, lng: YY.YYYY, desc: "Descripción"}
]
```

## 10. Compatibilidad de Navegadores

La aplicación es compatible con las versiones modernas de los principales navegadores:

- Chrome 60+
- Firefox 55+
- Safari 11+
- Microsoft Edge 16+

## 11. Referencias

- [Documentación de Leaflet](https://leafletjs.com/reference.html)
- [Documentación de Leaflet.heat](https://github.com/Leaflet/Leaflet.heat)
- [API de Nominatim](https://nominatim.org/release-docs/latest/api/Overview/)
mapboxgl.accessToken = 'pk.eyJ1IjoiaXZhbnZpdmFzZ2FyIiwiYSI6ImNtZXJyNzdjdDA5bzMya3B5bDV4a3Q2azAifQ._2Ca0Tvn6fM5l_z_U3iuLA';

const map = new mapboxgl.Map({
	container: 'map',
	style: 'mapbox://styles/mapbox/streets-v11',
	center: [-99.1332, 19.4326], // centro en Ciudad de México
	zoom: 5
});

// añadir controles de navegación (zoom + rotación)
map.addControl(new mapboxgl.NavigationControl());

map.on('load', () => {
	// Fuente GeoJSON pública de terremotos (ejemplo: USGS all day)
	const earthquakesUrl = 'https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson';

	// Añadir la fuente de datos
	map.addSource('earthquakes', {
		type: 'geojson',
		data: earthquakesUrl
	});

	// Capa de puntos rojos
	map.addLayer({
		id: 'earthquake-points',
		type: 'circle',
		source: 'earthquakes',
		paint: {
			'circle-radius': 6,
			'circle-color': '#ff0000',
			'circle-stroke-color': '#880000',
			'circle-stroke-width': 1
		}
	});

	// Cambiar cursor a pointer al pasar sobre puntos
	map.on('mouseenter', 'earthquake-points', () => {
		map.getCanvas().classList.add('pointer');
	});
	map.on('mouseleave', 'earthquake-points', () => {
		map.getCanvas().classList.remove('pointer');
	});

		// Crear 5 terremotos de ejemplo ubicados en México y mostrar popups al hacer click
		const selectedQuakes = {
			type: 'FeatureCollection',
			features: [
				{
					type: 'Feature',
					properties: { place: 'Ciudad de México', mag: 4.2 },
					geometry: { type: 'Point', coordinates: [-99.1332, 19.4326] }
				},
				{
					type: 'Feature',
					properties: { place: 'Guadalajara, JAL', mag: 3.6 },
					geometry: { type: 'Point', coordinates: [-103.3496, 20.6597] }
				},
				{
					type: 'Feature',
					properties: { place: 'Monterrey, NL', mag: 3.9 },
					geometry: { type: 'Point', coordinates: [-100.3161, 25.6866] }
				},
				{
					type: 'Feature',
					properties: { place: 'Oaxaca, OAX', mag: 4.5 },
					geometry: { type: 'Point', coordinates: [-96.7266, 17.0732] }
				},
				{
					type: 'Feature',
					properties: { place: 'Puebla, PUE', mag: 3.8 },
					geometry: { type: 'Point', coordinates: [-98.2063, 19.0413] }
				}
			]
		};

		map.addSource('selected-quakes', { type: 'geojson', data: selectedQuakes });
		map.addLayer({
			id: 'selected-quakes-points',
			type: 'circle',
			source: 'selected-quakes',
			paint: {
				'circle-radius': 10,
				'circle-color': '#ff0000',
				'circle-stroke-color': '#880000',
				'circle-stroke-width': 1
			}
		});

		// Asegurar que los 5 puntos están por encima de la capa de USGS para que sean clicables
		try { map.moveLayer('selected-quakes-points'); } catch (e) { /* si falla, no hacemos nada extra */ }

		// Mostrar popup al hacer click en esos 5 puntos
		map.on('click', 'selected-quakes-points', (e) => {
			const feat = e.features && e.features[0];
			if (!feat) return;
			const coords = feat.geometry.coordinates.slice();
			const place = feat.properties.place || 'Lugar desconocido';
			const mag = feat.properties.mag != null ? feat.properties.mag : 'N/A';

			new mapboxgl.Popup({ offset: 12 })
				.setLngLat(coords)
				.setHTML(`<strong>${place}</strong><br/>Magnitud: ${mag}`)
				.addTo(map);
		});

		// Cursor pointer al pasar sobre los puntos seleccionados
		map.on('mouseenter', 'selected-quakes-points', () => {
			map.getCanvas().classList.add('pointer');
		});
		map.on('mouseleave', 'selected-quakes-points', () => {
			map.getCanvas().classList.remove('pointer');
		});

		// Decágono exacto: construiremos 10 vértices alrededor de un punto dado.
		// Coordenadas para el centro del decágono en México (cerca de Ciudad de México)
		const center = [-99.1332, 19.4326]; // Ciudad de México
		const radius = 0.08; // grados (~ pequeño)
		const decagonCoords = [];
	for (let i = 0; i < 10; i++) {
		const angle = (i / 10) * (2 * Math.PI);
		const lon = center[0] + radius * Math.cos(angle);
		const lat = center[1] + radius * Math.sin(angle);
		decagonCoords.push([lon, lat]);
	}
	// cerrar el polígono para la linea
	decagonCoords.push(decagonCoords[0]);

	const decagon = {
		type: 'Feature',
		geometry: {
			type: 'LineString',
			coordinates: decagonCoords
		},
		properties: {}
	};

	map.addSource('decagon', { type: 'geojson', data: decagon });
	map.addLayer({
		id: 'decagon-line',
		type: 'line',
		source: 'decagon',
		paint: {
			'line-color': '#0000ff',
			'line-width': 5
		}
	});
});
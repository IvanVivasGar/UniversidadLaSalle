const express = require('express');

const router = express.Router();

// Datos en memoria de ejemplo para la ruta /movies
let movies = [
	{ id: 1, title: 'Tron', year: 2010, category: 'Sci-Fi' },
	{ id: 2, title: 'Interestellar', year: 2014, category: 'Space' },
	{ id: 3, title: 'Shrek', year: 2010, category: 'Animada' },
];

// GET /movies — devuelve todas las películas
router.get('/', (req, res) => {
	res.json(movies);
});

// GET /movies/:id — devuelve una película por id
router.get('/:id', (req, res) => {
	const id = parseInt(req.params.id);
	const movie = movies.find(m => m.id === id);
	if(movie){
		res.json(movie);
	} else {
		res.status(404).json({message: 'Movie not found'});
	}
});

// POST /movies — crea una película nueva en memoria
router.post('/', (req, res) => {
	const { title, year, category } = req.body;
	const newMovie = { id: movies.length + 1, title, year, category };
	movies.push(newMovie);
	res.status(201).json({ message: "created", data: newMovie });
});

// PUT /movies/:id — actualiza (parcial o total) una película
router.put('/:id', (req, res) => {
	const { id } = req.params;
	const { title, year, category } = req.body;
	const movie = movies.find(m => m.id == id);
	if (movie) {
		if (title) movie.title = title;
		if (year) movie.year = year;
		if (category) movie.category = category;
		res.json({ message: 'Updated', data: movie });
	} else {
		res.status(404).json({ message: "Movie not found" });
	}
});

// DELETE /movies/:id — elimina una película por id
router.delete('/:id', (req, res) => {
	const { id } = req.params;
	const movieIndex = movies.findIndex(m => m.id == id);
	if (movieIndex !== -1) {
		const deletedMovie = movies.splice(movieIndex, 1)[0];
		res.json({ message: 'Deleted', data: deletedMovie });
	} else {
		res.status(404).json({ message: 'Movie not found' });
	}
});

module.exports = router;
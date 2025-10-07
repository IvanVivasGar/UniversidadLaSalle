const express = require('express');
const router = express.Router();
const productsService = require('../services/productsService');
const service = new productsService();

// Router para CRUD de productos usando productsService

// GET /products — devuelve todos los productos
router.get('/', (req, res) => {
	const products = service.getAll();
	res.json(products);
});

// GET /products/category/:categoryId — filtra por categoría
router.get('/category/:categoryId', (req, res) => {
	const categoryId = parseInt(req.params.categoryId);
	const productsByCategory = service.getAll().filter(p => p.categoryId === categoryId);
	res.json(productsByCategory);
});

// GET /products/:id — devuelve producto por id
router.get('/:id', (req, res) => {
	const { id } = req.params;
	const product = service.getById(id);
	if (!product) return res.status(404).json({ error: 'Producto no encontrado' });
	res.json(product);
});

// GET /products/brand/:brandId — filtra por marca
router.get('/brand/:brandId', (req, res) => {
	const brandId = parseInt(req.params.brandId);
	const productsByBrand = service.getAll().filter(p => p.brandId === brandId);
	res.json(productsByBrand);
});

// POST /products — crea un nuevo producto
router.post('/', (req, res) =>{
	const body = req.body;
	const newProduct = service.create(body);
	res.status(201).json(newProduct);
});

// PUT /products/:id — actualiza un producto existente
router.put('/:id', (req, res) => {
	const { id } = req.params;
	const changes = req.body;
	const updated = service.update(id, changes);
	if (!updated) return res.status(404).json({ error: 'Producto no encontrado' });
	res.json({ message: 'updated', data: updated });
});

// DELETE /products/:id — elimina un producto por id
router.delete('/:id', (req, res) => {
	const { id } = req.params;
	const deleted = service.delete(id);
	if (!deleted) return res.status(404).json({ error: 'Producto no encontrado' });
	res.json({ message: 'deleted', data: deleted });
});

module.exports = router;
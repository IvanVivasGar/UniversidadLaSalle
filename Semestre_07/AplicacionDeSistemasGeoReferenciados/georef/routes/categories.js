const express = require('express');
const router = express.Router();
const CategoriesService = require('../services/categoriesService');
const service = new CategoriesService();

// Router para CRUD de categorías (usa categoriesService)

// GET /categories
// Retorna el listado completo de categorías
// GET /categories — devuelve todas las categorías
router.get('/', (req, res) => {
  res.json(service.getAll());
});

// GET /categories/:id
// Retorna una categoría específica por id
// GET /categories/:id — devuelve una categoría por id
router.get('/:id', (req, res) => {
  const { id } = req.params;
  const category = service.getById(id);
  if (category) res.json(category); else res.status(404).json({ error: 'Categoría no encontrada' });
});

// POST /categories
// Crea una categoría nueva (requiere categoryName, description, active)
// POST /categories — crea una nueva categoría
router.post('/', (req, res) => {
  const { categoryName, description, active } = req.body;
  const newCategory = service.create({ categoryName, description, active });
  res.status(201).json(newCategory);
});

// PUT /categories/:id
// Actualiza total/parcialmente una categoría existente
// PUT /categories/:id — actualiza una categoría existente
router.put('/:id', (req, res) => {
  const { id } = req.params;
  const changes = req.body;
  const updated = service.update(id, changes);
  if (!updated) return res.status(404).json({ error: 'Categoría no encontrada' });
  res.json(updated);
});

// DELETE /categories/:id
// Elimina una categoría por id del arreglo en memoria
// DELETE /categories/:id — elimina una categoría por id
router.delete('/:id', (req, res) => {
  const { id } = req.params;
  const deleted = service.delete(id);
  if (!deleted) return res.status(404).json({ error: 'Categoría no encontrada' });
  res.json(deleted);
});

module.exports = router;
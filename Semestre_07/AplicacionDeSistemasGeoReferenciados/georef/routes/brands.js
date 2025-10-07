const express = require('express');
const router = express.Router();
const BrandsService = require('../services/brandsService');
const service = new BrandsService();

// Router para CRUD de marcas (usa brandsService)

// GET /brands
// Retorna el listado completo de marcas
// GET /brands — devuelve todas las marcas
router.get('/', (req, res) => {
  res.json(service.getAll());
});

// GET /brands/:id
// Retorna una marca específica por id
// GET /brands/:id — devuelve una marca por id
router.get('/:id', (req, res) => {
  const { id } = req.params;
  const brand = service.getById(id);
  if (brand) res.json(brand); else res.status(404).json({ error: 'Marca no encontrada' });
});

// POST /brands
// Crea una marca nueva (requiere brandName, description, active)
// POST /brands — crea una nueva marca
router.post('/', (req, res) => {
  const { brandName, description, active } = req.body;
  const newBrand = service.create({ brandName, description, active });
  res.status(201).json(newBrand);
});

// PUT /brands/:id
// Actualiza total/parcialmente una marca existente por id
// PUT /brands/:id — actualiza una marca existente
router.put('/:id', (req, res) => {
  const { id } = req.params;
  const changes = req.body;
  const updated = service.update(id, changes);
  if (!updated) return res.status(404).json({ error: 'Marca no encontrada' });
  res.json(updated);
});

// DELETE /brands/:id
// Elimina una marca por id del arreglo en memoria
// DELETE /brands/:id — elimina una marca por id
router.delete('/:id', (req, res) => {
  const { id } = req.params;
  const deleted = service.delete(id);
  if (!deleted) return res.status(404).json({ error: 'Marca no encontrada' });
  res.json(deleted);
});

module.exports = router;
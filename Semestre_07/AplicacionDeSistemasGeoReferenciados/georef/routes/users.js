const express = require('express');
const router = express.Router();
const UsersService = require('../services/usersService');
const service = new UsersService();

// Router para operaciones CRUD sobre usuarios en memoria

// GET /users
// Retorna el listado completo de usuarios en memoria
// GET /users — devuelve la lista completa de usuarios
router.get('/', (req, res) => {
  res.json(service.getAll());
});

// GET /users/:id
// Busca y devuelve un usuario por su identificador numérico
// GET /users/:id — devuelve un usuario por id
router.get('/:id', (req, res) => {
  const { id } = req.params;
  const user = service.getById(id);
  if (user) {
    res.json(user);
  } else {
    res.status(404).json({ error: 'Usuario no encontrado' });
  }
});

// POST /users
// Crea un nuevo usuario con los campos name, username, password
// Requiere body JSON y agrega el registro al arreglo en memoria
// POST /users — crea un nuevo usuario
router.post('/', (req, res) => {
  const { name, username, password } = req.body;
  if (!name || !username || !password) {
    return res.status(400).json({ error: 'Faltan campos requeridos' });
  }
  const newUser = service.create({ name, username, password });
  res.status(201).json(newUser);
});

// PUT /users/:id
// Actualiza completamente o parcialmente un usuario existente
// Si algún campo no viene en el body, se mantiene el valor anterior
// PUT /users/:id — actualiza un usuario existente
router.put('/:id', (req, res) => {
  const { id } = req.params;
  const changes = req.body;
  const updated = service.update(id, changes);
  if (!updated) return res.status(404).json({ error: 'Usuario no encontrado' });
  res.json(updated);
});

// DELETE /users/:id
// Elimina el usuario con el id especificado del arreglo en memoria
// DELETE /users/:id — elimina un usuario por id
router.delete('/:id', (req, res) => {
  const { id } = req.params;
  const deleted = service.delete(id);
  if (!deleted) return res.status(404).json({ error: 'Usuario no encontrado' });
  res.json({ message: 'Usuario eliminado', data: deleted });
});

module.exports = router;
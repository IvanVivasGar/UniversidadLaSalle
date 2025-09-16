const express = require('express');
const router = express.Router();
const { faker } = require('@faker-js/faker');

function createUser(id) {
  return {
    id,
    name: faker.person.fullName(),
    username: faker.internet.username(),
    password: faker.internet.password()
  };
}

const users = Array.from({ length: 10 }, (_, i) => createUser(i + 1));

router.get('/', (req, res) => {
  res.json(users);
});

router.get('/:id', (req, res) => {
  const userId = parseInt(req.params.id);

  const user = users.find(u => u.id === userId);

  if (user) {
    res.json(user);
  } else {
    res.status(404).json({ error: 'Usuario no encontrado' });
  }
});

module.exports = router;

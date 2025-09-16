const express = require('express');
const router = express.Router();
const { faker } = require('@faker-js/faker');

function createCategory(id) {
  return {
    id,
    categoryName: faker.commerce.department(),
    description: faker.lorem.sentence(),
  active: faker.datatype.boolean()
  };
}

const categories = Array.from({ length: 10 }, (_, i) => createCategory(i + 1));

router.get('/', (req, res) => {
  res.json(categories);
});

router.get('/:id', (req, res) => {
  const categoryId = parseInt(req.params.id);

  const category = categories.find(c => c.id === categoryId);

  if (category) {
    res.json(category);
  } else {
    res.status(404).json({ error: 'Categoría no encontrada' });
  }
});

module.exports = router;

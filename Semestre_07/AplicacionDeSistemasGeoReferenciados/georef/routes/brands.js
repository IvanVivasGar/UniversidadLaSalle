const express = require('express');
const router = express.Router();
const { faker } = require('@faker-js/faker');

function createBrand(id) {
  return {
    id,
    brandName: faker.company.name(),
    description: faker.lorem.sentence(),
    active: faker.datatype.boolean()
  };
}

const brands = Array.from({ length: 10 }, (_, i) => createBrand(i + 1));

router.get('/', (req, res) => {
  res.json(brands);
});

router.get('/:id', (req, res) => {
  const brandId = parseInt(req.params.id);

  const brand = brands.find(b => b.id === brandId);

  if (brand) {
    res.json(brand);
  } else {
    res.status(404).json({ error: 'Marca no encontrada' });
  }
});

module.exports = router;

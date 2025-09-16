const express = require('express');
const router = express.Router();
const { faker } = require('@faker-js/faker');

function createProduct(id, categoryId, brandId) {
  return {
    id,
    image: faker.image.url(),
    productName: faker.commerce.productName(),
    description: faker.commerce.productDescription(),
    price: faker.commerce.price(),
    stock: faker.number.int({ min: 0, max: 100 }),
    categoryId,
  brandId
  };
}

const products = Array.from({ length: 50 }, (_, i) =>
  createProduct(i + 1,
    faker.number.int({ min: 1, max: 10 }),
    faker.number.int({ min: 1, max: 10 })));

router.get('/', (req, res) => {
  res.json(products);
});

router.get('/:id', (req, res) => {
  const productId = parseInt(req.params.id);

  const product = products.find(p => p.id === productId);

  if (product) {
    res.json(product);
  } else {
    res.status(404).json({ error: 'Producto no encontrado' });
  }
});

router.get('/category/:categoryId', (req, res) => {
  const categoryId = parseInt(req.params.categoryId);

  const productsByCategory = products.filter(p => p.categoryId === categoryId);

  if (productsByCategory.length > 0) {
    res.json(productsByCategory);
  } else {
    res.json([]);
  }
});

router.get('/brand/:brandId', (req, res) => {
  const brandId = parseInt(req.params.brandId);

  const productsByBrand = products.filter(p => p.brandId === brandId);

  if (productsByBrand.length > 0) {
    res.json(productsByBrand);
  } else {
    res.json([]);
  }
});

module.exports = router;

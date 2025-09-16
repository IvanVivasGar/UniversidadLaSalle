const express = require("express");
const faker = require('faker');
const router = express.Router();

router.get("/", (req, res) => {
  const { cantidad } = req.query;
  const count = cantidad ? (cantidad) : 10;
  const products = [];
  for (let index = 0; index < count; index++) {
    products.push({
      name: faker.commerce.productName(),
      price: parseInt(faker.commerce.price(), 10),
      image: faker.image.imageUrl()
    });
  }
  res.json(products);
});


router.get("/:id", (req, res) => {
  const {id} = req.params;
  res.json({
    id,
    name: "Sabritas",
    price: 30
  });
});

module.exports = router;

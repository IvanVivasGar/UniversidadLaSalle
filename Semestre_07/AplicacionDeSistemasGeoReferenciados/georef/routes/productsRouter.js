
// Importa Express y Faker para generar datos falsos
const express = require("express");
const faker = require('faker');
const router = express.Router();


// Ruta para obtener productos, acepta parámetro de query 'cantidad'
router.get("/", (req, res) => {
  const { cantidad } = req.query; // Valor que meto a la URL
  const count = cantidad ? (cantidad) : 10;
  // Opción 2: const count = cantidad || 10;
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



// Ruta para obtener un producto específico por ID
// Ejemplo: /products/123
router.get("/:id", (req, res) => {
  const {id} = req.params;
  res.json({
    id,
    name: "Sabritas",
    price: 30
  });
});


// Exporta el router para ser usado en otras partes de la aplicación
module.exports = router;

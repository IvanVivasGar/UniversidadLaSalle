
// Importa Express y las rutas principales
const express = require('express');
const routerApi = require('./routes/rutas');
const app = express();
const port = 3000;


// Ruta principal (root) del servidor
app.get("/", (req, res) => {
  res.send("Hola desde mi server en Express");
});


// Ruta adicional de ejemplo
// localhost:3000/nuevaruta
app.get("/nuevaruta", (req, res) => {
  res.send("Hola desde mi nueva ruta");
})


// Integración de rutas externas (products)
routerApi(app);


// Ejemplo de ruta para obtener productos (comentada)
// localhost:3000/products
// app.get("/products", (req, res) => {
//   const products = [];
//   for(let index = 0; index < 10; index++){
//     products.push({
//       name: faker.commerce.productName(),
//       price: parseInt(faker.commerce.price(), 10),
//       image: faker.image.imageUrl()
//     });
//   }
//   res.json(products);
// });



// Ruta con parámetros dinámicos en la URL
app.get("/categories/:categoryId/products/:productId", (req, res) => {
  const {categoryId, productId} = req.params;
  res.json({
    categoryId,
    productId
  });
});


// Ruta que recibe parámetros de tipo query
app.get("/users", (req, res) => {
  const { username, lastname } = req.query;
  if(username && lastname){
    res.json({
      username,
      lastname
    });
  } else {
    res.send("No hay parametros query");
  }
});



// Inicializa el servidor en el puerto definido
app.listen(port, ()=>{
  console.log("My server is working on port " + port);
});


// Ejemplo de endpoint tipo RESTful
/*
api.example.com/tasks/{id}
*/

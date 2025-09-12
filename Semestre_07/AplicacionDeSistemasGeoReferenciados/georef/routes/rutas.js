
// Importa el router de productos
const productsRouter = require('./productsRouter');


// Función para agregar rutas a la aplicación principal
function routerApi(app){
  // Asocia el router de productos a la ruta /products
  app.use('/products', productsRouter);
}


// Exporta la función para ser utilizada en index.js
module.exports = routerApi;

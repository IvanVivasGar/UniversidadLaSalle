const usersRouter = require('./users');
const categoriesRouter = require('./categories');
const brandsRouter = require('./brands');
const productsRouter = require('./products');

function routerApi(app){
  app.use('/users', usersRouter);
  app.use('/categories', categoriesRouter);
  app.use('/brands', brandsRouter);
  app.use('/products', productsRouter);
}

module.exports = routerApi;
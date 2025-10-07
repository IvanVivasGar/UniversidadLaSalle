// Importa routers por recurso
const usersRouter = require('./users');
const categoriesRouter = require('./categories');
const brandsRouter = require('./brands');
const productsRouter = require('./products');
const moviesRouter = require('./moviesRouter');

// Monta los routers en sus rutas base dentro de la app principal
function routerApi(app){
	app.use('/users', usersRouter);
	app.use('/categories', categoriesRouter);
	app.use('/brands', brandsRouter);
	app.use('/products', productsRouter);
	app.use('/movies', moviesRouter);
}

// Exporta la función que configura el enrutamiento
module.exports = routerApi;
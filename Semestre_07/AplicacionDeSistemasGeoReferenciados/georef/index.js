const express = require('express');
const routerApi = require('./routes/rutas');
const app = express();
const port = 3000;

// Habilita parseo de JSON en cuerpos de petición
app.use(express.json());

// Ruta raíz: sanity check simple
app.get("/", (req, res) => {
	res.send("Hola desde mi server en Express");
});

// Ruta adicional de ejemplo
app.get("/nuevaruta", (req, res) => {
	res.send("Hola desde mi nueva ruta");
})

// Monta el enrutador principal que agrupa routers por recurso
routerApi(app);

// Arranca el servidor en el puerto configurado
app.listen(port, ()=>{
	console.log("My server is working on port " + port);
});
const express = require('express');
const routerApi = require('./routes/rutas');
const app = express();
const port = 3000;

app.get("/", (req, res) => {
  res.send("Hola desde mi server en Express");
});

app.get("/nuevaruta", (req, res) => {
  res.send("Hola desde mi nueva ruta");
})

routerApi(app);

app.listen(port, ()=>{
  console.log("My server is working on port " + port);
});
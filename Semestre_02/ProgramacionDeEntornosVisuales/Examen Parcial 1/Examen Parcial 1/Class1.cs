using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Examen_Parcial_1
{
    class Producto
    {
        public string gradoAlimenticio;
        public float presentacion;
        public float precio;

        public Producto() { }

        public Producto(string gradoAlimenticio, float presentacion, float precio)
        {
            this.gradoAlimenticio = gradoAlimenticio;
            this.presentacion = presentacion;
            this.precio = precio;
        }

        public void SetGradoAlimenticio(string gradoAlimenticio)
        {
            this.gradoAlimenticio = gradoAlimenticio;
        }

        public void SetPresentacion(float presentacion)
        {
            this.presentacion = presentacion;
        }

        public void SetPrecio(float precio)
        {
            this.precio = precio;
        }

        public string GetGradoAlimenticio()
        {
            return this.gradoAlimenticio;
        }

        public float GetPresentacion()
        {
            return this.presentacion;
        }

        public float GetPrecio()
        {
            return this.precio;
        }

        public override string ToString()
        {
            return $"Grado Alimenticio: {this.gradoAlimenticio}, Presentacion: {this.presentacion} KG, Precio: {this.precio}";
        }
    }
}
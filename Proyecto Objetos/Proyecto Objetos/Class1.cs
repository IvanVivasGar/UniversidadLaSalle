using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Objetos
{
    public class TargaryenDragons : MensajeUltimatum
    {
        protected String tamano;
        protected String color;
        protected String nombre;
        protected String montador;

        public void SetMontador(String montador) {
            this.montador = montador;
        }

        public void SetTamano(String tamano) {
            this.tamano = tamano;
        }

        public void SetColor(String color) {
            this.color = color;
        }

        public void SetNombre(String nombre) {
            this.nombre = nombre;
        }

        public String GetMontador() {
            return this.montador;
        }

        public String GetTamano() {
            return this.tamano;
        }

        public String GetColor() {
            return this.color;
        }

        public String GetNombre() {
            return this.nombre;
        }

        public override void ToString() {
            Console.WriteLine($"ESTE ES UN DRAGON HISTORICO\n\nDRAGON: {this.nombre} \nMONTADOR: {this.montador} \nTAMAÑO: {this.tamano} \nCOLOR: {this.color}");
        }
    }
}

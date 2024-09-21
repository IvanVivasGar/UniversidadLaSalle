using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_8
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Crear una compu basica
            Console.WriteLine("Creamos una compu basica y mostramos sus caracteristicas");
            Computador laBasiquita = new Computador("MSI", "INTEL", 32, 1024);
            Console.WriteLine(laBasiquita.toString());
            Computador laBasic = new Computador("Asus", "AMD", 64, 256);
            Console.WriteLine(laBasic.toString());
            laBasic.setCositasExtras(true, false, false);
            Console.WriteLine(laBasic.getCositasExtras());
        }
    }

    //Los objetos son bloques de codigo para emular algo "real"
    //Mejor dicho, para reusarlos y modificar atributos

    class Computador 
    {
        private string marca;
        private string procesador;
        private int memoriaRam;
        private int unidadDD;
        private bool graficaDedicada;
        private bool ssd;
        private bool dosHD;

        public Computador(string marca, string procesador, int memoriaRam, int unidadDD)
        {
            this.marca = marca;
            this.procesador = procesador;
            this.memoriaRam = memoriaRam;
            this.unidadDD = unidadDD;
        }

        public void setCositasExtras(bool graficaDedicada, bool ssd, bool dosHD) {
            this.graficaDedicada = graficaDedicada;
            this.ssd = ssd;
            this.dosHD = dosHD;
        }

        public string getCositasExtras() {
            return $"La computadora tiene estos extra:\nGraficos Dedicados: {graficaDedicada}\nDisco Duro de estado solido: {ssd}\nCapacidad par dos discos duros: {dosHD}";
        }

        public string toString() {
            return $"La computadora de mas ventas es: {marca}\nProcesador: {procesador}\nMemoria Ram: {memoriaRam}\nCapacidad de HDD: {unidadDD} GB";
        }

    }

}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Metadata.W3cXsd2001;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Proyecto_9
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int decisionCompra = 0;
            
            Console.WriteLine("----------------------------------------------");
            Console.WriteLine("         Configurador de Computadoras         ");
            Console.WriteLine("----------------------------------------------");
            Console.WriteLine();

            Console.WriteLine("Ingrese 1 para elegir la configuracion basica.");
            Console.WriteLine("Ingrese 2 para elegir la configuracion intermedia.");
            Console.WriteLine("Ingrese 3 para elegir sus propios componentes.");
            decisionCompra = int.Parse(Console.ReadLine());

            if (decisionCompra == 1)
            {
                Computadora basica = new Computadora();

                basica.setMarca("MSI");
                basica.setProcesador("AMD");
                basica.setMemoriaRam(8);
                basica.setUnidadDD(256);
                basica.setGraficaDedicada(false);
                basica.setSsd(true);
                basica.setDosHd(false);

                Console.WriteLine();

                Console.WriteLine($"Su computador tiene:\nMarca: {basica.marca}\nProcesador: {basica.procesador}\nMemoria Ram: {basica.memoriaRam}\nUnidad de Datos: {basica.unidadDD}\nGrafica Dedicada: {basica.graficaDedicada}\nSSD: {basica.ssd}\nCapacidad para doble disco: {basica.dosHD}");
            }
            else {
                if (decisionCompra == 2)
                {
                    Computadora intermedia = new Computadora();

                    intermedia.setMarca("Alienware");
                    intermedia.setProcesador("Intel");
                    intermedia.setMemoriaRam(16);
                    intermedia.setUnidadDD(512);
                    intermedia.setGraficaDedicada(true);
                    intermedia.setSsd(true);
                    intermedia.setDosHd(false);

                    Console.WriteLine();

                    Console.WriteLine($"Su computador tiene:\nMarca: {intermedia.marca}\nProcesador: {intermedia.procesador}\nMemoria Ram: {intermedia.memoriaRam}\nUnidad de Datos: {intermedia.unidadDD}\nGrafica Dedicada: {intermedia.graficaDedicada}\nSSD: {intermedia.ssd}\nCapacidad para doble disco: {intermedia.dosHD}");
                }
                else {
                    if (decisionCompra == 3) {
                        Computadora configurable = new Computadora();

                        Console.WriteLine();
                        Console.WriteLine("Ingrese 1 para elegir Intel como procesador");
                        Console.WriteLine("Ingrese 2 para elegir AMD como procesador");
                        int decisionProcesador = int.Parse(Console.ReadLine());
                        switch (decisionProcesador) {
                            case 1:
                                configurable.setProcesador("Intel");
                                break;
                            case 2:
                                configurable.setProcesador("AMD");
                                break;
                        }

                        Console.WriteLine();
                        Console.WriteLine("Ingrese 1 para elegir la marca MSI");
                        Console.WriteLine("Ingrese 2 para elegir la marca Alienware");
                        int decisionMarca = int.Parse(Console.ReadLine());
                        switch (decisionMarca)
                        {
                            case 1:
                                configurable.setMarca("MSI");
                                break;
                            case 2:
                                configurable.setMarca("Alienware");
                                break;
                        }

                        Console.WriteLine();
                        Console.WriteLine("Ingrese 1 para elegir 16 gb de RAM");
                        Console.WriteLine("Ingrese 2 para elegir 32 gb de RAM");
                        int decisionRam = int.Parse(Console.ReadLine());
                        switch (decisionRam)
                        {
                            case 1:
                                configurable.setMemoriaRam(16);
                                break;
                            case 2:
                                configurable.setMemoriaRam(32);
                                break;
                        }

                        Console.WriteLine();
                        Console.WriteLine("Ingrese 1 para elegir 512 gb de almacenamiento");
                        Console.WriteLine("Ingrese 2 para elegir 1024 gb de almacenamiento");
                        int decisionUnidadDD = int.Parse(Console.ReadLine());
                        switch (decisionUnidadDD)
                        {
                            case 1:
                                configurable.setUnidadDD(512);
                                break;
                            case 2:
                                configurable.setUnidadDD(1024);
                                break;
                        }

                        Console.WriteLine();
                        Console.WriteLine("Ingrese 1 para elegir tener una grafica dedicada");
                        Console.WriteLine("Ingrese 2 para elegir no tener una grafica dedicada");
                        int decisionGraficaDedicada = int.Parse(Console.ReadLine());
                        switch (decisionGraficaDedicada)
                        {
                            case 1:
                                configurable.setGraficaDedicada(true);
                                break;
                            case 2:
                                configurable.setGraficaDedicada(false);
                                break;
                        }

                        Console.WriteLine();
                        Console.WriteLine("Ingrese 1 para elegir tener un SSD");
                        Console.WriteLine("Ingrese 2 para elegir no tener un SSD");
                        int decisionSSD = int.Parse(Console.ReadLine());
                        switch (decisionSSD)
                        {
                            case 1:
                                configurable.setSsd(true);
                                break;
                            case 2:
                                configurable.setSsd(false);
                                break;
                        }

                        Console.WriteLine();
                        Console.WriteLine("Ingrese 1 para elegir tener opcion para dos discos");
                        Console.WriteLine("Ingrese 2 para elegir no tener opcion para dos discos");
                        int decisionDosHdd = int.Parse(Console.ReadLine());
                        switch (decisionDosHdd)
                        {
                            case 1:
                                configurable.setDosHd(true);
                                break;
                            case 2:
                                configurable.setDosHd(false);
                                break;
                        }

                        Console.WriteLine();

                        Console.WriteLine($"Su computador tiene:\nMarca: {configurable.marca}\nProcesador: {configurable.procesador}\nMemoria Ram: {configurable.memoriaRam}\nUnidad de Datos: {configurable.unidadDD}\nGrafica Dedicada: {configurable.graficaDedicada}\nSSD: {configurable.ssd}\nCapacidad para doble disco: {configurable.dosHD}");

                    }
                    else {
                        Console.WriteLine("La opcion ingresada no existe.");
                    }
                }
            }

        }
    }

    class Computadora {
        public string marca;
        public string procesador;
        public int memoriaRam;
        public int unidadDD;
        public bool graficaDedicada;
        public bool ssd;
        public bool dosHD;

        public void computador(string marca, string procesador, int memoriaRam, int unidadDD, bool graficaDedicada, bool ssd, bool dosHD) {
            this.marca = marca;
            this.procesador = procesador;
            this.memoriaRam = memoriaRam;
            this.unidadDD = unidadDD;
            this.graficaDedicada = graficaDedicada;
            this.ssd = ssd;
            this.dosHD = dosHD;
        }

        public void computador() { }

        public void setMarca(string marca) {
            this.marca = marca;
        }

        public void setProcesador(string procesador)
        {
            this.procesador = procesador;
        }
        public void setMemoriaRam(int memoriaRam)
        {
            this.memoriaRam = memoriaRam;
        }

        public void setUnidadDD(int unidadDD) {
            this.unidadDD = unidadDD;
        }

        public void setGraficaDedicada(bool graficaDedicada) {
            this.graficaDedicada = graficaDedicada;
        }

        public void setSsd(bool ssd) {
            this.ssd = ssd;
        }

        public void setDosHd(bool dosHD) {
            this.dosHD = dosHD;
        }

    }
}
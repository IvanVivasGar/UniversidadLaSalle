using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Examen_Parcial_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            bool terminarPrograma = false;
            int confimarPedido;

            do {
                Console.WriteLine();
                Console.WriteLine();
                Console.WriteLine();

                int indicePedido = 1;

                int cantidadProductos = tamañoArreglo();
                Producto[] pedido = new Producto[cantidadProductos];

                for (int i = 0; i < pedido.Length; i++)
                {
                    pedido[i] = llenarArreglo(indicePedido);
                    indicePedido++;
                }

                imprimirArreglo(pedido);

                try
                {
                    Console.WriteLine("Ingrese 1 para confimar el pedido");
                    Console.WriteLine("Ingrese 2 para volver a realizar el pedido");
                    Console.Write("Desea confimar el pedido? ");
                    confimarPedido = int.Parse(Console.ReadLine());

                    if (confimarPedido == 1)
                    {
                        terminarPrograma = true;
                    }
                }
                catch (FormatException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine();
                }
                catch (OverflowException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine();
                } 
            } while (terminarPrograma == false);

            Console.WriteLine();
            Console.WriteLine();
        }

        public static int tamañoArreglo() {
            Console.WriteLine("----------------------------------------------------------------");
            Console.WriteLine("         TIENDA DE PRODUCTOS ALIMENTICIOS PARA MASCOTAS         ");
            Console.WriteLine("----------------------------------------------------------------");
            Console.WriteLine();

            Console.Write("Ingrese la cantidad de productos que comprara: ");
            int cantidadProductos = int.Parse(Console.ReadLine());

            return cantidadProductos;
        }

        public static Producto llenarArreglo(int indicePedido) {
            bool error = false;
            int decisionGradoAlimenticio = 0, i = 1, decisionPresentacion = 0;
            float precio = 0, presentacion = 0;
            string gradoAlimenticio = "";

            do
            {
                try
                {
                    Console.WriteLine();
                    Console.WriteLine($"PRODUCTO {indicePedido}");
                    Console.WriteLine();
                    Console.WriteLine("Ingresa 0 para la presentacion de 1 KG");
                    Console.WriteLine("Ingrese 1 para la presentacion de 5 KG");
                    Console.WriteLine("Ingrese 2 para la presentacion de 10 KG");
                    Console.WriteLine("Ingrese 3 para la presentacion de 20 KG");
                    Console.WriteLine("Ingrese 4 para una presentacion personalizada");
                    Console.Write("Ingrese la presentacion que desea: ");

                    decisionPresentacion = int.Parse(Console.ReadLine());
                        
                    if (decisionPresentacion == 0 || decisionPresentacion == 1 || decisionPresentacion == 2 || decisionPresentacion == 3 || decisionPresentacion == 4) {
                        if (decisionPresentacion == 0){
                            presentacion = 1;
                        }
                        else{
                            if (decisionPresentacion == 1)
                            {
                                presentacion = 5;
                            }
                            else {
                                if (decisionPresentacion == 2)
                                {
                                    presentacion = 10;
                                }
                                else {
                                    if (decisionPresentacion == 3)
                                    {
                                        presentacion = 20;
                                    }
                                    else {
                                        Console.WriteLine();
                                        Console.Write("Ingrese la cantidad de kilogramos que desea comprar: ");
                                        presentacion = int.Parse(Console.ReadLine());
                                    }
                                }
                            }
                        }
                        error = true;
                    }
                }
                catch (FormatException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine();
                }
                catch (OverflowException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine();
                }
            }while (error == false);

            error = false;

            do
            {
                try
                {
                    Console.WriteLine();
                    Console.WriteLine("Ingresa 1 para estandar");
                    Console.WriteLine("Ingresa 2 para intermedio");
                    Console.WriteLine("Ingresa 3 para premium");
                    Console.Write("Ingresa el grado alimenticio del producto que deseas: ");
                    decisionGradoAlimenticio = int.Parse(Console.ReadLine());

                    if (decisionGradoAlimenticio == 1 || decisionGradoAlimenticio == 2 || decisionGradoAlimenticio == 3) {
                        if (decisionGradoAlimenticio == 1)
                        {
                            gradoAlimenticio = "Estandar";
                        }
                        else {
                            if (decisionGradoAlimenticio == 2)
                            {
                                gradoAlimenticio = "Intermedio";
                            }
                            else {
                                gradoAlimenticio = "Premium";
                            }
                        }
                        error = true;
                    }
                }
                catch (FormatException ex)
                {
                    Console.WriteLine(ex.Message);
                }
                catch (OverflowException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine();
                }
            } while (error == false);

            switch (decisionPresentacion) {
                case 0 :
                    if (gradoAlimenticio == "estandar")
                    {
                        precio = (float)(presentacion * 37.0);
                    }
                    else
                    {
                        if (gradoAlimenticio == "intermedio")
                        {
                            precio = (float)(presentacion * 48.0);
                        }
                        else
                        {
                            precio = (float)(presentacion * 62.0);
                        }
                    }
                    break;
                case 1:
                    if (gradoAlimenticio == "estandar")
                    {
                        precio = (float)((presentacion * 37)-((presentacion * 37)*0.08));
                    }
                    else {
                        if (gradoAlimenticio == "intermedio")
                        {
                            precio = (float)((presentacion * 48) - ((presentacion * 48) * 0.08));
                        }
                        else 
                        {
                            precio = (float)((presentacion * 62) - ((presentacion * 62) * 0.08));
                        }
                    }
                    break;
                case 2:
                    if (gradoAlimenticio == "estandar")
                    {
                        precio = (float)((presentacion * 37) - ((presentacion * 37) * 0.12));
                    }
                    else
                    {
                        if (gradoAlimenticio == "intermedio")
                        {
                            precio = (float)((presentacion * 48) - ((presentacion * 48) * 0.12));
                        }
                        else
                        {
                            precio = (float)((presentacion * 62) - ((presentacion * 62) * 0.12));
                        }
                    }
                    break;
                case 3:
                    if (gradoAlimenticio == "estandar")
                    {
                        precio = (float)((presentacion * 37) - ((presentacion * 37) * 0.16));
                    }
                    else
                    {
                        if (gradoAlimenticio == "intermedio")
                        {
                            precio = (float)((presentacion * 48) - ((presentacion * 48) * 0.16));
                        }
                        else
                        {
                            precio = (float)((presentacion * 62) - ((presentacion * 62) * 0.16));
                        }
                    }
                    break;
                case 4:
                    if (gradoAlimenticio == "estandar")
                    {
                        precio = (float)presentacion * 37;
                    }
                    else
                    {
                        if (gradoAlimenticio == "intermedio")
                        {
                            precio = (float)presentacion * 48;
                        }
                        else
                        {
                            precio = (float)presentacion * 62;
                        }
                    }
                    break;
            }
            Producto objPedido = new Producto(gradoAlimenticio, presentacion, precio);
            return objPedido;
        }

        public static void imprimirArreglo(Producto[] pedido)
        {
            float precioTotal = 0;

            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine();

            string mensaje = "---------------------------------";
            mensaje += "\n             PEDIDO              ";
            mensaje += "\n---------------------------------";
            mensaje += "\n";

            for (int i = 0; i < pedido.Length; i++) { 
                mensaje += $"\nProducto num {i+1}: " + pedido[i].ToString();
                precioTotal += pedido[i].precio;
            }

            Console.WriteLine(mensaje);
            Console.WriteLine();
            Console.WriteLine($"                     COSTO FINAL: {precioTotal}");
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine();
        }

    }
}


//COMENTARIOS

// (toString) - $"Grado Alimenticio: {this.gradoAlimenticio}, Presentacion: {this.presentacion} KG, Precio: {this.precio}";

//Precio por kilo estandar = 37.00
//Precio por kilo intermedio = 48.00
//Precio por kilo premium = 62.00
//
//Presentacion 5 KG = -8%
//Presentacion 10 KG = -12%
//Presentacion 20 KG = -16%
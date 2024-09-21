using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_6
{
    internal class Program
    {
        static void Main(string[] args)
        {
            bool error = false;
            int elNumeroIngresado;
            Console.WriteLine("Vamos a saber a que mes " + "corresponde el numero que se ingrese....");
            Console.WriteLine("---------------------------------------------------------------------");

            do
            {
                try
                {
                    Console.WriteLine();
                    Console.Write("Favor de ingresar un numero: ");
                    elNumeroIngresado = int.Parse(Console.ReadLine());

                    Console.WriteLine($"El numero capturado es {elNumeroIngresado} ahora" + $" veremos a que mes corresponde...");
                    Console.WriteLine("El mes seleccionado es: " + elMesSeleccionado(elNumeroIngresado));
                    error = true;
                    Console.WriteLine();
                }
                catch (FormatException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine();
                    error = false;
                }
                catch (OverflowException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine();
                    error = false;
                }
                catch (ArgumentOutOfRangeException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine();
                    error = false;
                }
            } while (error == false);
        }

        static string elMesSeleccionado (int elNumeroIngresado)
        {
            switch (elNumeroIngresado)
            {
                case 1:
                    return "Enero";
                    break;
                case 2:
                    return "Febrero";
                    break;
                case 3:
                    return "Marzo";
                    break;
                case 4:
                    return "Abril";
                    break;
                case 5:
                    return "Mayo";
                    break;
                case 6:
                    return "Junio";
                    break;
                case 7:
                    return "Julio";
                    break;
                case 8:
                    return "Agosto";
                    break;
                case 9:
                    return "Septiembre";
                    break;
                case 10:
                    return "Octubre";
                    break;
                case 11:
                    return "Noviembre";
                    break;
                case 12:
                    return "Diciembre";
                    break;
                default:
                    throw new ArgumentOutOfRangeException();
            }

        }

    }
}
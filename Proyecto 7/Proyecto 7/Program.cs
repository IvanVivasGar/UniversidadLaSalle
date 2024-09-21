using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

  /*
  * Hacer un Proyectito 7 con arreglos
  * Crear un arreglo de 12 posiciones (contenido libre)
  * preguntar al usuario el número de posición a revisar (del 1 al 12)
  * Validar que el dato ingresado sea número y no mayor al rango solicitado
  * En caso de que no sea número o mayor al rango, que se vuelva a solicitar
  * mostrar el resultado de la posición ingresada por el usuario
  * Para hoy antes de acabar la clase.
  */

namespace Proyecto_7
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("--------------------------------------------------");
            Console.WriteLine("         ELECCION DE PERSONAJES ALEATORIO         ");
            Console.WriteLine("--------------------------------------------------");

            Console.WriteLine();
            Console.WriteLine();

            bool error = false;
            int elNumeroIngresado = 0;

            string[] personajes = new string[12];

            personajes[0] = "Daenerys Targaryen";
            personajes[1] = "Jon Snow";
            personajes[2] = "Tormund";
            personajes[3] = "Viserys Targaryen";
            personajes[4] = "Little Finger";
            personajes[5] = "Robert Baratheon";
            personajes[6] = "Arya Stark";
            personajes[7] = "Sansa Stark";
            personajes[8] = "Bran Stark";
            personajes[9] = "Cersei Lannister";
            personajes[10] = "Tyrion Lannister";
            personajes[11] = "Margaery Tyrell";

            do
            {
                try
                {
                    Console.WriteLine();
                    Console.Write("Favor de ingresar un numero: ");
                    elNumeroIngresado = int.Parse(Console.ReadLine());

                    if (elNumeroIngresado > 12 || elNumeroIngresado < 0) {
                        throw new ArgumentOutOfRangeException();
                    }

                    Console.WriteLine($"El numero capturado es {elNumeroIngresado} ahora" + $" veremos a que personaje corresponde...");
                    Console.WriteLine("El personaje seleccionado es: " + personajes[elNumeroIngresado - 1]);
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
    }
}

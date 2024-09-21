using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("        ADIVINA EL NUMERO ALEATORIO        ");
            Console.WriteLine("-------------------------------------------");
            Console.WriteLine();

            Random numeroAleatorio = new Random();
            int elNumeroBueno = numeroAleatorio.Next(1,100);
            int adivinanza = 0, i = 0;

            while (adivinanza != elNumeroBueno)
            {
                i++;
                Console.Write("Intenta adivinar el numero: ");
                adivinanza = int.Parse(Console.ReadLine());

                    if (adivinanza < elNumeroBueno)
                    {
                        Console.WriteLine("El numero es mayor al que igresaste. Intentalo de nuevo.");
                    } else if (adivinanza > elNumeroBueno)
                    {
                        Console.WriteLine("El numero es menor al que ingresaste. Intentalo de nuevo.");
                    } else if (adivinanza == elNumeroBueno)
                    {
                        Console.WriteLine();
                        Console.WriteLine("Felicidades, adivinaste el numero!!!");
                        Console.WriteLine($"Te tomo {i} intentos adivinarlo.");
                        Console.WriteLine();
                    }
            }

        }
    }
}

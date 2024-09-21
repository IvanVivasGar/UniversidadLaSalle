using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double alturaRectangulo=0, baseRectangulo = 0, areaTotalRectangulo = 0;
            
            Console.WriteLine("Ingrese la altura del rectangulo");
            alturaRectangulo = double.Parse(Console.ReadLine());

            Console.WriteLine("Ingresa la base del rectangulo");
            baseRectangulo = double.Parse(Console.ReadLine());

            areaTotalRectangulo = alturaRectangulo * baseRectangulo;

            Console.WriteLine();
            Console.WriteLine("La altura del rectangulo es de: " + alturaRectangulo);
            Console.WriteLine("La base del rectangulo es de: " + baseRectangulo);
            Console.WriteLine("El area total del rectangulo es de: " + areaTotalRectangulo + " cm^2." );

        }
    }
}

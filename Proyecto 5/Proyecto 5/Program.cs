using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numeroMultiplicacion;

            Console.WriteLine("        TABLAS DE MULTIPLICAR        ");
            Console.WriteLine("-------------------------------------");
            Console.WriteLine();

            Console.WriteLine("Ingrese el numero que desea multiplicar");
            numeroMultiplicacion = int.Parse(Console.ReadLine());
            Console.WriteLine();

            for (int i=0; i<=12; i++)
            {
                Console.WriteLine(i + " x " + numeroMultiplicacion + " = " + numeroMultiplicacion * i);
            }

            Console.WriteLine();
            Console.WriteLine();

        }
    }
}

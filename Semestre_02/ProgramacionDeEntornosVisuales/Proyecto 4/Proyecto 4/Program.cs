using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numero1 = 0, numero2 = 0;

            Console.WriteLine("         FUNCIONES Y METODOS          ");
            Console.WriteLine("--------------------------------------");
            Console.WriteLine();

            while (numero1 == 0 || numero1 < 0)
            {
                Console.Write("Ingresa el primer numero: ");
                numero1 = int.Parse(Console.ReadLine());

                if (numero1 == 0 || numero1 < 0)
                {
                    Console.WriteLine("Por favor, vuelve a ingresar el numero.");
                }
            }

            Console.WriteLine();

            while (numero2 == 0 || numero2 < 0 || numero2 == numero1)
            {
                Console.Write("Ingresa el segundo numero: ");
                numero2 = int.Parse(Console.ReadLine());

                if (numero2 == 0 || numero2 < 0 || numero2 == numero1)
                {
                    Console.WriteLine("Por favor, vuelve a ingresar el numero.");
                }
            }

            Console.WriteLine();
            Console.WriteLine("--------------------------------------");
            Console.WriteLine("              RESULTADO               ");
            Console.WriteLine("--------------------------------------");
            Console.WriteLine();

            Console.WriteLine($"El resultado de la suma es de: {suma(numero1, numero2)}");
            Console.WriteLine($"El resultado de la resta es de: {resta(numero1, numero2)}");
            Console.WriteLine($"El resultado de la multiplicacion es de: {resta(numero1, numero2)}");
            Console.WriteLine($"El resultado de la division es de: {multiplicacion(numero1, numero2)}");
            Console.WriteLine($"El residuo de la division es de: {residuo(numero1, numero2)}");

            Console.WriteLine();
            Console.WriteLine();

        }

        static int suma(int numero1, int numero2)
        {
            int resultadoSuma = numero1 + numero2;
            return resultadoSuma;
        }

        static int resta(int numero1, int numero2)
        {
            int resultadoResta = numero1 - numero2;
            return resultadoResta;
        }

        static int multiplicacion(int numero1, int numero2)
        {
            int resultadoMultiplicacion = numero1 * numero2;
            return resultadoMultiplicacion;
        }

        static int division(int numero1, int numero2)
        {
            int resultadoDivision = numero1 / numero2;
            return resultadoDivision;
        }

        static int residuo(int numero1, int numero2)
        {
            int resultadoResiduo = numero1 % numero2;
            return resultadoResiduo;
        }

    }
}

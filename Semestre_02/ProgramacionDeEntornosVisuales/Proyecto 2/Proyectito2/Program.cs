using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyectito2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double radioCirculo, baseTriangulo, alturaTriangulo, basePiramide, alturaPiramide, baseCilindro, tapaCilindro, alturaCilindro;
            double areaCirculo, perimetroCirculo, areaTriangulo, perimetroTriangulo, volumenPiramide, volumenCilindro;

            Console.WriteLine("         CALCULADORA DE AREAS Y PERIMETROS         ");
            Console.WriteLine("---------------------------------------------------");
            Console.WriteLine();

            Console.WriteLine("A continuacion ingresara los datos para la obtencion del area y perimetro del circulo.");
            Console.Write("Ingrese el radio del circulo: ");
            radioCirculo = double.Parse(Console.ReadLine());

            Console.WriteLine();

            Console.WriteLine("A continuacion ingresara los datos para la obtencion del area y perimetro del triangulo.");
            Console.Write("Ingrese la base del triangulo: ");
            baseTriangulo = double.Parse(Console.ReadLine());
            Console.Write("Ingrese la altura del triangulo: ");
            alturaTriangulo = double.Parse(Console.ReadLine());

            Console.WriteLine();

            Console.WriteLine("A continuacion ingresara los datos para la obtencion del volumen de una piramide.");
            Console.Write("Ingrese un lado de la base de la piramide: ");
            basePiramide = double.Parse(Console.ReadLine());
            Console.Write("Ingrese la altura de la piramide: ");
            alturaPiramide = double.Parse(Console.ReadLine());

            Console.WriteLine();

            Console.WriteLine("A continuacion ingresara los datos para la obtencion del volumen de un cilindro con diametros diferentes en la base y en la tapa.");
            Console.Write("Ingrese el diametro de la base del cilindro: ");
            baseCilindro = double.Parse(Console.ReadLine());
            Console.Write("Ingrese el diametro de la tapa del cilindro: ");
            tapaCilindro = double.Parse(Console.ReadLine());
            Console.Write("Ingrese la altura del cilindro: ");
            alturaCilindro = double.Parse(Console.ReadLine());


            Console.WriteLine();

            areaCirculo = Math.PI * (Math.Pow(radioCirculo, 2));
            perimetroCirculo = (2 * (Math.PI)) * radioCirculo;

            areaTriangulo = baseTriangulo * alturaTriangulo;
            perimetroTriangulo = baseTriangulo * 3;

            volumenPiramide = ((basePiramide * basePiramide) * alturaPiramide) / 3;
            volumenCilindro = (((Math.PI * alturaCilindro) / 6) * (Math.Pow(baseCilindro, 2) + (baseCilindro * tapaCilindro) + Math.Pow(tapaCilindro, 2)));

            Console.WriteLine("---------------------------------------------------");
            Console.WriteLine("El radio del circulo es de: " + radioCirculo);
            Console.WriteLine("El area total del circulo es de: " + areaCirculo);
            Console.WriteLine("El perimetro del circulo es de: " + perimetroCirculo);
            Console.WriteLine("---------------------------------------------------");
            Console.WriteLine("La base del triangulo es de: " + baseTriangulo);
            Console.WriteLine("La altura del triangulo es de: " + alturaTriangulo);
            Console.WriteLine("El area total del triangulo es de: " + areaTriangulo);
            Console.WriteLine("El perimetro del triangulo es de: " + perimetroTriangulo);
            Console.WriteLine("---------------------------------------------------");
            Console.WriteLine("El lado de la base de la piramide es de: " + basePiramide);
            Console.WriteLine("La altura de la piramide es de: " + alturaPiramide);
            Console.WriteLine("El volumen de la piramide es de: " + volumenPiramide);
            Console.WriteLine("---------------------------------------------------");
            Console.WriteLine("El diametro de la base del cilindro es de: " + baseCilindro);
            Console.WriteLine("El diametro de la tapa del cilindro es de: " + tapaCilindro);
            Console.WriteLine("La altura del cilindro es de: " + alturaCilindro);
            Console.WriteLine("El volumen del cilindro es de: " + volumenCilindro);
            Console.WriteLine();
            Console.WriteLine();

        }
    }
}
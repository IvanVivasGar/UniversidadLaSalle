using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _212_Sintaxis
{
    internal class Program
    {
        static void Main(string[] args)
        {

            /* Para hacer condiciones
             * <
             * >
             * >=
             * ==
             * ===
             * <=
             * 
             * Y las condicionales
             * & and
             * || or
             * 
             * Y la negacion
             * !
             * 
             * if
             * if()=>
             * else if()
             * else
             * 
             * for(){}
             * while(){} //PEDIR PERMISO
             * do{}while() //PEDIR PERDON
             */

            int edadMinima = 18;
            int edadMaxima = 60;
            int edadUsuario;

            Console.Write("Escribe tu edad: ");
            edadUsuario = int.Parse(Console.ReadLine());

            if (edadUsuario >= edadMinima)
            {
                Console.WriteLine("Puedes pasar por algunas cosas de adultos.");
            }
            else if (edadUsuario > 10 & edadUsuario < edadMinima)
            {
                Console.WriteLine("Te faltan unos 10 anios.");
            }
            else
            {
                Console.WriteLine("No se como llegaste hasta este punto");
            }

            //JUGAR CON EL OR
            if (edadUsuario < edadMaxima & edadUsuario >= edadMinima)
            {
                Console.WriteLine($"Tu edad está en el rango entre {edadMinima} y {edadMaxima}");
            }
            else if (edadUsuario > edadMaxima || edadUsuario < edadMinima)
            {
                Console.WriteLine($"Tu edad esta fuera del rango entre {edadMinima} y {edadMaxima}");
            }
            else
            {
                Console.WriteLine($"Bueno tu edad ees {edadUsuario}.");
            }

            Console.WriteLine("Nostromo: Fin de la transmision");

            Console.WriteLine();
            Console.WriteLine("-------------------------------------------------");
            Console.WriteLine();

            //PREGUNTAR NUMEROS DE LA SUERTE
            int elNumero = 55;
            int elNumeroIngresado;

            Console.Write("Ingresa un Numero: ");
            elNumeroIngresado = int.Parse(Console.ReadLine());

            if (elNumeroIngresado >= 0 && elNumeroIngresado != elNumero)
            {
                Console.WriteLine("Vamos por un buen camino");
            }
            else if (elNumeroIngresado < elNumero)
            {
                Console.WriteLine("Todavia falta para llegar al numero secreto");
            }
            else if (elNumeroIngresado > elNumero)
            {
                Console.WriteLine("El numero ingresado es mayor al numero secreto");
            }
            else if (elNumeroIngresado == elNumero)
            {
                Console.WriteLine("Ese es el numero secreto!!!");
            }

            //UN RANDOM PARA LUEGO USAR BUCLES
            Random elRandom = new Random();
            int elAleatorio = elRandom.Next(18, 80);

            Console.WriteLine($"El numero aleatorio es {elAleatorio}");
            for (int i = 0; i < elAleatorio; i++)
            {
                Console.WriteLine($"El valor de {i} se incrementara hasta llegar a a ser igual que {elAleatorio}");
            }

            //METODOS 
            int elNumero1, elNumero2;
            Console.WriteLine("Esto es un llamando a un metodo externo: ");
            miFuncioncita();
            Console.WriteLine("Ahora mandamos a llamar otra funcion");
            Console.WriteLine(unaSuma(8, 20));
            Console.WriteLine("------------------");
            Console.WriteLine("Usar variables desde otro metodo");
            Console.WriteLine("Definir las variables fuera de los metodos");
            Console.Write("Captura un numero: ");
            elNumero1 = int.Parse(Console.ReadLine());
            Console.Write("Captura un numero: ");
            elNumero2 = int.Parse(Console.ReadLine());

            static void miFuncioncita ()
            {
                Console.WriteLine("Esta es otra funcion, bueno, metodo");
                //EN ESTE CASO NO REGRESA NADA, POR EL VOID
            }

            static int unaSuma (int elNumero1, int elNumero2, int numeroResultado)
            {

            }


        }
    }
}
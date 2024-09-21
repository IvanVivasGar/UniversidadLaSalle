using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Objetos
{
    internal class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("------------------------------------");
            Console.WriteLine("         DRAGONES TARGARYEN         ");
            Console.WriteLine("------------------------------------");
            Console.WriteLine();

            Console.WriteLine("--------------------------------------------");
            Console.WriteLine("         FAMOSOS DRAGONES TARGARYEN         ");
            Console.WriteLine("--------------------------------------------");
            Console.WriteLine();

            TargaryenDragons dragoncillo = new TargaryenDragons();
            dragoncillo.SetNombre("Balerion");
            dragoncillo.SetTamano("Gigante");
            dragoncillo.SetColor("Negro");
            dragoncillo.SetMontador("Vyseris");
            dragoncillo.ToString();

            Console.WriteLine();
            Console.WriteLine();

            TargaryenDragons dragonsote = new TargaryenDragons();
            dragonsote.SetNombre("Syrax");
            dragonsote.SetTamano("Mediano");
            dragonsote.SetColor("Amarillo");
            dragonsote.SetMontador("Rhaenyra");
            dragonsote.ToString();

            Console.WriteLine(); 
            Console.WriteLine();

            Console.WriteLine("------------------------------------------");
            Console.WriteLine("         OTROS DRAGONES TARGARYEN         ");
            Console.WriteLine("------------------------------------------");
            Console.WriteLine();

            TargaryenDragonsRiders otroDragon  = new TargaryenDragonsRiders();
            otroDragon.SetNombre("Sunfyre");
            otroDragon.SetTamano("Mediano");
            otroDragon.SetColor("Dorado");
            otroDragon.SetMontador("Aegon II");
            otroDragon.ToString();

            Console.WriteLine(); 
            Console.WriteLine();

            Console.WriteLine("----------------------------------");
            Console.WriteLine("         EL ULTIMO DRAGON         ");
            Console.WriteLine("----------------------------------");
            Console.WriteLine();

            TheLastDragon dragonsin = new TheLastDragon();
            dragonsin.ToString();

            Console.WriteLine();
            Console.WriteLine();

            Console.WriteLine("-----------------------------------");
            Console.WriteLine("         DRAGONES SALVAJES         ");
            Console.WriteLine("-----------------------------------");
            Console.WriteLine();

            TargaryenNonDragonRiders uyuyuy = new TargaryenNonDragonRiders();
            uyuyuy.ToString();

            Console.WriteLine();
            Console.WriteLine();

            Console.WriteLine("---------------------------");
            Console.WriteLine("         MI DRAGON         ");
            Console.WriteLine("---------------------------");
            Console.WriteLine();

            TargaryenMyths voila = new TargaryenMyths();
            voila.ToString();

            Console.WriteLine();
            Console.WriteLine();

            Console.WriteLine("--------------------------------------------");
            Console.WriteLine("         DRAGON DE DAEMON TARGARYEN         ");
            Console.WriteLine("--------------------------------------------");
            Console.WriteLine();

            Daemon caraxes = new Daemon();
            caraxes.ToString();

            Console.WriteLine();
            Console.WriteLine();
        }
    }
}
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace LeerArcchivo
{
    internal class Program
    {
        static void Main(string[] args)
        {
            LeerArchivoSimple lector = new LeerArchivoSimple();
            lector.cantidadRenglones();
        }

        class LeerArchivoSimple
        {
            StreamReader file = null;
            int contador = 0;
            string renglon;

            public LeerArchivoSimple()
            {
                file = new StreamReader(@"C:\\Users\\Ivan\\Documents\\Universidad\\Semestre Dos\\Programacion Orientada a Entornos Visuales\\Visual Studio Code\\Proyecto Lector\\StreamReader.txt");
                while ((renglon = file.ReadLine()) != null)
                {
                    Console.WriteLine(renglon);
                    contador++;
                }
            }
            public void cantidadRenglones()
            {
                Console.WriteLine("El archivo tiene {0} renglones...", contador);
            }
            ~LeerArchivoSimple()
            {
                file.Close();
            }
        }
    }
}
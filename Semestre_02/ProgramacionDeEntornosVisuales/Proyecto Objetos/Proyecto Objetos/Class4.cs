using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Objetos
{
    public sealed class TargaryenNonDragonRiders : TargaryenDragons
    {
        public override void ToString()
        {
            Console.WriteLine($"ESTE ES UN DRAGON SALVAJE\n\nDRAGON: El carnicero \nMONTADOR: Ninguno \nTAMAÑO: Cubria una ciudad \nCOLOR: Negro");
        }
    }
}

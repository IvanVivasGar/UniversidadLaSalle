using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Objetos
{
    public class TargaryenDragonsRiders : TargaryenDragons
    {
        public override void ToString()
        {
            Console.WriteLine($"ESTE NO ES UN DRAGON HISTORICO\n\nDRAGON: {this.nombre} \nMONTADOR: {this.montador} \nTAMAÑO: {this.tamano} \nCOLOR: {this.color}");
        }
    }
}

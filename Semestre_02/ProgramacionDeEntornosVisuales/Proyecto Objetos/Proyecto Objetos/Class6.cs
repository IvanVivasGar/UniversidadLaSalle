using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Objetos
{
    public class TheLastDragon : MensajeUltimatum
    {
        public override void ToString()
        {
            Console.WriteLine($"ESTE ES EL ULTIMO DRAGON\n\nDRAGON: Sin nombre \nMONTADOR: Ninguno \nTAMAÑO: Como un gato \nCOLOR: Verde");
        }
    }
}

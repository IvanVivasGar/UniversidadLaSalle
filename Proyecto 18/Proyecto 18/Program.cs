using System;

namespace proyectito_del_18
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Empleado empleado1 = new Empleado("Ivan", Empleado.Puesto.Junior, Empleado.Incentivo.Normal, Empleado.Comision.Normal);
            decimal metaVentasEmpleado1 = 2500m;
            decimal percepcionTotalEmpleado1 = empleado1.ObtenerPercepcionTotal(metaVentasEmpleado1);
            Console.WriteLine("");
            Console.WriteLine($"Nombre de empleado: {empleado1.Nombre}\n" +
                              $"Puesto: {empleado1.PuestoActual}\n" +
                              $"Incentivo: {empleado1.IncentivoActual}\n" +
                              $"Comision: {empleado1.ComisionPorVenta}\n" +
                              $"Percepcion: {percepcionTotalEmpleado1}");

            Empleado empleado2 = new Empleado("Juan", Empleado.Puesto.Nuevo, Empleado.Incentivo.Normal, Empleado.Comision.Normal);
            decimal metaVentasEmpleado2 = 50000m;
            decimal percepcionTotalEmpleado2 = empleado2.ObtenerPercepcionTotal(metaVentasEmpleado2);
            Console.WriteLine("");
            Console.WriteLine($"Nombre de empleado: {empleado2.Nombre}\n" +
                              $"Puesto: {empleado2.PuestoActual}\n" +
                              $"Incentivo: {empleado2.IncentivoActual}\n" +
                              $"Comision: {empleado2.ComisionPorVenta}\n" +
                              $"Percepcion: {percepcionTotalEmpleado2}");

            Empleado empleado3 = new Empleado("Diego", Empleado.Puesto.Senior, Empleado.Incentivo.Consentido, Empleado.Comision.Elevado);
            decimal metaVentasEmpleado3 = 20000m;
            decimal percepcionTotalEmpleado3 = empleado3.ObtenerPercepcionTotal(metaVentasEmpleado3);
            Console.WriteLine("");
            Console.WriteLine($"Nombre de empleado: {empleado3.Nombre}\n" +
                              $"Puesto: {empleado3.PuestoActual}\n" +
                              $"Incentivo: {empleado3.IncentivoActual}\n" +
                              $"Comision: {empleado3.ComisionPorVenta}\n" +
                              $"Percepcion: {percepcionTotalEmpleado3}");

        }
        public static void imprimirDatosEmpleado()
        {

        }
        public class Empleado
        {
            public enum Puesto
            {
                Practicante,
                Pasante,
                Nuevo,
                Junior,
                Senior
            }

            public enum Incentivo
            {
                Nulo,
                Algo,
                Normal,
                Consentido
            }

            public enum Comision
            {
                Nada,
                Normal,
                Elevado
            }

            public string Nombre { get; set; }
            public Puesto PuestoActual { get; set; }
            public Incentivo IncentivoActual { get; set; }
            public Comision ComisionPorVenta { get; set; }

            public override string ToString()
            {
                return base.ToString();
            }

            public Empleado(string nombre, Puesto puesto, Incentivo incentivo, Comision comision)
            {
                Nombre = nombre;
                PuestoActual = puesto;
                IncentivoActual = incentivo;
                ComisionPorVenta = comision;
            }

            public decimal ObtenerPercepcionTotal(decimal metaVentas)
            {
                decimal sueldoBase = ObtenerSueldoBase();
                decimal incentivo = ObtenerIncentivo();
                decimal comision = ObtenerComisionPorVenta(metaVentas);
                return sueldoBase + incentivo + comision;
            }

            private decimal ObtenerSueldoBase()
            {
                switch (PuestoActual)
                {
                    case Puesto.Practicante:
                        return 2000m;
                    case Puesto.Pasante:
                        return 5000m;
                    case Puesto.Nuevo:
                        return 80000m;
                    case Puesto.Junior:
                        return 12000m;
                    case Puesto.Senior:
                        return 55000m;
                    default:
                        throw new InvalidOperationException("Puesto de empleado no válido");
                }
            }

            private decimal ObtenerIncentivo()
            {
                switch (IncentivoActual)
                {
                    case Incentivo.Nulo:
                        return 0m;
                    case Incentivo.Algo:
                        return 1000m;
                    case Incentivo.Normal:
                        return 2000m;
                    case Incentivo.Consentido:
                        return 5000m;
                    default:
                        throw new InvalidOperationException("Incentivo de empleado no válido");
                }
            }

            private decimal ObtenerComisionPorVenta(decimal metaVentas)
            {
                switch (ComisionPorVenta)
                {
                    case Comision.Nada:
                        return 0m;
                    case Comision.Normal:
                        return ObtenerSueldoBase() * 0.05m;
                    case Comision.Elevado:
                        return metaVentas * 0.1m;
                    default:
                        throw new InvalidOperationException("Comisión de empleado no válida");
                }
            }
        }


    }
}
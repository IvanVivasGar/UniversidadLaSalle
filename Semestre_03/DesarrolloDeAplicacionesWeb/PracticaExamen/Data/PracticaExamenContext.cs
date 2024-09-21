using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using RazorPagesMovie.Models;

namespace PracticaExamen.Data
{
    public class PracticaExamenContext : DbContext
    {
        public PracticaExamenContext (DbContextOptions<PracticaExamenContext> options)
            : base(options)
        {
        }

        public DbSet<RazorPagesMovie.Models.Alumnos> Alumnos { get; set; } = default!;
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using PracticaExamen.Data;
using RazorPagesMovie.Models;

namespace PracticaExamen.Pages_Alumnos
{
    public class IndexModel : PageModel
    {
        private readonly PracticaExamen.Data.PracticaExamenContext _context;

        public IndexModel(PracticaExamen.Data.PracticaExamenContext context)
        {
            _context = context;
        }

        public IList<Alumnos> Alumnos { get;set; } = default!;

        public async Task OnGetAsync()
        {
            if (_context.Alumnos != null)
            {
                Alumnos = await _context.Alumnos.ToListAsync();
            }
        }
    }
}

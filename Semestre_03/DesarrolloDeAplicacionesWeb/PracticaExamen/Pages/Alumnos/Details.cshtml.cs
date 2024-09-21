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
    public class DetailsModel : PageModel
    {
        private readonly PracticaExamen.Data.PracticaExamenContext _context;

        public DetailsModel(PracticaExamen.Data.PracticaExamenContext context)
        {
            _context = context;
        }

      public Alumnos Alumnos { get; set; } = default!; 

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null || _context.Alumnos == null)
            {
                return NotFound();
            }

            var alumnos = await _context.Alumnos.FirstOrDefaultAsync(m => m.Id == id);
            if (alumnos == null)
            {
                return NotFound();
            }
            else 
            {
                Alumnos = alumnos;
            }
            return Page();
        }
    }
}

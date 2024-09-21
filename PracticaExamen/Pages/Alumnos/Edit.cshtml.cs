using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using PracticaExamen.Data;
using RazorPagesMovie.Models;

namespace PracticaExamen.Pages_Alumnos
{
    public class EditModel : PageModel
    {
        private readonly PracticaExamen.Data.PracticaExamenContext _context;

        public EditModel(PracticaExamen.Data.PracticaExamenContext context)
        {
            _context = context;
        }

        [BindProperty]
        public Alumnos Alumnos { get; set; } = default!;

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null || _context.Alumnos == null)
            {
                return NotFound();
            }

            var alumnos =  await _context.Alumnos.FirstOrDefaultAsync(m => m.Id == id);
            if (alumnos == null)
            {
                return NotFound();
            }
            Alumnos = alumnos;
            return Page();
        }

        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see https://aka.ms/RazorPagesCRUD.
        public async Task<IActionResult> OnPostAsync()
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }

            _context.Attach(Alumnos).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AlumnosExists(Alumnos.Id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return RedirectToPage("./Index");
        }

        private bool AlumnosExists(int id)
        {
          return (_context.Alumnos?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}

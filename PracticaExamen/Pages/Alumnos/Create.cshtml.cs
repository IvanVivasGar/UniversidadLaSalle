using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using PracticaExamen.Data;
using RazorPagesMovie.Models;

namespace PracticaExamen.Pages_Alumnos
{
    public class CreateModel : PageModel
    {
        private readonly PracticaExamen.Data.PracticaExamenContext _context;

        public CreateModel(PracticaExamen.Data.PracticaExamenContext context)
        {
            _context = context;
        }

        public IActionResult OnGet()
        {
            return Page();
        }

        [BindProperty]
        public Alumnos Alumnos { get; set; } = default!;
        

        // To protect from overposting attacks, see https://aka.ms/RazorPagesCRUD
        public async Task<IActionResult> OnPostAsync()
        {
          if (!ModelState.IsValid || _context.Alumnos == null || Alumnos == null)
            {
                return Page();
            }

            _context.Alumnos.Add(Alumnos);
            await _context.SaveChangesAsync();

            return RedirectToPage("./Index");
        }
    }
}

using first_api.data;
using first_api.model;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace first_api.controller;

public class PessoasController : Controller
{
    private readonly AppDbContext _context;

    public PessoasController(AppDbContext context)
    {
        _context = context;
    }

    public async Task<IActionResult> Index()
    {
        var pessoas = await _context.Pessoas.Include(p => p.Enderecos).ToListAsync();
        return View(pessoas);
    }

    public IActionResult Create()
    {
        return View();
    }

    [HttpPost]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> Create([Bind("Nome,Idade,Email")] Pessoa pessoa)
    {
        if (ModelState.IsValid)
        {
            _context.Add(pessoa);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }
        
        return View(pessoa);
    }

    public async Task<IActionResult> Edit(int id)
    {
        var pessoa = await _context.Pessoas.FindAsync(id);
        if (pessoa == null)
        {
            return NotFound();
        }
        
        return View(pessoa);
    }

    [HttpPost]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> Edit(int id, [Bind("Nome,Idade,Email")] Pessoa pessoa)
    {
        if (id != pessoa.Id)
        {
            return NotFound();
        }

        if (ModelState.IsValid)
        {
            try
            {
                _context.Update(pessoa);
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PessoaExists(pessoa.Id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }
            
            return RedirectToAction(nameof(Index));
        }
        
        return View(pessoa);
    }

    private bool PessoaExists(int id)
    {
        return _context.Pessoas.Any(e => e.Id == id);
    }
    
}
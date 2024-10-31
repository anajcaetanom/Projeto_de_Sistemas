using first_api.model;
using Microsoft.AspNetCore.Mvc;

namespace first_api.controller;

[ApiController]
[Route("api/pessoas")]
public class PessoasController : ControllerBase
{
    public static readonly List<Pessoa> pessoasList = new List<Pessoa>();

    [HttpPost]
    public ActionResult<Pessoa> CreatePessoa([FromBody] Pessoa pessoa)
    {
        pessoa.Id = pessoasList.Count + 1;
        pessoasList.Add(pessoa);
        return CreatedAtAction(nameof(GetPessoa), new { id = pessoa.Id }, pessoa);
    }

    [HttpGet("{id}")]
    public ActionResult<Pessoa> GetPessoa(int id)
    {
        var pessoa = pessoasList.FirstOrDefault(p => p.Id == id);
        
        if (pessoa == null) return NotFound("Pessoa não encontrada.");
        
        return Ok(pessoa);
    }
    
}
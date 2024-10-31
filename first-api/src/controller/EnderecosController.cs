using first_api.model;
using Microsoft.AspNetCore.Mvc;

namespace first_api.controller;

[ApiController]
[Route("api/enderecos")]
public class EnderecosController : ControllerBase
{
    [HttpPost]
    public ActionResult<Endereco> CreateEndereco([FromBody] Endereco endereco)
    {
        var pessoa = PessoasController.pessoasList.FirstOrDefault(p => p.Id == endereco.PessoaId);

        if (pessoa == null)
        {
            return NotFound("Pessoa não encontrada.");
        }

        endereco.Id = pessoa.Enderecos.Count + 1;
        pessoa.Enderecos.Add(endereco);
        
        return CreatedAtAction(nameof(PessoasController.GetPessoa()), new { id = endereco.PessoaId }, endereco);
    }


    
}
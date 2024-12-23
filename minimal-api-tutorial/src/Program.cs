using Microsoft.EntityFrameworkCore;
using minimal_api_tutorial.data;
using minimal_api_tutorial.model;

namespace minimal_api_tutorial;

public class Program
{
    public static void Main(string[] args)
    {
        var builder = WebApplication.CreateBuilder(args);
        builder.Services.AddDbContext<PessoaEnderecoDb> (
            opt => opt.UseInMemoryDatabase("PessoaEndereco"));
        builder.Services.AddDatabaseDeveloperPageExceptionFilter();
        
        // Swagger
        builder.Services.AddEndpointsApiExplorer();
        builder.Services.AddOpenApiDocument(config =>
        {
            config.DocumentName = "minimal-api-tutorial";
            config.Title = "minimal-api-tutorial v1";
            config.Version = "v1";
        });
        
        // Build app
        var app = builder.Build();
        
        // Swagger
        if (app.Environment.IsDevelopment())
        {
            app.UseOpenApi();
            app.UseSwaggerUi(config =>
            {
                config.DocumentTitle = "minimal-api-tutorial";
                config.Path = "/swagger";
                config.DocumentPath = "/swagger/minimal-api-tutorial/swagger.json";
                config.DocExpansion = "list";
            });
        }
        
        // GET todas as pessoas
        app.MapGet("/pessoas", async (PessoaEnderecoDb db) =>
        {
            var pessoas = await db.Pessoas
                .Include(p => p.Enderecos)
                .ToListAsync();

            return Results.Ok(pessoas);
        });
        
        // GET pessoa específica
        app.MapGet("pessoas/{id}", async (PessoaEnderecoDb db, int id) =>
        {
            var pessoa = await db.Pessoas
                .Include(p => p.Enderecos)
                .FirstOrDefaultAsync(p => p.Id == id);
            
            if (pessoa is not null)
                return Results.Ok(pessoa);
            else
                return Results.NotFound();
        });
        
        // POST Pessoa
        app.MapPost("/pessoas", async (Pessoa pessoa, PessoaEnderecoDb db) =>
        {
            db.Pessoas.Add(pessoa);
            await db.SaveChangesAsync();

            return Results.Created($"/pessoas/{pessoa.Id}", pessoa);
        });
        
        // POST Endereço
        app.MapPost("/endereco", async (Endereco endereco, PessoaEnderecoDb db) =>
        {
            db.Enderecos.Add(endereco);
            await db.SaveChangesAsync();
            
            return Results.Created($"/enderecos/{endereco.Id}", endereco);
        });
        
        // PUT Pessoa
        app.MapPut("/pessoas/{id}", async (int id, Pessoa pessoaInput, PessoaEnderecoDb db) =>
        {
            var pessoa = await db.Pessoas.FindAsync(id);
            if (pessoa is null)
                return Results.NotFound();
            else
            {
                pessoa.Nome = pessoaInput.Nome;
                pessoa.Idade = pessoaInput.Idade;
                pessoa.Email = pessoaInput.Email;
                pessoa.Enderecos = pessoaInput.Enderecos;
                
                await db.SaveChangesAsync();

                return Results.NoContent();
            }
        });
        
        // PUT Endereço
        app.MapPut("/endereco/{id}", async (int id, Endereco enderecoInput, PessoaEnderecoDb db) =>
        {
            var endereco = await db.Enderecos.FindAsync(id);
            if (endereco is null)
                return Results.NotFound();
            else
            {
                endereco.Rua = enderecoInput.Rua;
                endereco.Numero = enderecoInput.Numero;
                endereco.Estado = enderecoInput.Estado;
                endereco.Cidade = enderecoInput.Cidade;
                endereco.Bairro = enderecoInput.Bairro;
                endereco.PessoaId = enderecoInput.PessoaId;
                
                await db.SaveChangesAsync();
                
                return Results.NoContent();
            }
        });
        
        // DELETE Pessoa
        app.MapDelete("/pessoas/{id}", async (PessoaEnderecoDb db, int id) =>
        {
            if (await db.Pessoas.FindAsync(id) is Pessoa pessoa)
            {
                db.Pessoas.Remove(pessoa);
                await db.SaveChangesAsync();
                
                return Results.NoContent();
            }
            else
                return Results.NotFound();
        });
        
        // DELETE Endereço
        app.MapDelete("/endereco/{id}", async (int id, PessoaEnderecoDb db) =>
        {
            if (await db.Enderecos.FindAsync(id) is Endereco endereco)
            {
                db.Enderecos.Remove(endereco);
                await db.SaveChangesAsync();
                
                return Results.NoContent();
            }
            else 
                return Results.NotFound();
        });

        app.Run();
    }
}
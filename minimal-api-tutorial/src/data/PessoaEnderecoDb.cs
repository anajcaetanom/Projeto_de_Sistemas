using Microsoft.EntityFrameworkCore;
using minimal_api_tutorial.model;

namespace minimal_api_tutorial.data;

public class PessoaEnderecoDb : DbContext
{
    public PessoaEnderecoDb(DbContextOptions<PessoaEnderecoDb> options)
        : base(options) { }

    public DbSet<Pessoa> Pessoas => Set<Pessoa>();
    public DbSet<Endereco> Enderecos => Set<Endereco>();
}
using Microsoft.EntityFrameworkCore;
using minimal_api_tutorial.model;

namespace minimal_api_tutorial.data;

public class PessoaEnderecoDb : DbContext
{
    public PessoaEnderecoDb(DbContextOptions<PessoaEnderecoDb> options)
        : base(options) { }

    public DbSet<Pessoa> Pessoas => Set<Pessoa>();
    public DbSet<Endereco> Enderecos => Set<Endereco>();

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        // Especifícações de Pessoa
        modelBuilder.Entity<Pessoa>()
            .HasKey(p => p.Id);

        modelBuilder.Entity<Pessoa>()
            .Property(p => p.Nome)
            .IsRequired()
            .HasMaxLength(100);
        
        modelBuilder.Entity<Pessoa>()
            .Property(p => p.Email)
            .IsRequired()
            .HasMaxLength(100);
        
        // Especifícações de Endereço
        modelBuilder.Entity<Endereco>()
            .HasKey(endereco => endereco.Id);

        modelBuilder.Entity<Endereco>()
            .Property(e => e.Estado)
            .IsRequired()
            .HasMaxLength(100);

        modelBuilder.Entity<Endereco>()
            .Property(e => e.Cidade)
            .IsRequired()
            .HasMaxLength(100);
        
        modelBuilder.Entity<Endereco>()
            .Property(e => e.Bairro)
            .IsRequired()
            .HasMaxLength(100);
        
        modelBuilder.Entity<Endereco>()
            .Property(e => e.Rua)
            .IsRequired()
            .HasMaxLength(100);

        modelBuilder.Entity<Endereco>()
            .Property(e => e.Numero)
            .IsRequired()
            .HasMaxLength(100);
        
        // Relação entre Pessoa e Endereço
        modelBuilder.Entity<Pessoa>()
            .HasMany(p => p.Enderecos)
            .WithOne()
            .HasForeignKey(p => p.PessoaId);

    }
}
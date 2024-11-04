namespace minimal_api_tutorial.model;

public class Endereco
{
    public int Id { get; set; }
    public string Estado { get; set; }
    public string Cidade { get; set; }
    public string Bairro { get; set; }
    public string Rua { get; set; }
    public string Numero { get; set; }
    public int PessoaId { get; set; }
}
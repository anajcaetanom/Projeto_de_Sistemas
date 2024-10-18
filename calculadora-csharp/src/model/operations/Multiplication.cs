namespace calculadora_csharp.model.operations;

public class Multiplication : IOperation
{
    public int Id { get; set; } = 3;
    

    public float Operate(float num1, float num2)
    {
        return num1 * num2;
    }

}
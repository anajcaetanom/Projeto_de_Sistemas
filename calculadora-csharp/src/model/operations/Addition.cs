namespace calculadora_csharp.model.operations;

public class Addition : IOperation
{
    public int Id { get; } = 1;

    
    public float Operate(float num1, float num2)
    {
        return num1 + num2;
    }

}
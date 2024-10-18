using System.Runtime.CompilerServices;

namespace calculadora_csharp.model.operations;

public class Subtraction : IOperation
{
    public int Id { get; set; } = 2;
    
    
    public float Operate(float num1, float num2)
    {
        return num1 - num2;
    }

}
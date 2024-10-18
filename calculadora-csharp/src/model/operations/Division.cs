using System;

namespace calculadora_csharp.model.operations;

public class Division : IOperation
{
    public int Id { get; set; } = 4;

    
    public float Operate(float num1, float num2) 
    {
        if (num2 == 0)
        {
            throw new ArithmeticException();
        }
        else
        {
            return num1 / num2;
        }
    }
    
}
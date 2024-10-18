namespace calculadora_csharp.model.operations;

public interface IOperation  
{
    int Id { get; }
    
    float Operate(float num1, float num2);


}
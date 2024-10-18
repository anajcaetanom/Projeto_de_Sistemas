using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using calculadora_csharp.model.operations;

namespace calculadora_csharp.model;

public class CalculatorModel
{
    public List<Type> GetClassesNames()
    {
        var assembly = Assembly.GetExecutingAssembly();
        var classes = assembly.GetTypes()
                                        .Where(IsValidOperationType)
                                        .ToList();
        
        return classes;
    }
    
    private bool IsValidOperationType(Type type)
    {
        return typeof(IOperation).IsAssignableFrom(type) && !type.IsAbstract && !type.IsInterface;
    }

    public void SortClassList(List<Type> classList)
    {
        classList.Sort((c1, c2) =>
        {
            try
            {
                var instance1 = Activator.CreateInstance(c1) as IOperation;
                var instance2 = Activator.CreateInstance(c2) as IOperation;
                
                if (instance1 != null && instance2 != null)
                {
                    return instance1.Id.CompareTo(instance2.Id);
                }
                
                return -1;
            }
            catch (Exception e)
            {
                Console.WriteLine("Erro no SortClassList");
                return -1;
            }
        });
    }
    
    
}
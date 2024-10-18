using System;
using System.Collections.Generic;
using calculadora_csharp.model;
using calculadora_csharp.model.dto;
using calculadora_csharp.model.operations;
using calculadora_csharp.view;

namespace calculadora_csharp.controller;

public class CalculatorController(CalculatorView view, CalculatorModel model)
{
    public CalculatorView View = view;
    public CalculatorModel Model = model;

    public RequestDto ShowMenuAndGetInput()
    {
        List<Type> classList = model.GetClassesNames();
        model.SortClassList(classList);
        view.DynamicMenu(classList);

        return view.CollectInput();
    }

    public IOperation GetOperation(int option)
    {
        List<Type> classList = model.GetClassesNames();

        try
        {
            foreach (var clazz in classList)
            {
                var instance = Activator.CreateInstance(clazz) as IOperation;
                int id = instance?.Id ?? -1;

                if (option == id)
                {
                    return instance;
                }
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }

        return null;
    }

    public float Calculate(RequestDto dto)
    {
        var option = (int) dto.Option;
        
        if (option == 0) { return 0; }
        
        var operation = GetOperation(option);

        if (operation == null)
        {
            throw new Exception("operação nula.");
        }
        else
        {
            return operation.Operate(dto.Number1, dto.Number2);
        }
    }
}
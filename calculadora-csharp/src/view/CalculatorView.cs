using System;
using System.Collections.Generic;
using calculadora_csharp.model.dto;
using calculadora_csharp.model.operations;

namespace calculadora_csharp.view;

public class CalculatorView
{
    public void DynamicMenu(List<Type> sortedClassList)
    {
        Console.WriteLine("<3•···········• C# CALCULATOR •···········•<3\n");
        try
        {
            foreach (Type type in sortedClassList)
            {
                var instance = Activator.CreateInstance(type) as IOperation;
                int id = instance.Id;
                Console.WriteLine($"{id}: {type.Name}");
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }

        Console.WriteLine("0: Sair\n");
        Console.Write("Pick a number: ");
    }

    public float GetUserInput()
    {
        float input = 0;
        bool validInput = false;

        while (!validInput)
        {
            try
            {
                input = float.Parse(Console.ReadLine());
                validInput = true;
            }
            catch (FormatException)
            {
                Console.WriteLine("Nao pode letra.");
            }
        }

        return input;
    }

    public RequestDto CollectInput()
    {
        float number1;
        float number2;
        
        float option = GetUserInput();

        while (option < 0 || option > 4)
        {
            Console.WriteLine("Invalid input.");
            option = GetUserInput();
        }

        if (option == 0)
        {
            Console.WriteLine("tchauuuu\n");
            return new RequestDto(0, 0, 0);
        }
        else
        {
            Console.Write("Type first number:");
            number1 = GetUserInput();
            Console.WriteLine("Type second number:");
            number2 = GetUserInput();
        }

        return new RequestDto(option, number1, number2);
    }
    
    
}
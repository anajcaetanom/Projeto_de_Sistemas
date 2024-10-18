// See https://aka.ms/new-console-template for more information

using System;
using calculadora_csharp.controller;
using calculadora_csharp.model;
using calculadora_csharp.view;

namespace calculadora_csharp;
public class Program
{
    public static void Main(string[] args)
    {
        var view = new CalculatorView();
        var model = new CalculatorModel();
        var controller = new CalculatorController(view, model);
        
        var dto = controller.ShowMenuAndGetInput();
        
        var resultado = controller.Calculate(dto);

        Console.WriteLine($"Resultado: {resultado}");
    }
}
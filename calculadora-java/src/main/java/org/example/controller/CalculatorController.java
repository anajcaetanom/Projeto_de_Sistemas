package org.example.controller;

import org.example.model.dto.RequestDTO;

public class CalculatorController {
    private RequestDTO requestDTO;
    private ClassLoader classLoader;

    public CalculatorController(RequestDTO requestDTO, ClassLoader classLoader) {
        this.classLoader = classLoader;
        this.requestDTO = requestDTO;
    }
/*
    public Float calculate() {
        int optionInt = (int) requestDTO.getOption();
        float number1 = requestDTO.getNumber1();
        float number2 = requestDTO.getNumber2();



        try {
            return switch (optionInt) {
                case 1 -> model.somar(number1, number2);
                case 2 -> model.subtrair(number1, number2);
                case 3 -> model.multiplicar(number1, number2);
                case 4 -> model.dividir(number1, number2);
                default -> throw new IllegalStateException();
            };
        } catch (ArithmeticException e) {
            System.out.print("não pode divisão por zeroooo >:(");
        }

        return null;
    }
*/
}

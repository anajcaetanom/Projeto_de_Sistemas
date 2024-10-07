package controller;

import dto.RequestDTO;
import model.CalculatorModel;

public class CalculatorController {
    private CalculatorModel model;
    private RequestDTO requestDTO;

    public CalculatorController(RequestDTO requestDTO, CalculatorModel model) {
        this.model = model;
        this.requestDTO = requestDTO;
    }

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
            System.out.print("não pode divisão por zeroooo");
        }

        return null;
    }

}

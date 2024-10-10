package org.example.controller;

import org.example.model.CalculatorModel;
import org.example.model.dto.RequestDTO;
import org.example.model.operations.IOperation;
import org.example.view.CalculatorView;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
    }

    public RequestDTO showMenuAndGetInput() {
        List<Class<? extends IOperation>> classList = model.getClassesNames();
        model.sortClassList(classList);
        view.dynamicMenu(classList);

        return view.collectInput();
    }

    public IOperation getOperation(int option) {
        List<Class<? extends IOperation>> classList = model.getClassesNames();

        try {
            for (Class<? extends IOperation> clazz : classList) {
                IOperation instance = (IOperation) clazz.getDeclaredConstructor().newInstance();
                int id = instance.getId();
                if (option == id) {
                    return instance;
                };
            }
        } catch (NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            System.out.print("erro");
        }

        return null;
    }

    public Float calculate(RequestDTO dto) {
        int option = (int) dto.getOption();

        IOperation operation = getOperation(option);

        return operation.operate(dto.getNumber1(), dto.getNumber2());
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

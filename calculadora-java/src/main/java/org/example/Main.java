package org.example;

import org.example.controller.CalculatorController;
import org.example.model.CalculatorModel;
import org.example.model.dto.RequestDTO;
import org.example.model.operations.IOperation;
import org.example.view.CalculatorView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);

        RequestDTO dto = controller.showMenuAndGetInput();
        Float resultado = controller.calculate(dto);

        System.out.print(resultado);
    }
}
package org.example.view;

import org.example.model.dto.RequestDTO;
import org.example.model.operations.IOperation;
import org.reflections.Reflections;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CalculatorView {


    public void dynamicMenu() {

        Reflections reflections = new Reflections("org.example.model.operations");

        Set<Class<? extends IOperation>> classes = reflections.getSubTypesOf(IOperation.class);

        for (Class<? extends IOperation> clazz : classes) {
            System.out.println("Classe que implementa IOperation: " + clazz.getSimpleName());
        }

    }

    public void showMenu() {
        //reflection: varre as classes IOperation e monta o menu

        System.out.print("""
               ✦•···········• JAVA CALCULATOR •···········•✦
               \s
               1. Addition
               2. Subtraction
               3. Multiplication
               4. Division
               0. Sair
               \s
               Pick a number:\s
               """
        );
    }

    public void showMessage(String message) {
        System.out.print(message);
    }

    public float getUserInput() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("nao pode letra .");
        }

        return 0;
    }

    public RequestDTO showInterfaceAndCollectInput() {
        showMenu();

        float option = getUserInput();

        while (option < 0 || option > 4) {
            System.out.println("Invalid option.");
            option = getUserInput();
        }

        if (option == 0) {
            System.out.println("tchau");
        } else {
            showMessage("Type first number: ");
            float number1 = getUserInput();
            while (number1 == 0) {
                showMessage("Type first number: ");
                number1 = getUserInput();
            }
            showMessage("Type second number: ");
            float number2 = getUserInput();
            while (number2 == 0) {
                showMessage("Type second number: ");
                number2 = getUserInput();
            }

            return new RequestDTO(option, number1, number2);
        }

        return null;
    }


}

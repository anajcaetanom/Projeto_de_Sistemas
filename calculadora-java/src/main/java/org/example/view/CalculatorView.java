package org.example.view;

import org.example.model.dto.RequestDTO;
import org.example.model.operations.IOperation;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CalculatorView {

    public void dynamicMenu(List<Class<? extends IOperation>> sortedClassList) {

        System.out.println("✦•···········• JAVA CALCULATOR •···········•✦\n");
        try {
            for (Class<? extends IOperation> clazz : sortedClassList) {
                IOperation instance = (IOperation) clazz.getDeclaredConstructor().newInstance();
                int id = instance.getId();
                System.out.println(id + ": " + clazz.getSimpleName());
            }
        } catch (NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException | InstantiationException e) {
            System.out.println("erro");
        }

        System.out.print("\nPick a number: ");

    }

    public void showMenu() {

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

    public RequestDTO collectInput() {
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

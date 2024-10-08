package view;

import dto.RequestDTO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorView {


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

    public void showInterfaceAndCollectInput() {
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

            createRequestDTO(option, number1, number2);
        }
    }

    public RequestDTO createRequestDTO(float option,float number1,float number2) {
        return new RequestDTO(option, number1, number2);
    }


}

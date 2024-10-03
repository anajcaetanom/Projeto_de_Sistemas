package view;

import dto.RequestDTO;
import java.util.Scanner;

public class CalculatorView {


    public void showMenu() {

        System.out.print(
                """
                ✦•···········• JAVA CALCULATOR •···········•✦
                
                1. Addition
                2. Subtraction
                3. Multiplication
                4. Division
                
                Pick a number: """
        );
    }

    public void showMessage(String message) {
        System.out.print(message);
    }

    public float getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextFloat();
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
            return null;
        } else {
            showMessage("Type first number: ");
            float number1 = getUserInput();
            showMessage("Type second number: ");
            float number2 = getUserInput();

            return new RequestDTO(option, number1, number2);
        }
    }


}

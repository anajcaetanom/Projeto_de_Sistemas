package view;

public class CalculatorView {



    public String menu() {

        return
                """
                
                ✦•···········• JAVA CALCULATOR •···········•✦
                
                1. Addition
                2. Subtraction
                3. Multiplication
                4. Division
                
                Pick a number: """;
    }

    public void showMenu() {
        System.out.printf(this.menu());
    }


}

import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController();
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();

        view.showMenu();



    }
}
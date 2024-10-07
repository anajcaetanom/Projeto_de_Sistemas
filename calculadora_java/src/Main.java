import controller.CalculatorController;
import dto.RequestDTO;
import model.CalculatorModel;
import view.CalculatorView;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();

        if (view.showInterfaceAndCollectInput() != null) {
            RequestDTO requestDTO = view.showInterfaceAndCollectInput();
            CalculatorController controller = new CalculatorController(requestDTO, model);
            if (controller.calculate() != null) {
                System.out.println("Resultado: " + controller.calculate());
            }
        }
    }
}
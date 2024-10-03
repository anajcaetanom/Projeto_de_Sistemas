import controller.CalculatorController;
import dto.RequestDTO;
import model.CalculatorModel;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();

        RequestDTO requestDTO = view.showInterfaceAndCollectInput();

        CalculatorController controller = new CalculatorController(requestDTO, model);

        try {
            float resultado = controller.calculate();
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("zero nao podeee");
        }


    }
}
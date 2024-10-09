import classloader.ClassLoader;
import dto.RequestDTO;
import view.CalculatorView;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        ClassLoader classLoader = new ClassLoader();
        CalculatorView view = new CalculatorView();
        // RequestDTO requestDTO = view.showInterfaceAndCollectInput();
        // CalculatorController controller = new CalculatorController(requestDTO, classLoader);

        List<Class<?>> operationsList = classLoader.loadOperations();


    }
}

/*
if (view.showInterfaceAndCollectInput() != null) {
    RequestDTO requestDTO = view.showInterfaceAndCollectInput();
    CalculatorController controller = new CalculatorController(requestDTO, model);
    if (controller.calculate() != null) {
        System.out.println("Resultado: " + controller.calculate());
    }
}
*/
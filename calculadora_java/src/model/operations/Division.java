package model.operations;

public class Division implements IOperation {

    public float dividir (float valor1, float valor2) throws ArithmeticException {
        if (valor2 == 0) {
            throw new ArithmeticException();
        } else {
            return valor1 / valor2;
        }
    }
}

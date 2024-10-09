package model.operations;

import src.model.IOperation;

public class Division implements IOperation {
    private static final int id = 4;

    public float dividir (float valor1, float valor2) throws ArithmeticException {
        if (valor2 == 0) {
            throw new ArithmeticException();
        } else {
            return valor1 / valor2;
        }
    }
}

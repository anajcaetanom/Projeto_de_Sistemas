package model.operations;

import src.model.IOperation;

public class Multiplication implements IOperation {
    private static final int id = 3;

    public float multiplicar (float valor1, float valor2) {
        return valor1 * valor2;
    }

}

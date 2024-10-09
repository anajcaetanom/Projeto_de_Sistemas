package model.operations;

import src.model.IOperation;

public class Subtraction implements IOperation {
    private static final int id = 2;

    public float subtrair (float valor1, float valor2) {
        return valor1 - valor2;
    }

}

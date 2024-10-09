package model.operations;

import src.model.IOperation;

public class Addition implements IOperation {
    private static final int id = 1;


    public float somar (float valor1, float valor2) {
        return valor1 + valor2;
    }

}

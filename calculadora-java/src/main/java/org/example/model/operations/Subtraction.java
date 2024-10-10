package org.example.model.operations;

public class Subtraction implements IOperation {
    private int id;

    public Subtraction() {
        this.id = 2;
    }

    public float operate (float valor1, float valor2) {
        return valor1 - valor2;
    }

    public int getId() {
        return id;
    }
}

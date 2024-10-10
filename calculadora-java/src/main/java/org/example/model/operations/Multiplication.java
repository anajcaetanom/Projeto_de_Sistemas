package org.example.model.operations;

public class Multiplication implements IOperation {
    private int id;

    public Multiplication() {
        this.id = 3;
    }

    public float operate (float valor1, float valor2) {
        return valor1 * valor2;
    }

    public int getId() {
        return id;
    }
}

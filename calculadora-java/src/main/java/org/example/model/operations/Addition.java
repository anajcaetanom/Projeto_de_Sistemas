package org.example.model.operations;

public class Addition implements IOperation {
    private int id;

    public Addition() {
        this.id = 1;
    }

    public float operate (float valor1, float valor2) {
        return valor1 + valor2;
    }

    public int getId() {
        return id;
    }
}

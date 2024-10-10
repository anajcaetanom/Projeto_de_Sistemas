package org.example.model.operations;

public class Division implements IOperation {
    private int id;

    public Division() {
        this.id = 4;
    }

    public float operate (float valor1, float valor2) throws ArithmeticException {
        if (valor2 == 0) {
            throw new ArithmeticException();
        } else {
            return valor1 / valor2;
        }
    }

    public int getId() {
        return id;
    }
}

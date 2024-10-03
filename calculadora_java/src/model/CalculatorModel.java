package model;

public class CalculatorModel {

    public float somar (float valor1, float valor2) {
        return valor1 + valor2;
    }

    public float subtrair (float valor1, float valor2) {
        return valor1 - valor2;
    }

    public float multiplicar (float valor1, float valor2) {
        return valor1 * valor2;
    }

    public float dividir (float valor1, float valor2) throws ArithmeticException {
        if (valor2 == 0) {
            throw new ArithmeticException("nao pode zeroooooo");
        } else {
            return valor1 / valor2;
        }
    }
}

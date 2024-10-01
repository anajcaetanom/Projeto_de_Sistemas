package model;

public class CalculatorModel {


    public float somar (float valor1, float valor2) {
        return valor1 + valor2;
    }

    public float diminuir (float valor1, float valor2) {
        return valor1 - valor2;
    }

    public float multiplicar (float valor1, float valor2) {
        return valor1 * valor2;
    }

    public float dividir (float valor1, float valor2) throws Exception {
        if (valor2 == 0) {
            throw new ArithmeticException("Denominador não pode ser zero.");
        }
        return valor1 / valor2;
    }
}

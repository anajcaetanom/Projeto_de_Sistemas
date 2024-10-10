package org.example.model.dto;

public class RequestDTO {
    private float option;
    private float number1;
    private float number2;

    public RequestDTO(float option, float number1, float number2) {
        this.option = option;
        this.number1 = number1;
        this.number2 = number2;
    }

    public float getOption() {
        return option;
    }

    public float getNumber1() {
        return number1;
    }

    public float getNumber2() {
        return number2;
    }

    public void setOption(float option) {
        this.option = option;
    }

    public void setNumber1(float number1) {
        this.number1 = number1;
    }

    public void setNumber2(float number2) {
        this.number2 = number2;
    }
}

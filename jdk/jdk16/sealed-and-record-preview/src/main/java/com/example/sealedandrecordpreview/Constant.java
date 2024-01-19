package com.example.sealedandrecordpreview;

public record Constant(double value) implements Expression {

    @Override
    public double evaluate() {
        return value;
    }
}
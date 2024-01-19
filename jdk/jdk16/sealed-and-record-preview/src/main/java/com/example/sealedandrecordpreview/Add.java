package com.example.sealedandrecordpreview;

public record Add(Expression left, Expression right) implements Expression {

    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

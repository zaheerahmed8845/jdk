package com.example.sealedandrecordpreview;

public sealed interface Expression permits Constant, Add, Multiply, Negate {

    double evaluate();

}

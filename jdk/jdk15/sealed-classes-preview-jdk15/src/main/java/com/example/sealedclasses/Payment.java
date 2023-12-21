package com.example.sealedclasses;

public sealed abstract class Payment permits CardPayment, CashPayment {

    public void paymentClassMethod() {
        System.out.println("Inside Payment Class Method");
    }
}

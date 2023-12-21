package com.example.sealedclasses;

public class DebitCardPayment extends CardPayment {

    public void debitCardPayment() {
        paymentClassMethod();
        //Payment class method can be accessed from here as CardPayment is a non-sealed class.
    }
}

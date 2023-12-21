package com.example.sealedsingleclass;

public sealed abstract class Payment {
}

final class CashPayment extends Payment {
}

non-sealed class CardPayment extends Payment {
}

final class CreditCardPayment extends CardPayment {
}

final class DebitCardPayment extends CardPayment {
}



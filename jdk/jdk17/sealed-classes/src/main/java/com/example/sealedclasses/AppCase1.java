package com.example.sealedclasses;

interface I1 {
}

class C1 {
}

public class AppCase1 {
    public static void main(String[] args) {
        AppCase1 app = new AppCase1();
        app.test(new C1());
    }

    public void test(C1 c) {
        if (c instanceof I1) {
            System.out.println("C1 is an type of I1");
        } else {
            System.out.println("C1 is not an type of I1");
        }
    }
}

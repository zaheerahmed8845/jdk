package com.example.sealedclasses;

interface I2 {
}

final class C2 implements I2 {
}
/*
//If this is marked as final and dos not extend I then it will throw a compile time error.
final class C2{

}
*/

public class AppCase2 {
    public static void main(String[] args) {
        AppCase2 app = new AppCase2();
        app.test(new C2());
    }

    public void test(C2 c) {
        if (c instanceof I2) {
            System.out.println("C2 is an type of I2");
        } else {
            System.out.println("C2 is not an type of I2");
        }
    }
}

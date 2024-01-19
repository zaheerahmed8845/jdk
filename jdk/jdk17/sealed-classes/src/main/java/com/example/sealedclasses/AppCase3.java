package com.example.sealedclasses;

interface I3 {
}

sealed class C3 permits D3, B3 {
}

//This will give a compilation error if a non-sealed class is not provided.
non-sealed class B3 extends C3 {
}

final class D3 extends C3 {
}

public class AppCase3 {
    public static void main(String[] args) {
        AppCase3 app = new AppCase3();
        app.test(new C3());
    }

    public void test(C3 c) {
        if (c instanceof I3) {
            System.out.println("C3 is an type of I3");
        } else {
            System.out.println("C3 is not an type of I3");
        }
    }
}

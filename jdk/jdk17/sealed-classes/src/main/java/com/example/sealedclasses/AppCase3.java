package com.example.sealedclasses;

interface I3 {
}

/*
//Case 1: This will give a compile time error as there are no sealed classes present.
sealed class C3  permits D3 {
}
*/


/*
//Case 2: This will not give a compile time error as it extends the interface.
sealed class C3  implements I3 permits D3 {
}
*/


//Case3: This will not give any compile time error as it has a non-sealed class in the subtype.
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

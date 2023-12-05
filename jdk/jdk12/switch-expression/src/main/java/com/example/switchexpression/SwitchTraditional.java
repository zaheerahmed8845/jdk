package com.example.switchexpression;

/*This is another example and can be used as reference*/
public class SwitchTraditional {

    public enum JAVA_VERSION {
        JavaSE6, JavaSE7, JavaSE8, JavaSE9, JavaSE10, JavaSE11, JavaSE12, JavaSE13
    }

    static JAVA_VERSION version = JAVA_VERSION.JavaSE7;

    public static void main(String[] argv) {

        switch (version) {
            case JavaSE6:
                System.out.println("Does not apply");
                break;
            case JavaSE7:
                System.out.println("Does not apply");

            case JavaSE8:
                System.out.println("Does not apply");

            case JavaSE9:
                System.out.println("Non-LTS");

            case JavaSE10:
                System.out.println("Non-LTS");

            case JavaSE11:
                String version = "JAVASE11";
                System.out.println(version + " is LTS");

            case JavaSE12:
                String version2 = "JAVASE12";
                System.out.println(version2 + " is Non-LTS");
            case JavaSE13:
                String version3 = "JAVASE13";
                System.out.println(version3 + " is Non-LTS");
            default:
                System.out.println("Does not apply or Java version is not defined.");

        }
    }
}

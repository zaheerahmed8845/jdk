package com.example.indentmethod;

public class StringIndentMethod {
    public static void main(String[] args) {

        //2 examples to show how to use indent
        indent_one();
        indent_two();
    }

    private static void indent_one() {
        var poem = "99 little bugs in the code.\n" +
                "99 little bugs in the code.\n" +
                "Take one down,patch it around.\n" +
                "127 little bugs in the code...";

        System.out.println(poem);

        var poemIndented = poem.indent(4);
        System.out.println(poemIndented);

        System.out.println("Back to no indentation....");
        var backToOriginal = poemIndented.indent(-4);
        System.out.println(backToOriginal);
    }

    private static void indent_two() {

        System.out.println("Example two - ");
        System.out.println("\nBefore indentation...");
        String newLine = System.getProperty("line.separator");
        var json = String.join(newLine,
                "\"round\": \"Matchday 1\",",
                "\"date\":  \"2021-04-06\",",
                "\"team1\": \"Real Madrid\",",
                "\"team2\": \"Barcelona\",",
                "\"score\": { \"ft\": [2, 1] }"
        );
        System.out.println("{\n" + json + "\n}");

        System.out.println("\nAfter indentation...");
        System.out.println("{\n" + json.indent(4) + "}");
    }

}

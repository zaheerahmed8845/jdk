package com.example.transformmethod;

import java.util.List;
import java.util.stream.Collectors;

public class StringTransformMethod {
    public static void main(String[] args) {

        //transform
        //Exercise : add a filter to the stream
        withoutTransform();
        withTransform();
    }


    private static void withoutTransform() {
        var joke = "the only programming joke i know is my code";
		/*Expected output-
		            "Only Programming Joke I Know Is My Code..."
		*/
        var result = upperCase(dropFirstWord(joke)).concat("...");
        System.out.println(result);
    }

    private static void withTransform() {
        var joke = "the only programming joke i know is my code";
        var result = joke.transform(StringTransformMethod::dropFirstWord)
                .transform(StringTransformMethod::upperCase)
                .concat("...");

        System.out.println(result);
    }

    private static String dropFirstWord(String string) {
        return List.of(string.split("\\W+"))
                .stream()
                .skip(1)
                .collect(Collectors.joining(" "));
    }


    private static String upperCase(String string) {
        return List.of(string.split("\\W+"))
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

}

package com.example.iterateusingpredicate;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IterateUsingPredicate {

    public static void streamIterateJava8() {
        System.out.println("Stream Iterate Method from Java 8");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::print);
    }

    public static void streamIterateWithoutLimitJava9() {
        System.out.println("\nStream Iterate Method without using limit Java 9");
        Stream.iterate(0, n -> n + 2)
                .takeWhile(n -> n < 20)
                .forEach(System.out::print);
    }

    public static void streamIterateWithPredicateJava9() {
        System.out.println("\nStream Iterate with Predicate Method Java 9");
        Stream.iterate(0, n -> n < 20, n -> n + 2)
                .forEach(System.out::print);
    }

    public static void primitiveStreamIterateWithPredicateJava9() {
        System.out.println("\nPrimitive Stream Iterate with Predicate Method Java 9");
        IntStream.iterate(0, n -> n < 20, n -> n + 2)
                .forEach(System.out::print);
    }

    public static void main(String[] args) {
        streamIterateJava8();
        streamIterateWithoutLimitJava9();
        streamIterateWithPredicateJava9();
        primitiveStreamIterateWithPredicateJava9();
    }
}

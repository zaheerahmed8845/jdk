package com.example.orelsethrow;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

//Example of orElseThrow method in Optional class.
public class OptionalOrElseThrow {

    public static void main(String[] args) {

        OptionalOrElseThrow optionalOrElse = new OptionalOrElseThrow();
        try {
            String largeWord = optionalOrElse.findLargeWord();
            System.out.println("Large word is : " + largeWord);
        } catch (NoSuchElementException ex) {
            System.out.println("No such element found exception");
        }
        try {
            String largeWordUsingOrElseThrowMethod = optionalOrElse.findLargeWordUsingOrElseThrowMethod();
            System.out.println("Large word using or else throw method : " + largeWordUsingOrElseThrowMethod);
        } catch (NoSuchElementException ex) {
            System.out.println("No such element found exception in optional using or else throw method");
        }

    }

    public String findLargeWord() {

        Optional<String> largeWord = searchLargeWord();
        //Avoid
        if (largeWord.isPresent()) {
            return largeWord.get();
        }
        throw new NoSuchElementException("Word not found...");
    }

    public String findLargeWordUsingOrElseThrowMethod() {

        Optional<String> largeWord = searchLargeWord();
        //Right way
        return largeWord.orElseThrow();

    }

    private Optional<String> searchLargeWord() {

        return Stream.of("football", "12345678", "hellojava")
                .filter(s -> s.length() >= 20)
                .findAny();
    }

}

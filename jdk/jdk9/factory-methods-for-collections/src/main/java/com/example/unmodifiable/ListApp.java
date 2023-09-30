package com.example.unmodifiable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {
        unmodifiableListWithAdd();
        unmodifiableListArraysAsList();
        unmodifiableListOf();
    }

    //Prior Java 8
    public static void unmodifiableListWithAdd(){
        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("DEF");
        list.add("XYZ");

        List<String> alphabets = Collections.unmodifiableList(list);
        System.out.println(alphabets);
    }
    public static void unmodifiableListArraysAsList(){
        List<String> alphabets = Collections.unmodifiableList(Arrays.asList("ABC","DEF","XYZ"));
        System.out.println(alphabets);
    }

    public static void unmodifiableListOf(){
        List<String> alphabets = List.of("ABC","DEF","XYZ");
        System.out.println(alphabets);

        List<String> one = List.of("a");
        List<String> two = List.of("a","b");
        List<String> ten = List.of("a","b","c","d","e","f","g","h","i","j");
        //An unmodifiable list is one on which we cannot invoke the add, remove and set method.
        //If this is invoke then it will give UnsupportedOperationException
        //alphabets.add("PQR");

    }
}
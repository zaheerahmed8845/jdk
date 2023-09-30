package com.example.unmodifiable;

import java.util.*;

public class SetApp {
    public static void main(String[] args) {
        unmodifiableSetWithAdd();
        unmodifiableSetArraysAsList();
        unmodifiableSetOf();
    }

    //Prior Java 8
    public static void unmodifiableSetWithAdd(){
        Set<String> set = new HashSet<>();
        set.add("ABC");
        set.add("DEF");
        set.add("XYZ");

        Set<String> alphabets = Collections.unmodifiableSet(set);
        System.out.println(alphabets);
    }
    public static void unmodifiableSetArraysAsList(){
        Set<String> alphabets = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("ABC","DEF","XYZ")));
        System.out.println(alphabets);
    }

    public static void unmodifiableSetOf(){
        Set<String> alphabets = Set.of("ABC","DEF","XYZ");
        System.out.println(alphabets);

        Set<String> one = Set.of("a");
        Set<String> two = Set.of("a","b");
        Set<String> ten = Set.of("a","b","c","d","e","f","g","h","i","j");
    }
}
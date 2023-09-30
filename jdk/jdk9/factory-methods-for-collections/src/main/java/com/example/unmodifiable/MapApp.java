package com.example.unmodifiable;

import java.util.*;

public class MapApp {
    public static void main(String[] args) {
        unmodifiableMapWithAdd();
        unmodifiableMapOf();
        unmodifiableMapWithTenElements();
    }

    //Prior Java 8
    public static void unmodifiableMapWithAdd(){
        Map<String, Integer> map = new HashMap<>();
        map.put("ABC",100);
        map.put("DEF",120);
        map.put("XYZ",50);

        Map<String, Integer> alphabets = Collections.unmodifiableMap(map);
        System.out.println(alphabets);
    }
    public static void unmodifiableMapOf(){
        Map<String, Integer> alphabets = Map.of("ABC",100, "DEF", 120, "XYZ", 50);
        System.out.println(alphabets);
    }

    public static void unmodifiableMapWithTenElements(){
        //If more than 10 entries
        Map<String, Integer> alphabets = Map.ofEntries(
                Map.entry("ABC",100),
                Map.entry("DEF", 120),
                Map.entry("XYZ", 50)
        );
        System.out.println(alphabets);
    }

}
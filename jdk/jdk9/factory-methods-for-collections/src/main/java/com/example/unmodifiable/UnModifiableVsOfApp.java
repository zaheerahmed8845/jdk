package com.example.unmodifiable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnModifiableVsOfApp {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ABC","DEF","XYZ");
        List<String> unList = Collections.unmodifiableList(list);
        //unList.add("PQR");//throws an UnsupportedOperationException
        list.set(2, "PQR");//we are adding this in the modifiable list from which the unmodifiable one is created.This will update the list as unList is just the view on the list collection.
        System.out.println("Unmodifiable List : "+unList); //Output: Unmodifiable List : [ABC, DEF, PQR]
    }
}

package com.example.stripindent;

public class StripIndent {

    public static void main(String[] args) {
        String customerJson = ""
                + "      {\n"
                + "        \"id\" : \"1234\",\n"
                + "        \"firstName\":\"Jack\",\n"
                + "        \"lastName\":\"Sparrow\"\n"
                + "      }";

        System.out.println(customerJson.stripIndent());
    }
}

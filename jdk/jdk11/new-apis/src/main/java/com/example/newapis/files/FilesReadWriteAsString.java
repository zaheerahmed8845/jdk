package com.example.newapis.files;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesReadWriteAsString {

    public static void main(String[] args) throws IOException {

        readString();
        writeString();
    }

    public static String getFilePath(String fileName) {
        try {
            URL res = FilesReadWriteAsString.class.getClassLoader().getResource(fileName);
            File file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();
            return absolutePath;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readString() throws IOException {
        System.out.println("Inside Read String Method");

        System.out.println("Read using readAllBytes method");

        String content = new String(Files.readAllBytes(Paths.get(getFilePath("file1.txt"))));
        System.out.println(content);

        System.out.println("Read using readString method");
        //new method added in JDK11.
        String contents = Files.readString(Paths.get(getFilePath("file1.txt")));
        System.out.println(contents);
    }

    private static void writeString() throws IOException {

        System.out.println("Inside Write String Method");

        Files.writeString(Paths.get(getFilePath("file2.txt")), "I am learning Java 11");

        var testContents = Files.readString(Paths.get(getFilePath("file2.txt")));
        System.out.println(testContents.equals("I am learning Java 11"));
    }
}

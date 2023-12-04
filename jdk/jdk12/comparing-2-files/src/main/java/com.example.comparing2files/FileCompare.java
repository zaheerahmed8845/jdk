package com.example.comparing2files;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCompare {

    public static String getFilePath(String fileName) {
        try {
            URL res = FileCompare.class.getClassLoader().getResource(fileName);
            File file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();
            return absolutePath;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        Path fileOnePath = Path.of(getFilePath("readme.txt"));
        Path fileTwoPath = Path.of(getFilePath("readmealso.txt"));

        long mismatchIndex = Files.mismatch(fileOnePath, fileTwoPath);

        System.out.println(mismatchIndex);
    }

}

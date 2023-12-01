package com.example.newapis.predicatenot;

import com.example.newapis.files.FilesReadWriteAsString;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateNot {

    private static final String FILE_PATH = getFilePath("file1.txt");

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

    public static void main(String[] args) throws IOException {

        nonBlankLinesLambda();
        nonBlankLinesMethodReference();
        nonBlankPredicateNot();
    }

    private static void nonBlankLinesLambda() throws IOException {

        try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) {

            //Option one.
            List<String> nonBlankLines = lines.filter(line -> !line.isBlank())
                    .collect(Collectors.toList());

            System.out.println(nonBlankLines);
        }
    }

    private static void nonBlankLinesMethodReference() throws IOException {

        try (var lines = Files.lines(Paths.get(FILE_PATH))) {
            //Option two
            List<String> nonBlankLines = lines.filter(((Predicate<String>) String::isBlank).negate())
                    .collect(Collectors.toList());
            System.out.println(nonBlankLines);
        }
    }

    private static void nonBlankPredicateNot() throws IOException {

        //Option three - Predicate.not (add static import)
        try (var lines = Files.lines(Paths.get(FILE_PATH))) {

            List<String> nonBlankLines = lines.filter(Predicate.not(String::isBlank))
                    .collect(Collectors.toList());

            System.out.println(nonBlankLines);
        }
    }
}


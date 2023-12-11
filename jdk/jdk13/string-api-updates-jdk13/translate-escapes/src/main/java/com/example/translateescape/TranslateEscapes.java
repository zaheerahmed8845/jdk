package com.example.translateescape;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TranslateEscapes {

    public static String getFilePath(String fileName) {
        try {
            URL res = TranslateEscapes.class.getClassLoader().getResource(fileName);
            File file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();
            return absolutePath;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        String withEscapes = "\"Java\t13\"";
        System.out.println(withEscapes);

        Map<Integer, List<String>> data;

        try (Stream<String> text = Files.lines(Path.of(getFilePath("escapes.txt")))) {
            data = text.filter(Predicate.not(String::isEmpty))
                    .map(String::translateEscapes)
                    .collect(Collectors.groupingBy(String::length));

        }
        System.out.println(data);
    }
}

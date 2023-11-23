package com.example.localvartypeinference;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class VarExamples {

    public static void main(String[] args) {

        //1.Var with literals - gives alignment
        literals();
        literalsWithVar();

        //2.Using var in for loop.
        forLoopOne(getNumbers());

        forLoopTwo();
        forLoopTwoWithVar();

        //3.Prefer explicit here
        Map<Genre, List<Movie>> movies = getMovies();
        //In this case we do not understand the type of movie, hence we should not use this.
        //var movies = getMovies();

        //4.Careful ! - This is a list of type Object - Defeats purpose.
        List<Integer> numbers = new ArrayList<>();
        //var numbers = new ArrayList<>();
        numbers.add(1);
        // If we use 'var' this becomes list of Object and this can be used.
        //numbers.add("One");

        //5. Give meaningful names
        MovieSearchCriteria movieSearchCriteria = new MovieSearchCriteria();
        MovieService service = new MovieService();
        List<Movie> movie = service.getMovies(movieSearchCriteria);

        //var movieSearchCriteria = new MovieSearchCriteria();
        //var movieService = new MovieService();
        //var movieList = service.getMovies(movieSearchCriteria);

        //6. Initializer
        List<String> vowels = List.of("a", "e", "i", "o", "u");
        //var vowelList = List.of("a","e","i","o","u");

        //7.Minimize the scope of local variables.
        scopeOfLocalVariables();

        //8.Using var in try with resource block
        readBatchFile();

        //9.Reading file using buffered reader -Assignment
        System.out.println("Assignment : Refactor readFileBufferedReader to use var");
        readFileBufferedReader();

        //10.Read from URL. - Assignment
        System.out.println("Assignment : Refactor readURL to use var");
        readURL();

        //11.break up chained or nested expressions with local variables.
        Optional<String> mostWatchedMovie = getMostWatchedMovie_1();
        System.out.println(mostWatchedMovie.orElse("No movie found"));

        //Step one
        Optional<String> mostWatchedMovieStepOne = getMostWatchedMovie_2();
        System.out.println(mostWatchedMovieStepOne.orElse("No movie found"));

        //Step two
        Optional<String> mostWatchedMovieStepTwo = getMostWatchedMovie_3();
        System.out.println(mostWatchedMovieStepTwo.orElse("No movie found"));
    }

    public static void literals() {
        boolean solved = false;
        long sum = 0L;
        CrimeSceneSearchCriteria crimeSceneSearchCriteria = new CrimeSceneSearchCriteria();
        String detective = "Sherlock Holmes";

        //be careful of var with literals
        byte signal = 0; // byte
        //var signal = 0; //int
    }

    public static void literalsWithVar() {
        /*
         * It gives better readability because of alignment as show below.
         * It may not always improve the readability of code, one should check with after making the changes.
         * When using meaningful names, to understand what the statement is all about.
         */
        var solved = false;
        var sum = 0L;
        var crimeSceneSearchCriteria = new CrimeSceneSearchCriteria();
        var detective = "Sherlock Holmes";

        //be careful of var with literals
        byte signal = 0; // byte
        //var signal = 0; //int
    }

    public static void forLoopOne(int[] numbers) {
        /*In this method making use of var, does not improve the readability of code significantly, hence its better not to use it in the below method*/
        int max = 0;
        for (int number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        System.out.println("Max is : " + max);
    }

    private static int[] getNumbers() {
        return new int[]{12, 4, 13, 36, 77, 500};
    }

    public static void forLoopTwo() {
        Map<String, List<String>> movieByGenre = new HashMap<>();

        movieByGenre.put("COMEDY", List.of("Hangover", "Pink Panther"));
        movieByGenre.put("ACTION", List.of("Bad Boys", "Pulp Fiction"));

        for (Map.Entry<String, List<String>> moviesInGenre : movieByGenre.entrySet()) {
            List<String> movies = moviesInGenre.getValue();
            //do something with movies.
        }
    }

    public static void forLoopTwoWithVar() {
        Map<String, List<String>> movieByGenre = new HashMap<>();

        movieByGenre.put("COMEDY", List.of("Hangover", "Pink Panther"));
        movieByGenre.put("ACTION", List.of("Bad Boys", "Pulp Fiction"));

        //Here 'Map.Entry<String,List<String>>' is replaced with 'var' and this makes the code readable. For better understanding 'moviesInGenre' name is used.
        for (var moviesInGenre : movieByGenre.entrySet()) {
            List<String> movies = moviesInGenre.getValue();
            //do something with movies.
        }
    }

    public static String getFilePath() {
        try {
            URL res = VarExamples.class.getClassLoader().getResource("batch.log");
            File file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();
            return absolutePath;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readBatchFile() {

        var path = Paths.get(getFilePath());

        try (var lines = Files.lines(path)) {
            var count = lines.filter(line -> line.contains("Failed"))
                    .count();
            System.out.println("Total errors in batch jobs: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileBufferedReader() {

        Path path = Paths.get(getFilePath());

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readURL() {
        try {
            URL url = new URL("https://www.oracle.com");
            URLConnection urlConnection = url.openConnection();

            try (InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
                 BufferedReader reader = new BufferedReader(isr)) {
                Stream<String> lines = reader.lines().limit(5);
                lines.forEach(System.out::println);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static Optional<String> getMostWatchedMovie_1() {

        List<Movie> movies = getAllMovies();

        return movies.stream()
                .collect(groupingBy(Movie::getName, counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }


    public static Optional<String> getMostWatchedMovie_2() {

        List<Movie> movies = getAllMovies();

        Map<String, Long> movieCountMap = movies.stream()
                .collect(groupingBy(Movie::getName, counting()));

        Optional<Map.Entry<String, Long>> mostWatchedMovieEntryOpt
                = movieCountMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        return mostWatchedMovieEntryOpt.map(Map.Entry::getKey);

    }

    //break up chained or nested expressions with local variables.
    public static Optional<String> getMostWatchedMovie_3() {
        List<Movie> movies = getAllMovies();

        var movieCountMap = movies.stream()
                .collect(groupingBy(Movie::getName, counting()));

        var mostWatchedMovieEntryOpt = movieCountMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        return mostWatchedMovieEntryOpt.map(Map.Entry::getKey);
    }


    private static List<Movie> getAllMovies() {

        //var ?
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Departed"));
        movies.add(new Movie("The Mummy"));
        movies.add(new Movie("The Departed"));
        movies.add(new Movie("Bad Boys"));
        movies.add(new Movie("X-Men"));
        movies.add(new Movie("Casino Royale"));
        movies.add(new Movie("Fight Club"));
        movies.add(new Movie("The Departed"));


        return movies;
    }


    public static Map<Genre, List<Movie>> getMovies() {
        return new HashMap<>();
    }

    //Minimize the scope of local variables
    public static void scopeOfLocalVariables() {
        //change this to set.
        var movies = new ArrayList<String>();
        //var movies = new HashSet<String>(); //The above line could be replaced from ArrayList to HashSet
        //..lot's of code.
        //..lot's of code.
        //..lot's of code.
        // var movies = new ArrayList<String>(); //This is the best practise to keep the initialization near the code.
        movies.add("Second Last : The Dark Knight");
        movies.add("Last : The Dark Knight Returns");
        for (var movie : movies) {
            System.out.println(movie);
        }
    }
}

class Movie {

    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

enum Genre {

    ACTION,
    COMEDY,
    HORROR
}

class MovieService {

    public List<Movie> getMovies(MovieSearchCriteria movieSearchCriteria) {
        return new ArrayList<>();
    }
}

class MovieSearchCriteria {

}

class CrimeSceneSearchCriteria {

}


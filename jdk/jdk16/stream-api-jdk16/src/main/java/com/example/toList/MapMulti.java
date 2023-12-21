package com.example.toList;

import com.example.mapmulti.Movie;
import com.example.mapmulti.MovieUtil;

import java.util.List;

public class MapMulti {

    public static List<Movie> movies = MovieUtil.getMovieData();

    public static void main(String[] args) {

        //Using flatMap
        List<String> starCastflatMap = starsInMartinMoviesFlatMap();
        System.out.println(starCastflatMap);

        //Using mapMulti
        List<String> starCastmapMulti = starsInMartinMoviesMapMulti();
        System.out.println(starCastmapMulti);

    }

    public static List<String> starsInMartinMoviesFlatMap() {
        //[ [a],[b,c],[d,e,f] ] -> [a,b,c,d,e,f]

        return movies.stream()
                .filter(movie -> movie.getDirectorName().equals("Martin Scorsese"))
                .flatMap(movie -> movie.getCast().stream())
                .toList();
    }

    public static List<String> starsInMartinMoviesMapMulti() {

        return movies.stream()
                .filter(movie -> movie.getDirectorName().equals("Martin Scorsese"))
                .<String>mapMulti((movie, consumer) -> {
                    List<String> stars = movie.getCast();
                    for (String star : stars) {
                        consumer.accept(star);
                    }
                })
                .toList();
    }
}


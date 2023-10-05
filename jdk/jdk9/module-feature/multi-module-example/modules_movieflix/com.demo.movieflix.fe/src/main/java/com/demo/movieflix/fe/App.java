package com.demo.movieflix.fe;

import com.demo.movieflix.fe.recommendation.MovieRecommendationController;

import java.util.Map;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello FE Module...");
        MovieRecommendationController movieRecommendationController = new MovieRecommendationController();

        Map<String, Integer> movies = movieRecommendationController.recommendMovies();
        System.out.println("Recommended movies: " + movies);

    }

}

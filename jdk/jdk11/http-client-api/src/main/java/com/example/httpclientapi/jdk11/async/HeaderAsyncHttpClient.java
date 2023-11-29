package com.example.httpclientapi.jdk11.async;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HeaderAsyncHttpClient {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();


        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

        response.thenAccept(res -> System.out.println(res.headers().map()));
        response.join();
    }

}

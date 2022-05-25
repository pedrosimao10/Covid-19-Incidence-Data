package com.uatqs.hw1.httpconnect;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HttpClientAPI {

    private final Logger logger = LoggerFactory.getLogger(HttpClientAPI.class);   //logging strategy

    public String doRequest(String country, String iso) throws IOException, InterruptedException {

        logger.info("API Connecting to get specific country data");

        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/npm-covid-data/country-report-iso-based/" + country + "/" + iso))
		.header("X-RapidAPI-Host", "vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com")
		.header("X-RapidAPI-Key", "1869a94913mshceaaa8f72e83bd7p16ebdejsn084903832492")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    public String doRequest() throws IOException, InterruptedException {

        logger.info("API Connecting to fetch World data");

        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/npm-covid-data/world"))
		.header("X-RapidAPI-Host", "vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com")
		.header("X-RapidAPI-Key", "1869a94913mshceaaa8f72e83bd7p16ebdejsn084903832492")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    public String doRequestNews() throws IOException, InterruptedException {

        logger.info("API Connecting to fetch News data");

        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://covid-news-live1.p.rapidapi.com/news"))
		.header("X-RapidAPI-Host", "covid-news-live1.p.rapidapi.com")
		.header("X-RapidAPI-Key", "1869a94913mshceaaa8f72e83bd7p16ebdejsn084903832492")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}

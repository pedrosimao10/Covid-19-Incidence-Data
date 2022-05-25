package com.uatqs.hw1.controller;

import java.io.IOException;
import java.util.LinkedHashMap;


import com.uatqs.hw1.model.API;
import com.uatqs.hw1.model.Cache;
import com.uatqs.hw1.model.CountryISO;
import com.uatqs.hw1.model.News;
import com.uatqs.hw1.service.AppService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController{

    private final Logger logger = LoggerFactory.getLogger(AppController.class);   //logging strategy

    AppService appService = new AppService();

    @Autowired
    public AppController(AppService appService){
        this.appService = appService;
    }

    @GetMapping("/")
    public String home(Model model) {
        logger.info("(AppController.java) Entering main page...");
        return "home";
    }

    @PostMapping("/stats")
    public String getCountryData(@ModelAttribute("countryISO") CountryISO countryISO, Model model) throws IOException, InterruptedException {
        API request = appService.getStats(countryISO.getCountry(), countryISO.getThreeLetterSymbol());
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("Country", request.getCountry());
        map.put("Continent", request.getContinent());
        map.put("Population", request.getPopulation());
        map.put("Ranking (Number of Cases)", request.getRank());
        map.put("Active Cases", request.getActiveCases());
        map.put("Total Cases", request.getTotalCases());
        map.put("Serious Critical", request.getSeriousCritical());
        map.put("Total Deaths", request.getTotalDeaths());
        map.put("Total Recovered", request.getTotalRecovered());
        map.put("Total Tests", request.getTotalTests());
        map.put("Infection Risk (%)", request.getInfectionRisk());
        map.put("1 Case in Every X People", request.getOne_Caseevery_X_ppl());
        map.put("1 Death Every X People", request.getOne_Deathevery_X_ppl());
        map.put("Number of Deaths in 1 Million", request.getDeaths_1M_pop());
        map.put("Number of Tests in 1 Million", request.getTests_1M_Pop());
        model.addAttribute("result", map);
        logger.info("(AppController.java) Entering stats page...");
        return "results";
    }

    @PostMapping("/stats/world")
    public String getWorldData(Model model) throws IOException, InterruptedException {
        API request = appService.getStatsWorld();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("Country", request.getCountry());
        map.put("Active Cases", request.getActiveCases());
        map.put("New Cases", request.getNewCases());
        map.put("Total Cases", request.getTotalCases());
        map.put("Serious Critical", request.getSeriousCritical());
        map.put("New Deaths", request.getNewDeaths());
        map.put("Total Deaths", request.getTotalDeaths());
        map.put("New Recovered", request.getNewRecovered());
        map.put("Total Recovered", request.getTotalRecovered());
        map.put("Total Tests", request.getTotalTests());
        map.put("Number of Deaths in 1 Million", request.getDeaths_1M_pop());
        model.addAttribute("resultWorld", map);
        logger.info("(AppController.java) Entering World stats page...");
        return "resultsWorld";
    }

    @PostMapping("/news")
    public String getNews(Model model) throws IOException, InterruptedException {
        News request = appService.getNews();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("title", request.getTitle());
        map.put("url", request.getUrl());
        map.put("source", request.getSource());
        model.addAttribute("news", map);
        System.out.println(map);
        logger.info("(AppController.java) Entering News page...");
        return "news";
    }

    @GetMapping("/cache")
	public String cache(Model model) {
        LinkedHashMap<String, Integer> linkedhashMap = new LinkedHashMap<>();
        linkedhashMap.put("Requests", Cache.getnRequests());
        linkedhashMap.put("Hits", Cache.getnHits());
        linkedhashMap.put("Misses", Cache.getnMisses());
        model.addAttribute("cacheStats", linkedhashMap);
        logger.info("(AppController.java) Entering cache stats page...");
		return "cache";
	}

    

}
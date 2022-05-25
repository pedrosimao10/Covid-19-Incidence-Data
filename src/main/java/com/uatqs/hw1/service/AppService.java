package com.uatqs.hw1.service;

import java.io.IOException;

import com.uatqs.hw1.httpconnect.HttpClientAPI;
import com.uatqs.hw1.model.API;
import com.uatqs.hw1.model.Cache;
import com.uatqs.hw1.model.News;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private final Logger logger = LoggerFactory.getLogger(AppService.class);   //logging strategy

    @Autowired
    private Cache cache = new Cache();

    @Autowired
    private HttpClientAPI httpClientAPI;
    
    public API getStats(String countryName, String isoCode) throws IOException, InterruptedException {
    
        String key = countryName + "-" + isoCode;
        Object cacheData = cache.getCache(key);
        // Check Cached version
        logger.info("Checking if Cache already has data");
        if(cacheData != null){
            logger.info(" (Cache found results) Using cached results of country: " + countryName);
            return (API) cacheData;
        }
        logger.info("(Cache did not find results) Cache did not have data, requesting data for " + countryName);

        String newCoutryname = countryName.replace(" ", "%20");   //replace spaces by %20

        String response =  httpClientAPI.doRequest(newCoutryname, isoCode);
        JSONArray data_array = new JSONArray(response);
        JSONObject data = (JSONObject) data_array.get(0);
        String rank = data.get("rank").toString();
        String country = data.get("Country").toString();
        String continent = data.get("Continent").toString();
        String infection_risk = data.get("Infection_Risk").toString();
        String totalCases = data.get("TotalCases").toString();
        String totalDeaths = data.get("TotalDeaths").toString();
        String totalRecovered = data.get("TotalRecovered").toString();
        String activeCases = data.get("ActiveCases").toString();
        String totalTests = data.get("TotalTests").toString();
        String population = data.get("Population").toString();
        String oneCase1M = data.get("one_Caseevery_X_ppl").toString();
        String oneDeath1M = data.get("one_Deathevery_X_ppl").toString();
        String deaths1M = data.get("Deaths_1M_pop").toString();
        String seriousCritical = data.get("Serious_Critical").toString();
        String tests1M = data.get("Tests_1M_Pop").toString();
        
        API value = new API(rank, country, continent, infection_risk, totalCases, totalDeaths, totalRecovered, activeCases, totalTests, population, oneCase1M, oneDeath1M, deaths1M, seriousCritical, tests1M);
        // Add record to cache

        cache.saveCache(key, value);
        logger.info("Request added to cache for: " + countryName);
        return value;
    }

    public API getStatsWorld() throws IOException, InterruptedException {
    
        String key = "world";
        Object cacheData = cache.getCache(key);
        // Check Cached version
        logger.info("Checking if Cache already has data");
        if(cacheData != null){
            logger.info(" (Cache found results) Using cached results for World: ");
            return (API) cacheData;
        }
        logger.info("(Cache did not find results) Cache did not have data, requesting data for WOrld ");

        String response =  httpClientAPI.doRequest();
        JSONArray data_array = new JSONArray(response);
        JSONObject data = (JSONObject) data_array.get(0);
        String country = data.get("Country").toString();
        String totalCases = data.get("TotalCases").toString();
        String newCases = data.get("NewCases").toString();
        String totalDeaths = data.get("TotalDeaths").toString();
        String newDeaths = data.get("NewDeaths").toString();
        String totalRecovered = data.get("TotalRecovered").toString();
        String newRecovered = data.get("NewRecovered").toString();
        String activeCases = data.get("ActiveCases").toString();
        String totalTests = data.get("TotalTests").toString();
        String deaths1M = data.get("Deaths_1M_pop").toString();
        String seriousCritical = data.get("Serious_Critical").toString();
        
        API value = new API(country, totalCases, newCases, totalDeaths,newDeaths, totalRecovered, newRecovered, activeCases, totalTests, deaths1M, seriousCritical);
        // Add record to cache

        cache.saveCache(key, value);
        logger.info("Request added to cache for World " );
        return value;
    }

    public News getNews() throws IOException, InterruptedException {

        String key = "news";
        Object cacheData = cache.getCache(key);
        // Check Cached version
        logger.info("Checking if Cache already has data");
        if(cacheData != null){
            logger.info(" (Cache found results) Using cached results for News: ");
            return (News) cacheData;
        }
        logger.info("(Cache did not find results) Cache did not have data, requesting data for News ");

        String response =  httpClientAPI.doRequestNews();
        JSONArray data_array = new JSONArray(response);
        JSONObject data = (JSONObject) data_array.get(0);
        String title = data.get("title").toString();
        String url = data.get("url").toString();
        String source = data.get("source").toString();
        
        News value = new News(title, url, source);


        // Add record to cache
        cache.saveCache(key, value);
        logger.info("Request added to cache for News " );
        return value;
    }
}

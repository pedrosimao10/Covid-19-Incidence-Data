package com.uatqs.hw1.service;

import java.io.IOException;
import java.text.ParseException;

import com.uatqs.hw1.exception.ApiNotRespondingException;
import com.uatqs.hw1.httpconnect.HttpClientAPI;
import com.uatqs.hw1.model.API;
import com.uatqs.hw1.model.Cache;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AppServiceTest {

    @Mock(lenient = true)
    private HttpClientAPI httpClient;

    @InjectMocks
    private AppService appService;

    @Mock(lenient = true)
    Cache cache;

    @BeforeEach
    private void setUp() throws IOException, InterruptedException, ApiNotRespondingException, ParseException, org.json.simple.parser.ParseException {
        API api = new API();
        api.setCountry("USA");
        Mockito.when(cache.getCache(api.getCountry()+"-"+api.getCountry().toLowerCase())).thenReturn(api);
    }

    @DisplayName("AppServiceTest Test 1 - Getting data from cache if it exists")
    @Test
    public void getDataFromCacheIfExists() throws IOException, InterruptedException, ApiNotRespondingException, ParseException, org.json.simple.parser.ParseException {
        
        String country = "USA";
        String iso = "usa";
        API api = appService.getStats(country, iso);
        assertEquals(country, api.getCountry());
        assertEquals(iso, api.getCountry().toLowerCase());

    }


    @DisplayName("AppServiceTest Test 2 - Getting data from cache")
    @Test
    public void getDatainCache() throws IOException, InterruptedException, ApiNotRespondingException, ParseException, org.json.simple.parser.ParseException{
        API data = new API();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject("{\"data\":\"somedata\",\"more\":\"data\"}");
        }catch (JSONException err){
            System.err.println("Error: "+ err.toString());
        }
        data.setCountry("Portugal");
        assertNotEquals(null, cache);
        Mockito.when(cache.getCache("Portugal-prt")).thenReturn(jsonObject);

        assertNotEquals(null, jsonObject);
    }

    @DisplayName("AppServiceTest Test 3 - Get an error when data does not exist in cache")
    @Test
    public void errorIfDataNotInCache() throws IOException, InterruptedException, ApiNotRespondingException, ParseException, org.json.simple.parser.ParseException {
        
        String country = "Aveiro";
        String iso = "ua";
        assertThrows(NullPointerException.class,
            ()->{
                appService.getStats(country, iso);
            });

    }

}

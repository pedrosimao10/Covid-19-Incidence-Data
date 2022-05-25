package com.uatqs.hw1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CacheTest {

    private Cache cache;

    @BeforeEach
    public void setUp(){
        cache = new Cache();
    }

    @AfterEach
    public void tearDown(){
        cache.cleanCache();
    }

    @DisplayName("Cache Test 1: Get data from cache")
    @Test
    public void getDataFromCache(){
        cache.saveCache("Portugal", "Europa");
        cache.saveCache("Austrália", "Oceânia");

        assertEquals("Europa", cache.getCache("Portugal"));
        assertEquals("Oceânia", cache.getCache("Austrália"));
        assertEquals(2, cache.getCacheSize());

    }

    @DisplayName("Cache Test 2: Save data in cache")
    @Test
    public void saveDataInCache(){
        cache.saveCache("Portugal", "Europa");
        cache.saveCache("Austrália", "Oceânia");

        assertEquals("Europa", cache.getCache("Portugal"));
        assertEquals("Oceânia", cache.getCache("Austrália"));
    }

    @DisplayName("Cache Test 3: Remove data from cache")
    @Test
    public void removeDataFromCache(){
        cache.saveCache("Portugal", "Europa");
        cache.saveCache("Austrália", "Oceânia");

        cache.removeFromCache("Portugal");
        assertEquals(null, cache.getCache("Portugal"));
        assertEquals(1, cache.getCacheSize());
    }

    @DisplayName("Cache Test 4: Assert number of requests is correct")
    @Test
    public void getNRequests(){
        assertEquals(1, Cache.getnRequests());
    }

    @DisplayName("Cache Test 5: Assert number of hits is correct")
    @Test
    public void getNHits(){
        assertEquals(4, Cache.getnHits());
    }

    @DisplayName("Cache Test 6: Assert number of misses is correct")
    @Test
    public void getNMisses(){
        assertEquals(0, Cache.getnMisses());
    }
}

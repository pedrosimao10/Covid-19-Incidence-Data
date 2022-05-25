package com.uatqs.hw1.model;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Cache {

    private static final Logger logger = LoggerFactory.getLogger(Cache.class);

    private static int nHits = 0;
    private static int nMisses = 0;
    private static int nRequests = 0;
    private int timeToLiveMax;

    private HashMap<String, Object> cacheMemory;
    private HashMap<String, Long> timeToLive;
    
    public Cache() {
        logger.info(" (Cache.java) Creating Cache...");
        timeToLiveMax = 180*1000;
        cacheMemory = new HashMap<String,Object>();
        timeToLive = new HashMap<String,Long>();
    }
    
    public static int getnHits() {
        return nHits;
    }

    public static void setnHits(int nHitsA) {
        nHits = nHitsA;
    }

    public static int getnMisses() {
        return nMisses;
    }

    public static void setnMisses(int nMissesA) {
        nMisses = nMissesA;
    }

    public static int getnRequests() {
        return nRequests;
    }

    public static void setnRequests(int nRequestsA) {
        nRequests = nRequestsA;
    }


    public int getTimeToLiveMax() {
        return timeToLiveMax;
    }

    public void setTimeToLiveMax(int timeToLiveMax) {
        this.timeToLiveMax = timeToLiveMax;
    }

    public Object getCache(String key){
        logger.info("(Cache.java) Request. Getting data from cache");
        nRequests = nRequests + 1;

        if (cacheMemory.containsKey(key) && timeToLive.get(key) > System.currentTimeMillis()){
            nHits = nHits + 1;
            logger.info("(Cache.java) Hit. Cache already had data, returning data");
            return cacheMemory.get(key);

        } else{
            removeFromCache(key);
        }
        nMisses = nMisses + 1;
        logger.info("(Cache.java) Miss. Cache did not have data.");
        return null;
    }

    public void saveCache(String key, Object value){
        logger.info("(Cache.java) Saving new data into cache-");
        cacheMemory.put(key, value);
        timeToLive.put(key, System.currentTimeMillis() + timeToLiveMax);
    }

    public boolean removeFromCache(String key) {
        logger.info("(Cache.java) Removing data from Cache.");
        if (cacheMemory.containsKey(key) ){
            timeToLive.remove(key);
            cacheMemory.remove(key);
            return true;
        }
        return false;
    }

    public void cleanCache(){
        logger.info("(Cache.java) Cleaning cache.");
        cacheMemory.clear();
        timeToLive.clear();
    }

    public int getCacheSize(){
        return this.cacheMemory.size();
    }
    

}

package com.uatqs.hw1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class APITest {
    
    @DisplayName("API Test: Checking all data")
    @Test
    public void apiTest(){
        API api = new API("1", "USA", "North America", "24.71", "82662748", "1018335", "80465351", "1179062", "1000463737", "334511757", "4", "328", "3044", "1426", "2990818");

        assertEquals("1", api.getRank());
        assertEquals("USA", api.getCountry());
        assertEquals("North America", api.getContinent());
        assertEquals("24.71", api.getInfectionRisk());
        assertEquals("82662748", api.getTotalCases());
        assertEquals("1018335", api.getTotalDeaths());
        assertEquals("80465351", api.getTotalRecovered());
        assertEquals("1179062", api.getActiveCases());
        assertEquals("1000463737", api.getTotalTests());
        assertEquals("334511757", api.getPopulation());
        assertEquals("4", api.getOne_Caseevery_X_ppl());
        assertEquals("328", api.getOne_Deathevery_X_ppl());
        assertEquals("3044", api.getDeaths_1M_pop());
        assertEquals("1426", api.getSeriousCritical());
        assertEquals("2990818", api.getTests_1M_Pop());
    }
}

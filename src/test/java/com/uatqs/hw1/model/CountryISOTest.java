package com.uatqs.hw1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountryISOTest {

    @DisplayName("CountryISO Test: Checking all data")
    @Test
    public void apiTest(){
        CountryISO countryISO = new CountryISO("USA", "usa");

        assertEquals("USA", countryISO.getCountry());
        assertEquals("usa", countryISO.getThreeLetterSymbol());
    }
    
}

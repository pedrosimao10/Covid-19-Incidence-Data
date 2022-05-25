package com.uatqs.hw1.model;

public class CountryISO {
    
    private String Country;
    private String ThreeLetterSymbol;

    public CountryISO(String country, String threeLetterSymbol) {
        Country = country;
        ThreeLetterSymbol = threeLetterSymbol;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getThreeLetterSymbol() {
        return ThreeLetterSymbol;
    }

    public void setThreeLetterSymbol(String threeLetterSymbol) {
        ThreeLetterSymbol = threeLetterSymbol;
    }

    

    
    

}

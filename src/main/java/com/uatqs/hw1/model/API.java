package com.uatqs.hw1.model;

public class API{
    
    private String rank;
    private String Country;
    private String Continent;
    private String Infection_Risk;
    private String TotalCases;
    private String NewCases;
    private String TotalDeaths;
    private String NewDeaths;
    private String TotalRecovered;
    private String NewRecovered;
    private String ActiveCases;
    private String TotalTests;
    private String Population;
    private String one_Caseevery_X_ppl;
    private String one_Deathevery_X_ppl;
    private String Deaths_1M_pop;
    private String Serious_Critical;
    private String Tests_1M_Pop;


    
    public API(String rank, String country, String continent, String infection_Risk, String totalCases,
            String totalDeaths, String totalRecovered, String activeCases, String totalTests, String population,
            String one_Caseevery_X_ppl, String one_Deathevery_X_ppl, String deaths_1m_pop, String serious_Critical,
            String tests_1m_Pop) {
        this.rank = rank;
        Country = country;
        Continent = continent;
        Infection_Risk = infection_Risk;
        TotalCases = totalCases;
        TotalDeaths = totalDeaths;
        TotalRecovered = totalRecovered;
        ActiveCases = activeCases;
        TotalTests = totalTests;
        Population = population;
        this.one_Caseevery_X_ppl = one_Caseevery_X_ppl;
        this.one_Deathevery_X_ppl = one_Deathevery_X_ppl;
        Deaths_1M_pop = deaths_1m_pop;
        Serious_Critical = serious_Critical;
        Tests_1M_Pop = tests_1m_Pop;
    }

    public API(String country, String totalCases, String newCases, String totalDeaths, String newDeaths,
            String totalRecovered, String newRecovered, String activeCases, String totalTests, String deaths_1m_pop,
            String serious_Critical) {
        Country = country;
        TotalCases = totalCases;
        NewCases = newCases;
        TotalDeaths = totalDeaths;
        NewDeaths = newDeaths;
        TotalRecovered = totalRecovered;
        NewRecovered = newRecovered;
        ActiveCases = activeCases;
        TotalTests = totalTests;
        Deaths_1M_pop = deaths_1m_pop;
        Serious_Critical = serious_Critical;
    }


    public API(){}


    public String getCountry() {
        return this.Country;
    }


    public void setCountry(String country) {
        Country = country;
    }

    public String getInfectionRisk() {
        return this.Infection_Risk;
    }

    public String getTotalCases() {
        return this.TotalCases;
    }

    public String getTotalDeaths() {
        return this.TotalDeaths;
    }

    public String getTotalRecovered() {
        return this.TotalRecovered;
    }

    public String getActiveCases() {
        return this.ActiveCases;
    }

    public String getTotalTests() {
        return this.TotalTests;
    }

    public String getPopulation() {
        return this.Population;
    }


    public String getSeriousCritical() {
        return this.Serious_Critical;
    }


    public String getRank() {
        return rank;
    }


    public void setRank(String rank) {
        this.rank = rank;
    }


    public String getContinent() {
        return Continent;
    }


    public void setContinent(String continent) {
        this.Continent = continent;
    }


    public String getInfection_Risk() {
        return Infection_Risk;
    }


    public void setInfection_Risk(String infection_Risk) {
        this.Infection_Risk = infection_Risk;
    }


    public String getOne_Caseevery_X_ppl() {
        return one_Caseevery_X_ppl;
    }


    public void setOne_Caseevery_X_ppl(String one_Caseevery_X_ppl) {
        this.one_Caseevery_X_ppl = one_Caseevery_X_ppl;
    }


    public String getOne_Deathevery_X_ppl() {
        return one_Deathevery_X_ppl;
    }


    public void setOne_Deathevery_X_ppl(String one_Deathevery_X_ppl) {
        this.one_Deathevery_X_ppl = one_Deathevery_X_ppl;
    }


    public String getDeaths_1M_pop() {
        return Deaths_1M_pop;
    }


    public void setDeaths_1M_pop(String deaths_1m_pop) {
        this.Deaths_1M_pop = deaths_1m_pop;
    }


    public String getSerious_Critical() {
        return Serious_Critical;
    }


    public void setSerious_Critical(String serious_Critical) {
        this.Serious_Critical = serious_Critical;
    }


    public String getTests_1M_Pop() {
        return Tests_1M_Pop;
    }


    public void setTests_1M_Pop(String tests_1m_Pop) {
        this.Tests_1M_Pop = tests_1m_Pop;
    }

    public void setTotalCases(String totalCases) {
        this.TotalCases = totalCases;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.TotalDeaths = totalDeaths;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.TotalRecovered = totalRecovered;
    }

    public void setActiveCases(String activeCases) {
        this.ActiveCases = activeCases;
    }

    public void setTotalTests(String totalTests) {
        this.TotalTests = totalTests;
    }

    public void setPopulation(String population) {
        this.Population = population;
    }

    public String getNewCases() {
        return NewCases;
    }

    public void setNewCases(String newCases) {
        NewCases = newCases;
    }

    public String getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        NewDeaths = newDeaths;
    }

    public String getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(String newRecovered) {
        NewRecovered = newRecovered;
    }

    
    

    

}

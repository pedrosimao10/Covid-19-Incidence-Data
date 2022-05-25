package com.uatqs.hw1.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppSteps {

    private WebDriver webDriver;


    @When("I navigate to {string}")
    public void navigateTo(String url){
        webDriver = WebDriverManager.chromedriver().create();
        webDriver.get(url);
    }

    @And("I type {string} as the Country")
    public void typeCountry(String Country){
        webDriver.findElement(By.xpath(".//input[@name='Country']")).sendKeys(Country);
    }

    @And("I type {string} as the ThreeLetterSymbol")
    public void typeThreeLetterSymbol(String ThreeLetterSymbol){
        webDriver.findElement(By.xpath(".//input[@name='ThreeLetterSymbol']")).sendKeys(ThreeLetterSymbol);
    }

    @And("I click on Submit")
    public void clickSubmit(){
        webDriver.findElement(By.cssSelector(".s01 form .inner-form .input-field.third-wrap .btn-search")).click();
    }

    @And("I click on World Stats")
    public void clickWorldStats(){
        webDriver.findElement(By.cssSelector(".s01 form .inner-form .input-field.third-wrap.world .btn-search")).click();
    }

    @And("I click on News")
    public void clickNews(){
        webDriver.findElement(By.cssSelector(".s01 form .inner-form .input-field.third-wrap.news .btn-search")).click();
    }

    @And("I see value of Requests and is {string}")
    public void valueOfRequests(String number){
        assertThat(webDriver.findElement(By.xpath(".//table/tbody/tr/td[1]")).getText(), containsString(number));
    }

    @And("I see value of Hits and is {string}")
    public void valueOfHits(String number){
        assertThat(webDriver.findElement(By.xpath(".//table/tbody/tr/td[2]")).getText(), containsString(number));
    }

    @And("I see value of Misses and is {string}")
    public void valueOfMisses(String number){
        assertThat(webDriver.findElement(By.xpath(".//table/tbody/tr/td[3]")).getText(), containsString(number));
    }

    @Then("I should see the message {string}")
    public void seeMessage(String message) throws InterruptedException{
        assertThat(webDriver.findElement(By.xpath(".//div[@class='col-md-6 text-center mb-5']/h2[@class='heading-section']")).getText(), containsString(message));
    }

    @Then("I should see the error {string}")
    public void seeErrorMessage(String message) throws InterruptedException{
        assertThat(webDriver.findElement(By.xpath(".//div[@class='col-md-6 text-center mb-5']/h2[@class='heading-section']")).getText(), containsString(message));
    }

    @After()
    public void closeBrowser() {
        webDriver.quit();
    }
    
}

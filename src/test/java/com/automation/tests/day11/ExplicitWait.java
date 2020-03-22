package com.automation.tests.day11;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createDriver("chrome");
    }

    @Test
    public void explicitWait(){

        driver.get("http://www.google.com");

        //wait up to 10 seconds until title contains Google
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleContains("Google"));

        driver.navigate().to("http://www.amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));
    }

    @AfterMethod
    public void teardown(){

        driver.quit();
    }




}

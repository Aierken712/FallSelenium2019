package com.automation.tests.OfficeHour;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OfficeHour9 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){

        BrowserUtils.wait(1);
        driver.quit();
    }

    @Test
    public void test(){

        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        /*
            we have stored all frames webElements inside the list
            1. Loop through list
            2. switch to each frame
                a. get test from body
                b. switch to parent
         */
        for (int i=0; i<frameList.size();i++){
            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println(bodyText);
            driver.switchTo().parentFrame();
        }

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println(bodyText);

        driver.switchTo().defaultContent();

    }


}

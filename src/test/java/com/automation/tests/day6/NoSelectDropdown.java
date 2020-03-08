package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NoSelectDropdown {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Amazon")).click();
        BrowserUtils.wait(1);
        driver.navigate().back();
        BrowserUtils.wait(1);
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Google")).click();


        BrowserUtils.wait(2);
        driver.quit();


    }
}

package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
        driver.findElement(By.linkText("Etsy")).click();


        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement link: allLinks){
            System.out.println(link.getText() + " : " + link.getAttribute("href"));
        }

        driver.findElement(By.linkText("Etsy")).click();//click on option

        BrowserUtils.wait(3);
        driver.quit();

    }
}

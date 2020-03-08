package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();// to click on the first button
        BrowserUtils.wait(2);

        // to get the text from popup message
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept();// to click ok

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASS");
        }else{
            System.out.println("TEST FAIL");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }
        BrowserUtils.wait(2);

        System.out.println("============================================");

        buttons.get(1).click();// to click on the second button
        BrowserUtils.wait(2);

        // to click cancel
        driver.switchTo().alert().dismiss();
        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("TEST PASS");
        }else{
            System.out.println("TEST FAIL");
            System.out.println("Expected2: " + expected2);
            System.out.println("Actual2: " + actual2);
        }
        BrowserUtils.wait(2);

        System.out.println("============================================");

        buttons.get(2).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Hello, World");// enter text
        alert.accept();// click ok

        String expected3 = "You entered: Hello, World";
        String actual3 = driver.findElement(By.id("result")).getText();

        if(expected3.equals(actual3)){
            System.out.println("TEST PASS");
        }else{
            System.out.println("TEST FAIL");
            System.out.println("Expected3: " + expected3);
            System.out.println("Actual3: " + actual3);
        }

        BrowserUtils.wait(2);
        driver.quit();
    }
}

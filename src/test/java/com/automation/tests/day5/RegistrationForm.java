package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(3);
        // enter first name
        driver.findElement(By.name("firstname")).sendKeys("SDET");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("jsmith");
        driver.findElement(By.name("email")).sendKeys("jsmith@gmail.com");
        driver.findElement(By.name("password")).sendKeys("supersecretpassward");
        driver.findElement(By.name("phone")).sendKeys("437-997-6946");

        List<WebElement> gender = driver.findElements(By.name("gender"));
        // select gender
        gender.get(0).click();//select male, for example

        driver.findElement(By.name("birthday")).sendKeys("12/07/1989");

        driver.findElement(By.id("inlineCheckbox2")).click();//select java

        BrowserUtils.wait(3);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(3);

        // ADD VALIDATION PART

        driver.quit();
    }
}

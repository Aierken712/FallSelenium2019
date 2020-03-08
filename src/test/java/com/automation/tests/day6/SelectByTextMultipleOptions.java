package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));

        // whether this select element support selecting multiple options at the same time
        // This is done by checking the value of the "multiple" attribute
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);// if it`s true, you can select more than one option

        languagesSelect.selectByVisibleText("Java");
        BrowserUtils.wait(2);
        languagesSelect.selectByVisibleText("JavaScript");
        BrowserUtils.wait(2);
        languagesSelect.selectByVisibleText("C#");
        BrowserUtils.wait(2);
        languagesSelect.selectByVisibleText("Python");
        BrowserUtils.wait(2);

        // let`s get all selected options
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();
        for(WebElement selectedLanguage : selectedLanguages){
            System.out.println(selectedLanguage.getText());
        }
        BrowserUtils.wait(2);

        languagesSelect.deselectByVisibleText("Java");// to unSelect something
        BrowserUtils.wait(1);
        languagesSelect.deselectByVisibleText("JavaScript");
        BrowserUtils.wait(1);
        languagesSelect.deselectByVisibleText("C#");
        BrowserUtils.wait(1);
        languagesSelect.deselectByVisibleText("Python");
        BrowserUtils.wait(1);
        languagesSelect.deselectAll();

        BrowserUtils.wait(2);
        driver.quit();
    }
}
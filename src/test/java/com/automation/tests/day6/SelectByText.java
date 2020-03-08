package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //create a webelement object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //provide weblement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");

        BrowserUtils.wait(3);
        //and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");

        // Select your date of birth
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("12");
        BrowserUtils.wait(1);
        selectMonth.selectByVisibleText("July");
        BrowserUtils.wait(1);
        selectYear.selectByVisibleText("1989");

        // select all days one by one
        List<WebElement> days = selectDay.getOptions();
        for(WebElement day : days){
            selectDay.selectByVisibleText(day.getText());
        }

        // select all months one by one
        List<WebElement> months = selectMonth.getOptions();
        for(WebElement month : months){
            // get the month name and select based on that
            selectMonth.selectByVisibleText(month.getText());
            BrowserUtils.wait(1);
        }

        // select all years one by one
//        List<WebElement> years = selectYear.getOptions();
//        for(WebElement year : years){
//            selectYear.selectByVisibleText(year.getText());
//        }

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District Of Columbia");

        //option that is currently selected
        //getFirstSelectedOption() -- returns a webElement, that's why we need to call getText() method
        // getText() retrieves visible text from the webElement
        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equals("District Of Columbia")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        List<WebElement> states = stateSelect.getOptions();
        for(WebElement state : states){
            System.out.println(state.getText());
           // stateSelect.selectByVisibleText(state.getText());
        }


        BrowserUtils.wait(2);
        driver.quit();
    }
}

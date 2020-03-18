package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarEventsPageTests {

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;
    private String storeManagerUserName="storemanager85";
    private String storeManagerPassword="UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By createCalendarEventBy = By.cssSelector("a[title='Create Calendar event']");

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(5);

        //hover over Activities
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);

    }

    @Test
    public void verifyCreateButton(){
        WebElement createCalendarEventBtn = driver.findElement(createCalendarEventBy);
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());

    }

    @AfterMethod
    public void teardown(){
        driver.quit();

    }




}

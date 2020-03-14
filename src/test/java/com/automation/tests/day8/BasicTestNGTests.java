package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    //runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }

    //runs only once after @AfterClass after @AfterMethod
    @AfterTest
    public void afterTest(){
        System.out.println("AFTER TEST");
    }

    //Runs only once in the class before @beforeMethod and before any test
    //regardless on number of tests, it runs only once
    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AFTER CLASS");
    }

    //runs before every test automatically
    // work as a pre-condition or setup
    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
    }

    //runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }

    @Test
    public void test1(){
        System.out.println("Test1");
        String expected = "apple";
        String actual = ("apple");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test2(){
        System.out.println("Test2");
        int num1 = 5;
        int num2 = 10;
        //if calls hard assertion
        //if assertion fails - it stops the execution(due to exception).
        Assert.assertTrue(num1<num2);
    }



}

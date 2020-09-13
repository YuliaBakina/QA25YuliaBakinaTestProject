package com.telran.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver wd; //driver field

    //method - before
    @BeforeMethod // annotation for before
    public void setUp(){
        wd = new ChromeDriver(); //launch Chrome driver
        wd.get("https://www.google.com/");

    }

    //method - tests
    @Test // annotation for tests
    public void openGoogleTest(){
        System.out.println("site is opened!");

        wd.findElement(By.name("q")).click(); //focus on the field
        wd.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER); //fill the field and click enter
        String text = wd.findElement(By.tagName("h3")).getText();

        System.out.println("Found text --> " + text);
        Assert.assertEquals(text.toLowerCase(), "selenium");
    }

    //method - after
    @AfterMethod
    public void tearDown(){
        wd.quit(); // quit from the browser. Does not matter how many tabs are opened
        //wd.close(); //close the only one tab in a browser

    }
}

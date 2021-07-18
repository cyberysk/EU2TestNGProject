package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        //click start button
        driver.findElement(By.tagName("button")).click();

        //locate username inputbox
        WebElement userNameInputBox=  driver.findElement(By.id("username"));

        //HOW TO WAIT EXPLICITLY?
        //Create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //calling until method from wait object
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        //wait.until(ExpectedConditions.elementToBeClickable(userNameInputBox));

        //send text to inputbox
        userNameInputBox.sendKeys("Ahmet Sezgin");

    }
}

package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void clickWithJS(){

        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));

        //clicking with JavascriptExecutor
        //create executor object

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //use executeScript
        jse.executeScript("arguments[0].click();", dropdownLink);


    }
    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        //inputBox.sendKeys("Some Text");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String str = "Hello Disable Input Box";
        jse.executeScript("arguments[0].setAttribute('value', '" + str +"')", inputBox);


    }

    @Test
    public void scrollDownandUp() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Thread.sleep(1000);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(250);
            jse.executeScript("window.scrollBy(0,250)");
        }
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(250);
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }


}

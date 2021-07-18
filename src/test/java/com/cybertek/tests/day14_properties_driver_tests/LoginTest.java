package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {

    @Test
    public void test1(){
        driver.get("https://qa1.vytrack.com");
        driver.findElement(By.id("prependedInput")).sendKeys("User1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        //Both action with chaining
        // driver.findElement(By.id("prependedInput")).sendKeys("User1" + Keys.TAB + "UserUser123" + Keys.ENTER);



    }
    @Test
    public void testMineTest(){
        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password =ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password+Keys.ENTER);
    }

}

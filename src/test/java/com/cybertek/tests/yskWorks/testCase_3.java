package com.cybertek.tests.yskWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.Arrays;

public class testCase_3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");

        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium webdriver");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()=' (software)']")).click();

        String expectedUrl = "Selenium_(software)";
//        String aaa = driver.getCurrentUrl();
//        System.out.println("aaa = " + aaa);
        String actualUrl = driver.findElement(By.xpath("//link[@rel='canonical']")).getAttribute("href");
        System.out.println("actualUrl = " + actualUrl);

        String [] listOfActualUrl = actualUrl.split("/");

        System.out.println(listOfActualUrl[listOfActualUrl.length-1]);

        if(listOfActualUrl[listOfActualUrl.length-1].equals(expectedUrl)){
            System.out.println("PASS");

        }else {
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);
        }

        driver.quit();

    }
}

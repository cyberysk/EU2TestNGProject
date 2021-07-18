package com.cybertek.tests.yskWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testCase_1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.ebay.de/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("Fahrrad");

        driver.findElement(By.xpath("//input[@value='Finden']")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.xpath("//h1[contains(text(),' Ergebnisse für' )]")).getText();

        System.out.println("result = " + result);


    }
}

package com.cybertek.tests.yskWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testCase_2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.de/");

        driver.navigate().to("https://www.ebay.de/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));

        String searchTerm = "Fahrrad";
        searchBox.sendKeys(searchTerm);
        driver.findElement(By.xpath("//input[@value='Finden']")).click();
        Thread.sleep(2000);

        String titleOfResult = driver.getTitle();
        System.out.println("titleOfResult = " + titleOfResult);

        if (titleOfResult.toLowerCase().contains(searchTerm.toLowerCase())){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("titleOfResult = " + titleOfResult.toLowerCase());
            System.out.println("searchTerm = " + searchTerm.toLowerCase());
        }

        driver.navigate().back();
        driver.navigate().back();

        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(searchTerm);

        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        Thread.sleep(3000);

       titleOfResult = driver.getTitle();
        System.out.println("titleOfResult = " + titleOfResult);

        if (titleOfResult.toLowerCase().contains(searchTerm.toLowerCase())){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("titleOfResult = " + titleOfResult.toLowerCase());
            System.out.println("searchTerm = " + searchTerm.toLowerCase());
        }

        driver.quit();




    }
}

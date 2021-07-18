package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonXpath {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        //WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Selenium");
        Thread.sleep(2000);
        //driver.findElement(By.id("nav-search-submit-button")).click();
        //driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        String resultOfSearch = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")).getText();
        //String resultOfSearch = driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();

        System.out.println("resultOfSearch = " + resultOfSearch);
        driver.quit();
    }
}

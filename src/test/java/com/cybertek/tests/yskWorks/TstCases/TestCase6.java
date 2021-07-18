package com.cybertek.tests.yskWorks.TstCases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestCase6 {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.fakemail.net/");

        Thread.sleep(5000);

        String fakeMail = driver.findElement(By.xpath("//span[@id='email']")).getText();

        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Sign Up For Mailing List")).click();

        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Ahmet Sezgin");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(fakeMail);
        driver.findElement(By.cssSelector("button")).click();

        driver.quit();

    }
}

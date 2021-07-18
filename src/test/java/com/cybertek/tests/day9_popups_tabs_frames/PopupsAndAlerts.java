package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void popUp(){
        driver.get("http://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        //locate and click Confirm Button
        driver.findElement(By.xpath("//button[.='Confirm']")).click();

        //locate and click popup No button
        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //click for JS ALERTS button
        driver.findElement(By.xpath("//button[1]")).click();
        //switch to JS Alert window
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        //click OK button with using Alert class
        alert.accept();

        //click on CLick JS Confirm
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        //Click the cancel button
        alert.dismiss();

        //Click on Click for JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);
        //Send the Keys to JS Prompt
        alert.sendKeys("Ahmet Sezgin");
        alert.accept();
        Thread.sleep(2000);


    }

}

package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {

    public static void main(String[] args) throws InterruptedException {

        /*
        •	open browser
        •	go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        •	enter any email
        •	click on Retrieve password
        •	verify that url changed to http://practice.cybertekschool.com/email_sent
        */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("abc@abcmail.com");


        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        Thread.sleep(3000);
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);
        }

        driver.quit();

    }
}

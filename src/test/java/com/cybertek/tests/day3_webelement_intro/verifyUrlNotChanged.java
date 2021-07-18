package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlNotChanged {

    public static void main(String[] args) throws InterruptedException {

      /*
      open chrome browser
      go to http://practice.cybertekschool.com/forgot_password Links to an external site
      click on retrieve password
      verify that url did not change
       */

        //open empty chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        //go to link
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //get the currentUrl and attain variable
        //save url before we click retrieve button
        String expectedUrl = driver.getCurrentUrl();

        //we fond the web element that's retrieve password button by using id
        // and we assign that element to Web element
        //WebElement --> Interface that represent elements on page
        //findElement --> method we use to find element on a web page
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        //we are clicking the that button
        // click()--> using for clicking web element
        retrievePasswordButton.click();

        //we save the url after we click button
        String actualUrl = driver.getCurrentUrl();

        //verify that url did not changed
        if (actualUrl.equals(expectedUrl)){
            System.out.println("URL did not changed / PASS");
        } else {
            System.out.println("URL changed / FAIL");
        }

        //Thread.sleep(5000);

        //close browser after everything
        driver.quit();

    }

}

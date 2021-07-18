package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {
    /*
        Verify confirmation message
        •	open browser
        •	go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        •	enter any email
        •	verify that email is displayed in the input box
        •	click on Retrieve password
        •	verify that confirmation message says 'Your e-mail's been sent!'
    */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));
        String expectedEmail = "abc@abcmail.com";
        emailInputBox.sendKeys(expectedEmail);

        //somehow we should get text from web element
        //two main ways to get text from web elements
        // 1--> getText()--> it will work %99 and it will return string
        // 2--> getAttribute("value")--> second way of getting text especially input boxes
        String actualEmail = emailInputBox.getAttribute("value");

        if(actualEmail.equals(expectedEmail)){
            System.out.println("PASS / Displayed email address");
        } else {
            System.out.println("FAIL / Not displayed email address");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }

        //Another verify the our email on displayed with ".isDisplayed()" method
//        if (emailInputBox.isDisplayed()){
//            System.out.println("PASS / Displayed email address");
//        } else {
//            System.out.println("FAIL / Not displayed email address");
//        }

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        String expectedMessage = "Your e-mail's been sent!";
        WebElement actualMessage = driver.findElement(By.name("confirmation_message"));
        String actualMessageText = actualMessage.getText();

        if (actualMessageText.equals(expectedMessage)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        driver.quit();

    }

}

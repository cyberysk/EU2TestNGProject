package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //for full windows full screen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.name("full_name"));

        fullNameInputBox.sendKeys("Mike Smith");

        // put some email and click sin up button
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@smith.com");

        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

        //lazy way (without saving web Element we can click that web element)
        driver.findElement(By.name("wooden_spoon")).click();

        // then verify next page displays
        //"Thank you for signing up. Click the button below to return to the home page."
        Thread.sleep(5000);
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement actualMessageElement = driver.findElement(By.name("signup_message"));
        String actualMessage = actualMessageElement.getText();

//        //lazy Way
//        String message = driver.findElement(By.name("signup_message")).getText();

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");

        }else{
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }

        driver.quit();


    }
}

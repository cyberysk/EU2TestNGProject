package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.tagName("input"));
        fullNameInputBox.sendKeys("Mike Smith Tag Name");

        WebElement emailInputBox = driver.findElement(By.tagName("inpu"));
        emailInputBox.sendKeys("mike@smith.com");

        //click the button with tagname
        driver.findElement(By.tagName("button")).click();

        //
        System.out.println(driver.findElement(By.tagName("h3")).getText());


    }
}

package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void radioBtnTest1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        //how to check is radio button selected?

        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());

        //verify blue is selected red is NOT selected

        Assert.assertTrue(blueRadioButton.isSelected(), "Verify blue is selected");
        Assert.assertFalse(redRadioButton.isSelected(), "Verify red is NOT selected");

        //how to select radio button?
        //we use click method select radio button
        redRadioButton.click();

        System.out.println("==============================");
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());

        //verify blue is NOT selected red is selected
        Assert.assertFalse(blueRadioButton.isSelected(), "Verify blue is NOT selected");
        Assert.assertTrue(redRadioButton.isSelected(), "Verify red is selected");

        driver.quit();

    }


}

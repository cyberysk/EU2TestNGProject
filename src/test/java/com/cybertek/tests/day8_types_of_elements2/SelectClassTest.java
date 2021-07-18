package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2.create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //getOptions()-->returns all the available options from the dropdown list
        List<WebElement> options = stateDropdown.getOptions();

        //print size of the options
        System.out.println("options.size() = " + options.size());

        //print options one by one
        for (WebElement option : options) {
            System.out.println("States = " + option.getText());
        }


        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2.create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //verify that first selection is Select a state
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption, expectedOption, "Verify first Selection");

        //HOW TO SELECT OPTIONS FROM DROPDOWN?
        //1.SELECT USING VISIBLE TEXT
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Texas");


        // Verify that we could selected option as expected
        expectedOption = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify selected option same as we expected");

        //2.SELECT USING INDEX
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify selected option same as we expected");


        //3.SELECT BY VALUE
        stateDropdown.selectByValue("DC");
        expectedOption = "District Of Columbia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify selected option same as we expected");


        //just for seeing to chose state
        Thread.sleep(2000);
        driver.quit();

    }



}

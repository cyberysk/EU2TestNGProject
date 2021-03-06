package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxDemo {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        //how to verify checkbox is selected or not?

        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        //verify checkbox 1 is not selected checkbox 2 selected
        Assert.assertFalse(checkbox1.isSelected(),"Verify Checkbox is NOT selected");
        Assert.assertTrue(checkbox2.isSelected(),"Verify Checkbox is selected");

        //how to click checkbox?
        checkbox1.click();
        System.out.println("------AFTER CLICK------");
        //verify checkboxes again
        Assert.assertTrue(checkbox1.isSelected(),"Verify Checkbox is selected");
        Assert.assertTrue(checkbox2.isSelected(),"Verify Checkbox is selected");
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        driver.quit();


    }


}

package com.cybertek.tests.yskWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class demoGmail {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://en.zalando.de/women-home/?_rfl=de");

        WebElement womenButton = driver.findElement(By.partialLinkText("Footwear"));

        womenButton.click();

    }

}

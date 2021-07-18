package com.cybertek.pages.YskWorks;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;
import java.util.List;

public class BasePageYsk {

    public BasePageYsk(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//div[@id='main-menu']/ul/li")
    public List<WebElement> mainList;

    @FindBy(xpath = "//div[@id='main-menu']/ul/li[3]")
    public WebElement activities;

    @FindBy(xpath = "//*[text()='Calendar Events']")
    public WebElement calendarEvents;

}

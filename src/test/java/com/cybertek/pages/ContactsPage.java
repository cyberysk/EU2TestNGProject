package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends BasePage{

    //since we are extending BasePage we do not need explicit constructor for this class

//    @FindBy(xpath = "//tbody//tr//td[@data-column-label='Email']")
//    public List<WebElement> contactsEmail;

//    //THIS LOCATOR SPECIFIC FOR SEARCH "mbrackstone9@example.com"
//    @FindBy(xpath = "//*[contains(text(),'mbrackstone9@example.com')]")
//    public WebElement email;

    @FindBy(xpath = "//*[contains(text(),'mbrackstone9@example.com')] [@data-column-label='Email']")
    public WebElement email;

    //create a method that accepts email as string and return web element based on that email
    public WebElement getContactEmail(String email){
        String xpath = "//*[contains(text(),'"+ email +"')] [@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));

    }


}

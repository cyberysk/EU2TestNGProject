
package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage{
    public CalendarEventsPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@class='btn-group actions-group']")
    public WebElement subtitle;

    @FindBy(css = "button[class= 'btn dropdown-toggle ']")
    public WebElement perNumberPage;

    @FindBy(css = "tbody>tr")
    public List<WebElement> numberOfRowsWithOutHeader;

    @FindBy(xpath = "//label[contains(text(),'Total')]")
    public WebElement totalRecords;

    @FindBy(xpath = "//label[contains(text(),'of')][1]")
    public WebElement totalPage;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement nextBtn;

    @FindBy(xpath = "//thead//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//tr[contains(@class,'selected')]")
    public List<WebElement> selectedRowsNumber;

    @FindBy(xpath = "//tbody//tr//input")
    public List<WebElement> rowCheckBox;



}
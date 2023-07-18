package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//form//input[@placeholder='First Name']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//form//input[@placeholder='Last Name']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//form//input[@placeholder='Post Code']")
    WebElement postCode;
    @CacheLookup
    @FindBy(xpath = "//form//button[1]")
    WebElement addCustomer;

    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }
    public void enterFirstName(String text) {
        Reporter.log("Enter first name in name field "+firstName);
        sendTextToElement(firstName, text);
    }

    public void enterLastName(String text) {
        Reporter.log("Enter last name in name field "+lastName);
        sendTextToElement(lastName, text);
    }

    public void enterPostCode(String text) {
        Reporter.log("Enter first name in name field "+firstName);
        sendTextToElement(postCode, text);
    }

    public void clickOnAddCustomerButton() {
        Reporter.log("Click on Add customer button " +addCustomer);
        clickOnElement(addCustomer);
    }

    public String verifyPopUpText() {
        Reporter.log("Verify pop up text message" +getTextFromAlert());
        return getTextFromAlert();
    }

    public void acceptPopUpMessage() {
        Reporter.log("Accept pop up message");
        acceptAlert();
    }
}

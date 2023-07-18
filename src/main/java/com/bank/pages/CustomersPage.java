package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomersPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameText;

    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyNameText() {
        Reporter.log("Verifying Your Name heading");
        return getTextFromElement(yourNameText);
    }

}

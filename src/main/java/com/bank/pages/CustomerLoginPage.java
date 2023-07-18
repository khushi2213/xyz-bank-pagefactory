package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class CustomerLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement clickOnLoginTab;
    @CacheLookup
    @FindBy(xpath = "//form[@role='form']/child::div[1]/select/child::*")
    List<WebElement> enteredUserName;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[1]/button[2]")
    WebElement verifyLogoutText;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logOutButtonText;

    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginTab() {
        Reporter.log("Clicking on login button" + clickOnLoginTab.toString());
        clickOnElement(clickOnLoginTab);
    }

    public void selectCustomerNameFromDropDown(String cname) {
        Reporter.log("Selecting customer from dropdown" + enteredUserName.toString());
        // List<WebElement> lists = driver.findElements(enteredUserName);
        for (WebElement list : enteredUserName) {
            if (list.getText().equals(cname)) {
                list.click();
                break;
            }
        }
    }

    public void userClickOnLoginButton() {
        Reporter.log("Clicking on login button" + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String verifyLogoutMessage() {
        Reporter.log("Verifying logout message");
        return getTextFromElement(verifyLogoutText);
    }

    public void clickOnLogOutButton() {
        Reporter.log("Clicking on logout button" + logOutButtonText.toString());
        clickOnElement(logOutButtonText);
    }

}

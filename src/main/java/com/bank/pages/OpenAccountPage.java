package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class OpenAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//form[@role='form']/child::div[1]/select/child::*")
    List<WebElement> enteredUserName;
    @CacheLookup
    @FindBy(id = "currency")
    WebElement selectCurrency;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;

    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectCustomerNameFromDropDown(String cname) {
        Reporter.log("Selecting customer name from dropdown");
        //  List<WebElement> lists = driver.findElements(enteredUserName);
        for (WebElement list : enteredUserName) {
            if (list.getText().equals(cname)) {
                list.click();
                break;
            }
        }
    }

    public void selectCurrencyFromDropDown(String text) {
        Reporter.log("Selecting currency name from dropdown");
        selectByValueFromDropDown(selectCurrency, text);

    }

    public void searchCustomer(String name) {

        selectByValueFromDropDown((By) enteredUserName, name);
    }

    public void clickOnProcessButton() {
        clickOnElement(processButton);
    }
}

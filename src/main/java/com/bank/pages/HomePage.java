package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerTab;

    public HomePage() {
        //this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnBankManagerLoginTab(){
        Reporter.log("Clicking on Manager Login tab");
        clickOnElement(bankManagerTab);
    }
}

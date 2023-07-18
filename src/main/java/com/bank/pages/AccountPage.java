package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class AccountPage extends Utility {
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
    @FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']/div[3]/button[2]")
    WebElement depositLinkText;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountField;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-default'][contains(text(),'Deposit')]")
    WebElement depositButton;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(), 'Deposit Successful')]")
    WebElement depositSuccessFull;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-lg tab'][contains(text(),'Withdrawl')]")
    WebElement withDrawlText;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountToWithdraw;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement withdrawButton;
    By transactionMessage = By.xpath("//span[contains(text(),'Transaction successful')]");

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginTab() {
        clickOnElement(clickOnLoginTab);
    }

    public void selectCustomerNameFromDropDown(String cname) {
        //List<WebElement> lists = driver.findElements(enteredUserName);
        for (WebElement list : enteredUserName) {
            if (list.getText().equals(cname)) {
                list.click();
                break;
            }
        }
    }


    public void userClickOnLoginButton() {
        Reporter.log("Clicking on continue button" + loginButton.toString());
        clickOnElement(loginButton);
    }

    public void clickOnDeposit() {
        Reporter.log("Clicking on continue button" + depositLinkText.toString());
        clickOnElement(depositLinkText);
    }

    public void enterAmount(String amount) {
        Reporter.log("Enter amount " + amount + " to amount field " + amountField.toString());
        sendTextToElement(amountField, amount);
    }

    public void clickOnDepositButton() {
        Reporter.log("Clicking on continue button" + depositButton.toString());
        clickOnElement(depositButton);
    }

    public String verifyDepositSuccessFull() {
        Reporter.log("Deposit successfull message" + depositSuccessFull.toString());
        return getTextFromElement(depositSuccessFull);
    }

    public void clickOnWithDrawl() {
        Reporter.log("Clicking on withdrawl" + withDrawlText.toString());
        clickOnElement(withDrawlText);
    }

    public void enterAmountToWithdraw(String amount) {
        Reporter.log("Enter amount " + amount + " to withdraw field " + amountToWithdraw.toString());
        clickOnElement(amountToWithdraw);
        sendTextToElement(amountToWithdraw, amount);
    }

    public void clickOnWithdrawButton() {
        Reporter.log("Clicking on withdraw button" + withdrawButton.toString());
        clickOnElement(withdrawButton);
    }

    public String verifyTransactionMessage() {
        Reporter.log("Verifying transaction message");
        return getTextFromElement(transactionMessage);

    }

}

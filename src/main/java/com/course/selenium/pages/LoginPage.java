package com.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    @FindBy(id = "field-email")
    WebElement emailInput;
    @FindBy(id = "field-password")
    WebElement passwordInput;
    @FindBy(id = "submit-login")
    WebElement submitSignInButton;
    @FindBy(css = ".user-info .logout")

    private final WebDriver driver ;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void typeEmailIntoLogin(String mail) {
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(mail);
    }

    public void typePasswordIntoLogin(String password) {
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSignInButton(){
        submitSignInButton.click();
    }

}

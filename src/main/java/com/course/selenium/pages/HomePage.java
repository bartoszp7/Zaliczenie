package com.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    @FindBy(css = ".user-info .hidden-sm-down")
    WebElement signInLink;

    private final WebDriver driver;

    public HomePage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(this.driver,this);
    }

    public void clickSignIn(){
        signInLink.click();
    }
}

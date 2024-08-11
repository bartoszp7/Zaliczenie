package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForElementVisible;

public class CreateNewAddress {

    private final WebDriver driver;

    @FindBy(id = "addresses-link")
    WebElement AddressesButton;
    @FindBy(css = ".addresses-footer span")
    WebElement CreateNewAddressButton;
    @FindBy(id = "field-alias")
    WebElement Alias;
    @FindBy(id = "field-address1")
    WebElement Address;
    @FindBy(id = "field-city")
    WebElement City;
    @FindBy(id = "field-postcode")
    WebElement ZipCode;
    @FindBy(id = "field-id_country")
    WebElement Country;
    @FindBy(id = "field-phone")
    WebElement Phone;
    @FindBy(css = ".btn.btn.btn-primary.form-control-submit")
    WebElement SaveButton;
    By locatorAlertSuccess = By.cssSelector("article.alert-success");

    public CreateNewAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickAddressesButton(){
        AddressesButton.click();
    }

    public void clickCreateNewAddressButton(){
        CreateNewAddressButton.click();
    }

    public void typeAlias(String name) {
        Alias.click();
        Alias.clear();
        Alias.sendKeys(name);
    }

    public void typeAddress(String name) {
        Address.click();
        Address.clear();
        Address.sendKeys(name);
    }
    public void typeCity(String name) {
        City.click();
        City.clear();
        City.sendKeys(name);
    }
    public void typeZipCode(String name) {
        ZipCode.click();
        ZipCode.clear();
        ZipCode.sendKeys(name);
    }
    public void typeCountry(String categoryName) {
        Country.click();
        String expression = String.format("//option[text()= '%s']", categoryName);
        WebElement category = driver.findElement(By.xpath(expression));
        category.click();
    }
    public void typePhone(String name) {
        Phone.click();
        Phone.clear();
        Phone.sendKeys(name);
    }

    public void clickSaveButton(){
        SaveButton.click();
    }

    public String getSuccessMessage(){
        WebElement alert = waitForElementVisible(driver,locatorAlertSuccess);
        return alert.getText().strip();
    }


}
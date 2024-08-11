package com.course.selenium.pages;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class AddNewProducts {

    private final WebDriver driver;

    @FindBy(id = "_desktop_logo")
    WebElement ID;
    @FindBy(xpath = "//a[@href = 'https://mystore-testlab.coderslab.pl/index.php?id_category=3&controller=category']")
    WebElement ClothesButton;
    @FindBy(id = "category-5")
    WebElement WomenClothes;
    @FindBy(xpath = "//a[@href ='https://mystore-testlab.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s']")
    WebElement SweaterChoose;
    @FindBy(id = "group_1")
    WebElement SizeChoose;
    @FindBy(id = "quantity_wanted")
    WebElement Quantity;
    @FindBy(css =".add .btn")
    WebElement AddToCartButton;
    @FindBy(css =".cart-content-btn .btn-primary")
    WebElement ProceedToCheckoutButton;
    @FindBy(css = ".text-sm-center .btn")
    WebElement SecondProceedToCheckoutButton;
    @FindBy(name="confirm-addresses")
    WebElement ContinueButton;
    @FindBy(id = "delivery_option_8")
    WebElement SelfPickUpMethod;
    @FindBy(name = "confirmDeliveryOption")
    WebElement ConfirmDelivery;
    @FindBy(id = "payment-option-1")
    WebElement PaymentOption;
    @FindBy(id ="conditions_to_approve[terms-and-conditions]")
    WebElement TermsAcception;
    @FindBy(css = ".ps-shown-by-js .btn-primary")
    WebElement PlaceOrderButton;
//    @FindBy(css = ".product-discount .regular-price")
//    WebElement RegularPrice;
//    @FindBy (css =".product-price.h5 .current-price-value")
//    WebElement CurrentPrice;
    @FindBy(css = ".discount.discount-percentage")
    WebElement SavePrice;


    public AddNewProducts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void WomenClothesChoose() throws InterruptedException {

        Actions actions = new Actions(driver);

        actions.moveToElement(ClothesButton)
                .pause(java.time.Duration.ofSeconds(1))
                .release()
                .moveToElement(WomenClothes)
                .release()
                .click(WomenClothes)
                .build()
                .perform();
    }

    public void ChooseSweater(){
        SweaterChoose.click();
    }

    public void typeSize(String sizeLetter) {
        SizeChoose.click();
        String expression = String.format("//option[text()= '%s']", sizeLetter);
        WebElement size = driver.findElement(By.xpath(expression));
        size.click();
    }
    public void typeQuantity(String quant) {
        Quantity.click();
        Quantity.sendKeys(Keys.BACK_SPACE);
        //Quantity.clear();
        Quantity.sendKeys(quant);
    }

    public void typeAddToCard(){
        AddToCartButton.click();
    }

    public void typeProceedToCheckout(){
        waitForPageLoaded(driver, By.cssSelector(".cart-content-btn .btn-primary"),"");
        ProceedToCheckoutButton.click();
        SecondProceedToCheckoutButton.click();
    }
    public void typeContinue(){
        ContinueButton.click();
    }

    public void typeDelivery(){
        //SelfPickUpMethod.click();
        ConfirmDelivery.click();
    }

    public void typePayment(){
        PaymentOption.click();
        TermsAcception.click();
    }
    public void typeOrderConfirmation(){
        PlaceOrderButton.click();
    }

    public void screenshot(Scenario scenario){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] src = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(src,"image/png", "screenshot");
    }

    public void checkTheDiscount(){
//        System.out.println("Regular price is: " + RegularPrice.getText());
//        System.out.println("Discount price is: " + CurrentPrice.getText());
        System.out.println("The current discount is: " + SavePrice.getText());
        Assert.assertTrue(driver.findElement(By.cssSelector(".discount.discount-percentage")).getText().contains("SAVE 20%"));
    }


}

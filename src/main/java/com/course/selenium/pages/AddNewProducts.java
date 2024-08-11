package com.course.selenium.pages;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    @FindBy(css = ".add .btn")
    WebElement AddToCartButton;
    @FindBy(css = ".cart-content-btn .btn-primary")
    WebElement ProceedToCheckoutButton;
    @FindBy(css = ".text-sm-center .btn")
    WebElement SecondProceedToCheckoutButton;
    @FindBy(name = "id_address_delivery")
    WebElement AddressConfirm;
    @FindBy(name = "confirm-addresses")
    WebElement ContinueButton;
    @FindBy(id = "delivery_option_8")
    WebElement SelfPickUpMethod;
    @FindBy(name = "confirmDeliveryOption")
    WebElement ConfirmDelivery;
    @FindBy(id = "payment-option-1")
    WebElement PaymentOption;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement TermsAcception;
    @FindBy(css = ".ps-shown-by-js .btn-primary")
    WebElement PlaceOrderButton;
    //    @FindBy(css = ".product-discount .regular-price")
//    WebElement RegularPrice;
//    @FindBy (css =".product-price.h5 .current-price-value")
//    WebElement CurrentPrice;
    @FindBy(css = ".discount.discount-percentage")
    WebElement SavePrice;
    @FindBy(css = ".text-xs-right")
    WebElement FinalPrice;
    @FindBy(css = ".account .hidden-sm-down")
    WebElement UserButton;
    @FindBy(id = "history-link")
    WebElement OrdersHistory;
    @FindBy(xpath = "//li[contains(text(), 'Do not forget to insert your order reference')]')]")
    WebElement OrderId;
    //@FindBy(css = ".label.label-pill.bright")
    @FindBy(xpath = "//span[contains(text(), 'Awaiting check payment')]")
    WebElement OrderStatus;
    @FindBy(css = ".text-xs-right")
    WebElement OrderPrice;


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

    public void ChooseSweater() {
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

    public void typeAddToCard() {
        AddToCartButton.click();
    }

    public void typeProceedToCheckout() {
        waitForPageLoaded(driver, By.cssSelector(".cart-content-btn .btn-primary"), "");
        ProceedToCheckoutButton.click();
        SecondProceedToCheckoutButton.click();
    }

    public void typeContinue() {
        if(!AddressConfirm.isSelected()){
            AddressConfirm.click();
        }
        ContinueButton.click();
    }

    public void typeDelivery() {
        if(!SelfPickUpMethod.isSelected()){
        SelfPickUpMethod.click();}
        ConfirmDelivery.click();
    }

    public void typePayment() {
        PaymentOption.click();
        TermsAcception.click();
    }

    public void typeOrderConfirmation() {
        PlaceOrderButton.click();
    }

    public void screenshot(Scenario scenario) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] src = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(src, "image/png", "screenshot");
    }

    public void checkTheDiscount() {
//        System.out.println("Regular price is: " + RegularPrice.getText());
//        System.out.println("Discount price is: " + CurrentPrice.getText());
        System.out.println("The current discount is: " + SavePrice.getText());
        Assert.assertTrue(driver.findElement(By.cssSelector(".discount.discount-percentage")).getText().contains("SAVE 20%"));
    }

    public void checkTheOrder() {
        String finalPrice = FinalPrice.getText();
        UserButton.click();
        OrdersHistory.click();
        String orderPrice = OrderPrice.getText();

        Assert.assertTrue(driver.findElement(By.cssSelector(".label.label-pill.bright")).getText().contains("Awaiting check payment"));
        System.out.println("Zamówienie zawiera status: " + OrderStatus.getText());

        Assert.assertEquals(finalPrice, orderPrice);
        if(finalPrice.equals(orderPrice)){
            System.out.println("Order price is correct.");
        }
        else{
            System.out.println(("Order price is incorrect."));
        }
   }
    }


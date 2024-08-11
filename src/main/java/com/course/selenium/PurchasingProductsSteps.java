package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.AddNewProducts;
import com.course.selenium.pages.HomePage;
import com.course.selenium.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class PurchasingProductsSteps {

    private final WebDriver driver = BrowserFactory.getDriver();
    LoginPage loginPage;
    HomePage homePage;
    AddNewProducts addNewProducts;


    @Given("a logged out user is on the home page 2")
    public void aLoggedOutUserIsOnTheHomePage() {
        homePage = new HomePage(driver);
    }

    @And("the user clicks {string} button in the upper right corner 2")
    public void theUserClicksButtonInTheUpperRightCorner(String arg0) {
        homePage.clickSignIn();
    }

    @And("the user fills the email and the password fields 2")
    public void userFillsTheEmailAndThePasswordFields() {
        loginPage = new LoginPage(driver);
        loginPage.typeEmailIntoLogin("pcckxdgyinfdzvqdnz@ytnhy.com");
        loginPage.typePasswordIntoLogin("passs");
    }

    @And("the user clicks {string} button 2")
    public void userClicksButton(String arg0) {
        loginPage.clickSignInButton();
    }

    @And("the user choose women clothes option")
    public void theUserChooseWomenClothesOption() throws InterruptedException {
        AddNewProducts addNewProducts = new AddNewProducts(driver);
        addNewProducts.WomenClothesChoose();
    }

    @And("the user clicks in Hummingbird printed sweater")
    public void theUserClicksInHummingbirdPrintedSweater(){
        AddNewProducts addNewProducts = new AddNewProducts(driver);
        waitForPageLoaded(driver, By.xpath("//a[@href ='https://mystore-testlab.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s']"),"id_category=5&controller=category");
        addNewProducts.ChooseSweater();
    }

    @And("the user choose {string} and  {string}")
    public void theUserChooseAnd(String size, String quantity) {
        AddNewProducts addNewProducts = new AddNewProducts(driver);
        addNewProducts.checkTheDiscount();
        addNewProducts.typeSize(size);
        addNewProducts.typeQuantity(quantity);
    }

    @And("the user add this products to cart")
    public void theUserAddThisProductsToCart() {
        AddNewProducts addNewProducts = new AddNewProducts(driver);
        addNewProducts.typeAddToCard();
    }

    @And("the user go to checkout option")
    public void theUserGoToCheckoutOption(){
        AddNewProducts addNewProducts = new AddNewProducts(driver);
        addNewProducts.typeProceedToCheckout();
    }

    @And("the user confirms address")
    public void theUserConfirmsAddress() {
        AddNewProducts addNewProducts = new AddNewProducts(driver);
        addNewProducts.typeContinue();
    }

    @And("the user choose Self pick up method")
    public void theUserChooseSelfPickUpMethod() {
        AddNewProducts addNewProducts = new AddNewProducts(driver);
        addNewProducts.typeDelivery();
    }

    @And("the user choose {string} payment method")
    public void theUserChoosePaymentMethod(String arg0) {
        AddNewProducts addNewProducts = new AddNewProducts(driver);
        addNewProducts.typePayment();
    }

    @And("the user clicks on {string}")
    public void theUserClicksOn(String arg0) {
        AddNewProducts addNewProducts = new AddNewProducts(driver);
        addNewProducts.typeOrderConfirmation();
    }

    @And("the user take a screenshot with order confirmation")
    public void theUserTakeAScreenshotWithOrderConfirmation() throws IOException {
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshotFile.toPath(), new File("D:\\LMS_aut\\screens\\screen.png").toPath());
    }

    @And("the user check the correctness of the order")
    public void theUserCheckTheCorrectnessOfTheOrder() {


    }
}

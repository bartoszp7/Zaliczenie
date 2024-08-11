package com.course.selenium;
import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.CreateNewAddress;
import com.course.selenium.pages.HomePage;
import com.course.selenium.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddNewAddressSteps {

    private final WebDriver driver = BrowserFactory.getDriver();
    LoginPage loginPage;
    CreateNewAddress createNewAddress;
    HomePage homePage;

    @Given("a logged out user is on the home page")
    public void aLoggedOutUserIsOnTheHomePage() {
        homePage = new HomePage(driver);
    }

    @And("the user clicks {string} button in the upper right corner")
    public void theUserClicksButtonInTheUpperRightCorner(String arg0) {
        homePage.clickSignIn();
    }

    @And("the user fills the email and the password fields")
    public void userFillsTheEmailAndThePasswordFields() {
        loginPage = new LoginPage(driver);
        loginPage.typeEmailIntoLogin("pcckxdgyinfdzvqdnz@ytnhy.com");
        loginPage.typePasswordIntoLogin("passs");
    }

    @And("the user clicks {string} button")
    public void userClicksButton(String arg0) {
        loginPage.clickSignInButton();
    }

    @Then("the user is on the Addresses page")
    public void theUserIsOnTheAddressesPage() {
        createNewAddress = new CreateNewAddress(driver);
        createNewAddress.clickAddressesButton();
    }

    @And("the user click in {string} button")
    public void userClickInButton(String arg0) {
        createNewAddress.clickCreateNewAddressButton();
    }

    @And("the user correctly fills required fields {string}, {string}, {string}, {string}, {string}, {string}")
    public void userCorrectlyFillsRequiredFields(String Alias, String Address, String City, String Zip_code, String Country, String Phone) {
        createNewAddress.typeAlias(Alias);
        createNewAddress.typeAddress(Address);
        createNewAddress.typeCity(City);
        createNewAddress.typeZipCode(Zip_code);
        createNewAddress.typeCountry(Country);
        createNewAddress.typePhone(Phone);
    }

    @And("the user clicks {string}")
    public void userClicks(String arg0) {
        createNewAddress.clickSaveButton();
    }

    @Then("my addresses page should include the new address, the account page should display message {string}")
    public void myAddressesPageShouldIncludeTheNewAddressTheAccountPageShouldDisplayMessage(String arg0) {
        Assert.assertEquals(arg0, createNewAddress.getSuccessMessage());
    }
}

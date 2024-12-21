package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AccountPage;
import pages.RegisterPage;
import pages.SearchHomePage;
import utils.TestBase;

import java.util.List;

public class RegisterStepDef extends TestBase {

    static SearchHomePage homePage;
    static RegisterPage registerPage;
    static AccountPage accountPage;

    @When("^click on sign up$")
    public void clickOnSignUp() {
        homePage = new SearchHomePage();
        registerPage = homePage.navigateToSignup();
    }

    @And("^enter user details and new password$")
    public void enterUserEmailAndNewPassword(List<String> details) {
        registerPage.fillAccountDetails(details.get(0),details.get(1));
    }

    @And("^enter user email and new password$")
    public void enterUserEmailAndNewPassword() {
        registerPage.fillAccountDetails();
    }

    @And("^click signup button$")
    public void clickSignup() {
        accountPage = registerPage.clickSignup();
    }

    @Then("^redirected to user account page$")
    public void redirectedToUserAccountPage() {
        accountPage.verifyAccountPage();
    }

    @Then("^show email already exists message$")
    public void showEmailAlreadyExistsMessage() {
        registerPage.errorMessageDisplayed();
    }
}

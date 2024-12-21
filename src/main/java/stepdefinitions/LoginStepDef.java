package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AccountPage;
import pages.LoginPage;
import pages.SearchHomePage;
import utils.TestBase;

import java.util.List;

public class LoginStepDef extends TestBase {

    static SearchHomePage homePage;
    static LoginPage loginPage;
    static AccountPage accountPage;

    @Then("^user account displayed$")
    public void userAccountShown() {
        accountPage.verifyAccountPage();
    }

    @When("^click on login$")
    public void clickOnLogin() {
        homePage = new SearchHomePage();
        loginPage = homePage.navigateToLogin();
    }

    @And("^enter username and password$")
    public void enterUsernameAndPassword(List<String> cred) {
        loginPage.enterLoginDetails(cred.get(0),cred.get(1));
        accountPage = loginPage.clickSubmit();
    }

    @Then("^show invlid email message in login page$")
    public void showInvlidEmailMessageInLoginPage() {
        loginPage.errorMessageDisplayed();
    }
}

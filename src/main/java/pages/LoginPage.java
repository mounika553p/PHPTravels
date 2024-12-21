package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;
import static utils.TestBase.getDriver;
import static utils.TestBase.properties;

public class LoginPage extends BrowserActions {

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(id = "remember-me")
    WebElement rememberMe;

    @FindBy(css = "[type='submit'].loginbtn")
    WebElement loginButton;

    @FindBy(css = ".alert.alert-danger")
    WebElement errorMessage;


    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void enterLoginDetails() {
        sendText(username, properties.getProperty("username"));
        sendText(password,properties.getProperty("password"));
    }

    public void enterLoginDetails(String uname, String pwd) {
        sendText(username,uname);
        sendText(password,pwd);
    }

    public AccountPage clickSubmit() {
        click(loginButton);
        return new AccountPage();
    }

    public boolean errorMessageDisplayed() {
        return thisElementExists(errorMessage);
    }
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;
import static utils.TestBase.getDriver;
import utils.User;

public class RegisterPage extends BrowserActions {

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastname;

    @FindBy(name = "phone")
    WebElement phone;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "confirmpassword")
    WebElement confirmPassword;

    @FindBy(css = "button.signupbtn")
    WebElement signupBtn;

    @FindBy(css = ".alert.alert-danger")
    WebElement errorMessage;


    public RegisterPage() {
        PageFactory.initElements(getDriver(),this);
    }

    public void fillAccountDetails(){
        User user = new User();
        sendText(firstName,user.name);
        sendText(lastname, user.name);
        sendText(email, user.email);
        sendText(password, user.password);
        sendText(confirmPassword, user.password);
    }

    public void fillAccountDetails(String emailID, String pwd){
        User user = new User();
        sendText(firstName,user.name);
        sendText(lastname, user.name);
        sendText(email, emailID);
        sendText(password, pwd);
        sendText(confirmPassword, pwd);
    }

    public AccountPage clickSignup() {
        click(signupBtn);
        return new AccountPage();
    }

    public boolean errorMessageDisplayed() {
        return thisElementExists(errorMessage);
    }
}

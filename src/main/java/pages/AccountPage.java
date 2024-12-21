package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;
import static utils.TestBase.getDriver;

public class AccountPage extends BrowserActions {

    @FindBy(css = ".profile-tabs li")
    WebElement accountCategories;

    @FindBy(id = "bookings")
    WebElement bookings;


    public AccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void verifyAccountPage() {
        thisElementExists(accountCategories);
        thisElementExists(bookings);
    }
}

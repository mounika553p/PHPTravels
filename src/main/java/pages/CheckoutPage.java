package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;
import utils.Helpers;
import static utils.TestBase.getDriver;
import utils.User;

public class CheckoutPage extends BrowserActions {

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "confirmemail")
    WebElement confirmEmail;

    @FindBy(name = "phone")
    WebElement phone;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(css = ".select2-chosen")
    WebElement countryFiled;

    @FindBy(css = ".select2-input")
    WebElement countryInput;

    @FindBy(css= ".select2-results li:nth-child(1)")
    WebElement countryResult;

    @FindBy(css = "[type=submit][name=guest]")
    WebElement submitButton;

    @FindBy(css = ".summary .panel .pull-right")
    WebElement adultsInfo;

    @FindBy(css = ".summary .panel p.m0")
    WebElement roomsInfo;

    @FindBy(css = ".summary li:nth-child(1) .pull-right")
    WebElement checkinInfo;

    @FindBy(css = ".summary li:nth-child(2) .pull-right")
    WebElement checkoutInfo;

    @FindBy(name = "extras[]")
    WebElement extras;


    public CheckoutPage() {
        PageFactory.initElements(getDriver(),this);
    }

    public void enterUserDetails(){
        User user = new User();
        sendText(firstName, user.name);
        sendText(lastName, user.name);
        sendText(email, user.email);
        sendText(confirmEmail, user.email);
        sendText(phone, user.phoneNumber);
        sendText(address, user.address);
        click(countryFiled);
        sendText(countryInput, user.country);
        click(countryResult);
    }

    public BookingConfirmationPage clickSubmit(){
        scrollToElement(submitButton);
        click(submitButton);
        return new BookingConfirmationPage();
    }

    public boolean verifyAdultsCount(String count) {
        return getTextFromElement(adultsInfo).contains(count);
    }

    public boolean verifyRoomsCount(String count) {
        return getTextFromElement(roomsInfo).split("//n")[0].contains(count);
    }

    public boolean verifycheckin() {
        return getTextFromElement(checkinInfo).contains(Helpers.getTodaysDate());
    }

    public boolean verifycheckout() {
        return getTextFromElement(checkoutInfo).contains(Helpers.getDateInFuture());
    }

    public void chooseExtras() {
        click(extras);
    }

    public String getTravelersCount() {
        return  getTextFromElement(adultsInfo);
    }

    public String getRoomsCount() {
        return  getTextFromElement(roomsInfo);
    }
}

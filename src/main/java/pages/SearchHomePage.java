package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;
import utils.Helpers;
import static utils.TestBase.getDriver;

public class SearchHomePage extends BrowserActions {

    @FindBy(css = ".locationlisthotels span.select2-chosen")
    WebElement cityName;

    @FindBy(css = "#select2-drop .select2-input")
    WebElement cityInput;

    @FindBy(css = "#select2-drop .select2-searching")
    WebElement searching;

    @FindBy(css = "#select2-drop .select2-result-label .select2-match:nth-child(1)")
    WebElement autosuggestionCity;

    @FindBy(name = "checkin")
    WebElement checkIn;

    @FindBy(css = ".day.active:last-child")
    WebElement dateInCheckin;

    @FindBy(name = "checkout")
    WebElement checkout;

    @FindBy(id = "travellersInput")
    WebElement travellers;

    @FindBy(id = "adultMinusBtn")
    WebElement minusTravellers;

    @FindBy(name = "adults")
    WebElement adultsCount;

    @FindBy(css = "[name=fCustomHotelSearch] [type=submit]")
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(),'Account')]")
    WebElement myAccount;

    @FindBy(xpath = "//*[contains(text(),'Login')]")
    WebElement login;

    @FindBy(xpath = "//*[contains(text(),'Signup')]")
    WebElement signUp;



    public SearchHomePage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void enterCityInSearchPage(String city) {
        click(cityName);
        sendText(cityInput, city);
        //waitUntilElementInvisible(searching);
        waitUntilElementDisplayed(autosuggestionCity);
        click(autosuggestionCity);
    }

    public void chooseCheckIn() {
        sendText(checkIn, Helpers.getTodaysDate());
    }


    public void chooseCheckOut() {
        sendText(checkout, Helpers.getDateInFuture());
    }

    public void changeNumberOfAdultsToOne() {
        click(travellers);
        click(minusTravellers);
    }

    public String getNumberOfAdults() {
        return getValueFromElement(adultsCount);
    }

    public HotelResultsPage clickSubmit() {
        click(searchButton);
        return new HotelResultsPage();
    }

    public LoginPage navigateToLogin() {
        click(myAccount);
        click(login);
        return new LoginPage();
    }

    public RegisterPage navigateToSignup() {
        click(myAccount);
        click(signUp);
        return new RegisterPage();
    }
}

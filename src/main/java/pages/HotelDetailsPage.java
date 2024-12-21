package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;
import static utils.TestBase.getDriver;

import java.util.List;

public class HotelDetailsPage extends BrowserActions {

    @FindBy(css = "tr:nth-child(1) .control__indicator")
    WebElement roomType;

    @FindBy(css = "tr:nth-child(1) .selectx")
    WebElement noOfRooms;

    @FindBy(css = "[type=submit].book_button")
    WebElement submitButton;

    @FindBy(css = ".mob-row [name='fModifySearch'] [name='adults']")
    WebElement adults;

    @FindBy(css = ".mob-row [name='fModifySearch'] [name='child']")
    WebElement child;

    @FindBy(css = ".mob-row [name='fModifySearch']")
    WebElement modifyBar;

    @FindBy(css = "tr .rtl_pic")
    List<WebElement> availableRooms;

    @FindBy(css = ".mob-row [name='fModifySearch'] [type='submit']")
    WebElement modifyButton;

    public HotelDetailsPage() {
        PageFactory.initElements(getDriver(),this);
    }


    public void selectRoomType() {
        scrollToElement(roomType);
        click(roomType);
    }

    public CheckoutPage clickSubmit(){
        scrollToElement(submitButton);
        click(submitButton);
        return new CheckoutPage();
    }

    public void changeAdultCount(String count){
        scrollDown();
        waitUntilElementDisplayed(adults);
        selectFromListByValue(adults,count);
    }

    public void changeChildCount(String count){
        selectFromListByValue(child,count);
    }

    public int getNumberOfAvailableRooms(){
        return availableRooms.size();
    }

    public void changeRoomCount(String roomCount) {
        scrollDown();
        selectFromListByValue(noOfRooms,roomCount);
    }

    public void clickModifyButton() {
        click(modifyButton);
    }




}

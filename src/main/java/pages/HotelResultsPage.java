package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;
import static utils.TestBase.getDriver;

import java.util.List;

public class HotelResultsPage extends BrowserActions {

    @FindBy(css = "tr:nth-child(1) .price_tab a")
    WebElement hotelDetails;

    @FindBy(css = ".rating .go-right:nth-child(9) .iradio_square-grey")
    WebElement fivestar;

    @FindBy(css = ".rating .go-right:nth-child(7) .iradio_square-grey")
    WebElement fourstar;

    @FindBy(css = ".rating .go-right:nth-child(5) .iradio_square-grey")
    WebElement threestar;

    @FindBy(css = ".rating .go-right:nth-child(3) .iradio_square-grey")
    WebElement twostar;

    @FindBy(css = ".rating .go-right:nth-child(1) .iradio_square-grey")
    WebElement onestar;

    @FindBy(css = "[name='fFilters'] [type='submit']")
    WebElement searchWithFilters;

    @FindBy(css = ".listingbg tr")
    List<WebElement> hotelsList;

    @FindBy(css = ".listingbg tr:nth-child(1) .fa-star")
    List<WebElement> starsForFirstHotel;

    @FindBy(css = "tr:nth-child(1) .go-right:nth-child(2) a:nth-child(2)")
    WebElement hotelLocation;

    @FindBy(css = "tr:nth-child(1) .hotelpreferences [data-original-title='Airport Transport']")
    WebElement hotelPreferences_airporttransit;

    @FindBy(css = "tr:nth-child(1) .hotelpreferences [data-original-title='Elevator']")
    WebElement hotelPreferences_elevator;

    @FindBy(css = "[for='Airport Transport']")
    WebElement airportTransitFilter;

    @FindBy(css = "[for='Elevator']")
    WebElement elevatorFilter;


    public HotelResultsPage() {
        PageFactory.initElements(getDriver(),this);
    }

    public HotelDetailsPage selectFirstAvailableRoom() {
        click(hotelDetails);
        return new HotelDetailsPage();
    }

    public boolean checkHotelResults() {
        return true;
    }

    public void chooseOneStar() { click(onestar); }

    public void chooseTwoStar() { click(twostar); }

    public void chooseThreeStar() { click(threestar); }

    public void chooseFourStar() { click(fourstar); }

    public void chooseFiveStar() { click(fivestar); }

    public void clickSearchWithFilters() {
        scrollToElement(searchWithFilters);
        click(searchWithFilters);
    }

    public int checkIfHotelsAreFilteredWithFiveStar() {
        return starsForFirstHotel.size();
    }


    public boolean verifyIfHotelsAreShownAsPerCity(String city) {
        return getTextFromElement(hotelLocation).equalsIgnoreCase(city);
    }

    public void chooseAirportTransportFilter() {
        click(airportTransitFilter);
    }

    public void chooseElevatorFilter() {
        click(elevatorFilter);
    }

    public boolean verifyIfHotelsAreShownForAirportFilter() {
        return thisElementExists(hotelPreferences_airporttransit);
    }

    public boolean verifyIfHotelsAreShownForElevatorFilter() {
        return thisElementExists(hotelPreferences_elevator);
    }
}

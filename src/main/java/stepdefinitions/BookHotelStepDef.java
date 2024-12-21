package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;
import static utils.TestBase.getDriver;
import utils.TestBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookHotelStepDef extends TestBase {

    static SearchHomePage homePage;
    static HotelResultsPage hotelResultsPage;
    static HotelDetailsPage hotelDetailsPage;
    static CheckoutPage checkoutPage;
    static BookingConfirmationPage bookingConfirmationPage;

    static int availableRooms;

    @And("^search for hotels$")
    public void searchForHotel() {
        hotelResultsPage = homePage.clickSubmit();
    }

    @Given("^booking site is open$")
    public void bookingSiteIsOpen() {
        homePage = new SearchHomePage();
    }

    @When("^enter city and date to book hotel$")
    public void enterCityAndDateToBookHotel() {
        homePage.enterCityInSearchPage("Hamburg");
        homePage.chooseCheckIn();
        homePage.chooseCheckOut();
    }

    @Then("^close browser$")
    public void closeBrowser() {
        getDriver().quit();
    }

    @And("^change adults to one$")
    public void changeAdultsToOne() {
        homePage.changeNumberOfAdultsToOne();
        assert homePage.getNumberOfAdults().equalsIgnoreCase("1");
    }

    @Then("^check hotel results$")
    public void checkHotelResults() {
        assert hotelResultsPage.checkHotelResults();
    }

    @And("^choose first hotel$")
    public void chooseFirstHotel() {
        hotelDetailsPage = hotelResultsPage.selectFirstAvailableRoom();
    }

    @And("^choose room and submit$")
    public void chooseRoomType() {
        hotelDetailsPage.selectRoomType();
        checkoutPage = hotelDetailsPage.clickSubmit();
    }

    @And("^enter user details$")
    public void enterUserDetails() {
        checkoutPage.enterUserDetails();
    }

    @And("^submit booking$")
    public void submitBooking() {
        bookingConfirmationPage = checkoutPage.clickSubmit();
    }

    @Then("^Hotel booking confirmation shown$")
    public void hotelBookingConfirmationShown() {
        assertTrue(bookingConfirmationPage.checkBookingConfirmedWithoutPayment());
    }


    @When("^enter \"([^\"]*)\" and date to book hotel$")
    public void enterCityGivenAndDateToBookHotel(String city) {
        homePage.enterCityInSearchPage(city);
        homePage.chooseCheckIn();
        homePage.chooseCheckOut();
    }

    @And("^filter for five star hotels$")
    public void filterForFiveStarHotels() {
        hotelResultsPage.chooseFiveStar();
        hotelResultsPage.clickSearchWithFilters();
    }

    @Then("^verify five star hotels shown$")
    public void verifyFiveStarHotelsShown() {
        assertEquals(hotelResultsPage.checkIfHotelsAreFilteredWithFiveStar(),5);
    }


    @Then("^check available rooms after modify$")
    public void checkAvailableRoomsAfterModify() {
        assertTrue(hotelDetailsPage.getNumberOfAvailableRooms()<=availableRooms);
    }

    @Then("^check available rooms$")
    public void checkAvailableRooms() {
        assertTrue(hotelDetailsPage.getNumberOfAvailableRooms()>=1);
    }

    @When("^enter specific \"([^\"]*)\" and date to book hotel$")
    public void enter_specific_and_date_to_book_hotel(String city) {
        homePage.enterCityInSearchPage(city);
        homePage.chooseCheckIn();
        homePage.chooseCheckOut();
    }

    @Then("^check hotel results for specific \"([^\"]*)\"$")
    public void check_hotel_results_for_specific(String city) {
       assertTrue(hotelResultsPage.verifyIfHotelsAreShownAsPerCity(city));

    }

    @Then("^check results are shown for airport transit$")
    public void check_hotel_results_are_shown_for_airport_transit() {
        assertTrue(hotelResultsPage.verifyIfHotelsAreShownForAirportFilter());

    }

    @Then("^check results are shown for elevator$")
    public void check_hotel_results_are_shown_for_elevator() {
        assertTrue(hotelResultsPage.verifyIfHotelsAreShownForElevatorFilter());

    }

    @And("^verify booking summary$")
    public void verify_booking_summary(){
        checkoutPage.verifycheckin();
        checkoutPage.verifycheckout();
    }

    @When("^choose pay later$")
    public void choosePayLater() {
        bookingConfirmationPage.clickOnArrivalPay();
    }

    @Then("^verify invoice$")
    public void verifyInvoice() {
        bookingConfirmationPage.verifyDownloadInvoice();

    }

    @And("^Modify traveler count\"([^\"]*)\"$")
    public void modifyTravelerCount(String travelercount){
        availableRooms = hotelDetailsPage.getNumberOfAvailableRooms();
        hotelDetailsPage.changeAdultCount(travelercount);
        hotelDetailsPage.changeChildCount("1");
        hotelDetailsPage.clickModifyButton();
    }

    @Then("^verify booking summary with new traveler count \"([^\"]*)\"$")
    public void verifyBookingSummaryWithNewTravelercount(String travelercount) {
        assertTrue(checkoutPage.getTravelersCount().contains(travelercount));
    }

    @And("^Modify room count \"([^\"]*)\"$")
    public void modifyRoomCount(String roomcount) {
            hotelDetailsPage.changeRoomCount(roomcount);
    }

    @Then("^verify booking summary with new room count \"([^\"]*)\"$")
    public void verifyBookingSummaryWithNewRoomcount(String roomcount){
        assertTrue(checkoutPage.getRoomsCount().contains(roomcount));
    }
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;
import static utils.TestBase.getDriver;

public class BookingConfirmationPage extends BrowserActions {

    @FindBy(id = "downloadInvoice")
    WebElement downloadInvoice;

    @FindBy(css = ".arrivalpay")
    WebElement payOnArrival;

    @FindBy(id = "invoiceTable")
    WebElement invoice;


    public BookingConfirmationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickOnArrivalPay(){
        click(payOnArrival);
        getDriver().switchTo().alert().accept();
    }

    public boolean checkBookingConfirmedWithoutPayment(){
        return thisElementExists(invoice);
    }

    public boolean verifyDownloadInvoice() {
        return thisElementExists(downloadInvoice);
    }


}

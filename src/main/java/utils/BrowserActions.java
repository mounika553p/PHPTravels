package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static utils.TestBase.*;


public class BrowserActions {

    public static void click(WebElement element){
        waitUntilElementDisplayed(element);
        element.click();
    }

    public static void sendText(WebElement element, String text){
        element.sendKeys(text);
    }

//    public static void waitUntilElementInvisible(WebElement element){
//        getFluentWait().until(ExpectedConditions.invisibilityOf(element));
//    }

    public static void waitUntilElementDisplayed(WebElement element){
        //getFluentWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void selectFromListByIndex(WebElement list, int option) {
        new Select(list).selectByIndex(option);
    }

    public static void selectFromListByValue(WebElement list, String value) {
        new Select(list).selectByValue(value);
    }

    public static String getTextFromElement(WebElement element){
        return element.getText();
    }

    public static void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,1000)");
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static boolean thisElementExists(WebElement element) {
        try {
            //getFluentWait().until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch(TimeoutException e)
        {
            return false;
        }
    }

    public static String getValueFromElement(WebElement element){
        return element.getAttribute("value");
    }

}

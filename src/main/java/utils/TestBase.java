package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestBase {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static Properties properties;

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver() {
        WebDriver webDriver;
        if (properties.getProperty("browser") == "chrome") {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);
            webDriver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
            webDriver.manage().timeouts().implicitlyWait(30, SECONDS);
            webDriver.manage().window().maximize();
        }else if(properties.getProperty("browser") == "firefox") {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
            //TODO: implement firefox setup
        }else {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);
            webDriver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
            webDriver.manage().timeouts().implicitlyWait(30, SECONDS);
            webDriver.manage().window().maximize();
        }
        driver.set(webDriver);
    }

    public static void loadProperties() {

        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/configuration/browser_config.properties"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static FluentWait getFluentWait() {
        Integer fluentWaitInterval = Integer.parseInt(properties.getProperty("fluent_wait"));
        FluentWait fluentWait = new FluentWait(getDriver())
                .withTimeout(fluentWaitInterval, SECONDS)
                .pollingEvery(1, SECONDS)
                .ignoring(NoSuchElementException.class);
        return fluentWait;
    }


}

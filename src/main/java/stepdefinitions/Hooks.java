package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.TestBase;

import java.net.MalformedURLException;

public class Hooks extends TestBase{

    @Before
    public void setup() throws MalformedURLException {
        System.out.println("TestBefore");
        loadProperties();
        setDriver();
        getDriver().get(properties.getProperty("url"));
    }

    @After
    public void tearDown() {
        System.out.println("TestAfter");
        TestBase.driver.get().quit();
    }
}

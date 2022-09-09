package org.selenium.webshop;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import runner.WebDriverRunner;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new WebDriverRunner().createWebDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver.toString() != null) {
            driver.close();
        }
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    WebDriver driver;

    private final By orderReceivedTable = By.id("post-7");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(orderReceivedTable).isDisplayed();
    }
}

package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class MainPage {

    WebDriver driver;
    private final By mainPageTitle = By.className("custom-logo");
    private final By searchIcon = By.className("noo-search");
    private final By searchField = By.className("form-control");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate to specified URL.")
    public MainPage navigateToUrl(String url) {
        driver.get(url);
        return this;
    }

    @Step("Verify if specified URL is opened.")
    public MainPage verifyIfMainPageIsOpened() {
        assertEquals("ToolsQA Demo Site", driver.findElement(mainPageTitle).getAttribute("alt"));
        return this;
    }

    @Step("Search for specific product.")
    public CataloguePage searchForProduct(String product) {
        driver.findElement(searchIcon).isDisplayed();
        driver.findElement(searchIcon).click();
        driver.findElement(searchField).isDisplayed();
        driver.findElement(searchField).sendKeys(product);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return new CataloguePage(driver);
    }
}

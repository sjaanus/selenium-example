package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CheckoutPage {

    WebDriver driver;
    private static final int TIMEOUT = 30;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(firstNameField).isDisplayed();
    }

    private final By firstNameField = By.id("billing_first_name");
    private final By lastNameField = By.id("billing_last_name");
    private final By countryDropdown = By.id("select2-billing_country-container");
    private final By specificCountry = By.className("select2-results__option");
    private final By addressOneField = By.id("billing_address_1");
    private final By addressTwoField = By.id("billing_address_2");
    private final By postcodeField = By.id("billing_postcode");
    private final By cityField = By.id("billing_city");
    private final By phoneNumberField = By.id("billing_phone");
    private final By emailField = By.id("billing_email");
    private final By termsCheckbox = By.id("terms");
    private final By placeOrderButton = By.id("place_order");
    private final By loadingIcon = By.cssSelector(".blockUI.blockOverlay");


    @Step("Fill in billing data.")
    public CheckoutPage fillBillingData(String firstName, String lastName, String addressOne, String addressTwo,
                                        String postcode, String city, String country, String phoneNumber, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(countryDropdown).click();
        selectCountry(country);
        driver.findElement(addressOneField).sendKeys(addressOne);
        driver.findElement(addressTwoField).sendKeys(addressTwo);
        driver.findElement(postcodeField).sendKeys(postcode);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(emailField).sendKeys(email);
        wait.until(invisibilityOf(driver.findElement(loadingIcon)));
        wait.until(visibilityOf(driver.findElement(termsCheckbox))).click();
        return this;
    }

    @Step("Place selected order.")
    public OrderPage placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(elementToBeClickable(placeOrderButton));
        driver.findElement(placeOrderButton).click();
        return new OrderPage(driver);
    }


    private void selectCountry(String country){
        List<WebElement> countryList = driver.findElements(specificCountry);
        countryList.stream().filter(elem-> elem.getText().contains(country)).findFirst().get().click();
    }
}

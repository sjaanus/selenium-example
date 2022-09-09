package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    private final By goToCheckoutButton = By.cssSelector(".checkout-button.button.alt.wc-forward");
    private final By discountCodeField = By.id("noo_coupon_code");
    private final By applyDiscountButton = By.className("noo-apply-coupon");
    private final By discountAddedMessage = By.className("woocommerce-message");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(goToCheckoutButton).isDisplayed();
    }

    @Step("Open checkout page.")
    public CheckoutPage openCheckout() {
        driver.findElement(goToCheckoutButton).isDisplayed();
        driver.findElement(goToCheckoutButton).click();
        return new CheckoutPage(driver);
    }

    @Step("Input discount code.")
    public CartPage inputDiscountCode(String discountCode) {
        driver.findElement(discountCodeField).isDisplayed();
        driver.findElement(discountCodeField).sendKeys(discountCode);
        driver.findElement(applyDiscountButton).isDisplayed();
        driver.findElement(applyDiscountButton).click();
        driver.findElement(discountAddedMessage).isDisplayed();
        return this;
    }
}

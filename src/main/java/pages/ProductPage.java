package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    private final By quantityButton = By.className("noo-quantity-attr");
    private final By quantityField = By.name("quantity");
    private final By sizeDropdown = By.id("size");
    private final By addToCartButton = By.className("single_add_to_cart_button");
    private final By successfulMessage = By.className("woocommerce-message");
    private final By goToCartButton = By.className("icon_bag_alt");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(quantityButton).isDisplayed();
    }

    @Step("Add selected item to cart.")
    public ProductPage addToCart(String amount, String size) {
        driver.findElement(quantityField).isDisplayed();
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(amount);
        driver.findElement(sizeDropdown).isDisplayed();
        driver.findElement(sizeDropdown).sendKeys(size);
        driver.findElement(addToCartButton).isDisplayed();
        driver.findElement(addToCartButton).click();
        driver.findElement(successfulMessage).isDisplayed();
        return this;
    }

    @Step("Open shopping cart.")
    public CartPage openCart() {
        driver.findElement(goToCartButton).isDisplayed();
        driver.findElement(goToCartButton).click();
        return new CartPage(driver);
    }
}

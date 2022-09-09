package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CataloguePage {

    WebDriver driver;

    private final By products = By.cssSelector(".noo-product-inner");
    private final By catalogueFilter = By.className("noo-catalog");

    public CataloguePage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(catalogueFilter).isDisplayed();
    }

    @Step("Select specific product.")
    public ProductPage selectProduct (String product) {
        List<WebElement> productList = driver.findElements(products);
        productList.stream().filter(elem-> elem.getText().contains(product.toUpperCase())).findFirst().get().click();
        return new ProductPage(driver);
    }
}

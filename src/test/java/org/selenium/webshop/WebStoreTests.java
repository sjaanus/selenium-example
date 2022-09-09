package org.selenium.webshop;

import org.testng.annotations.Test;
import pages.MainPage;

public class WebStoreTests extends BaseTest {

    @Test
    public void searchItemTest() {
        new MainPage(driver)
                .navigateToUrl("https://shop.demoqa.com/")
                .verifyIfMainPageIsOpened()
                .searchForProduct("Shirt");
    }

    @Test
    public void addToCartTest() {
        new MainPage(driver)
                .navigateToUrl("https://shop.demoqa.com/")
                .verifyIfMainPageIsOpened()
                .searchForProduct("Black")
                .selectProduct("Tokyo Talkies")
                .addToCart("1", "S");
    }

    @Test
    public void purchaseItemTest() {
        new MainPage(driver)
                .navigateToUrl("https://shop.demoqa.com/")
                .verifyIfMainPageIsOpened()
                .searchForProduct("Black")
                .selectProduct("Tokyo Talkies")
                .addToCart("2", "L")
                .openCart()
                .openCheckout()
                .fillBillingData("Margus", "Mets", "Lai 1",
                        "18", "10133", "Tallinn", "Estonia","+3725513223", "test@info.ee")
                .placeOrder();
    }

    @Test
    public void discountCodeTest() {
        new MainPage(driver)
                .navigateToUrl("https://shop.demoqa.com/")
                .verifyIfMainPageIsOpened()
                .searchForProduct("Black")
                .selectProduct("Tokyo Talkies")
                .addToCart("1", "S")
                .openCart()
                .inputDiscountCode("incorrect_code");
    }
}

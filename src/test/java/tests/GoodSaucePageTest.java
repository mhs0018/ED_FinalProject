package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.GoodSaucePage;

import java.util.List;

public class GoodSaucePageTest {

    private WebDriver driver;
    private GoodSaucePage page;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        page = new GoodSaucePage(driver);   // ✔ ahora sí: constructor correcto
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testCheckoutFlow() {
        page.login("standard_user", "secret_sauce");
        page.goToInventory();
        page.addToCart("add-to-cart-sauce-labs-backpack");
        page.addToCart("add-to-cart-sauce-labs-bike-light");
        page.openCart();
        page.checkout("Marina", "Test", "29000");

        Assertions.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
    }

    @Test
    void testGetAllProductNames() {
        page.login("standard_user", "secret_sauce");
    }
}
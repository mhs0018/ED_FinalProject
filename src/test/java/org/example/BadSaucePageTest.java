package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class BadSaucePageTest {

    private WebDriver driver;
    private BadSaucePage page;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        page = new BadSaucePage();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testDoEverything() {
        page.doEverything(driver, "standard_user", "secret_sauce");
        Assertions.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
    }

    @Test
    void testGetAllProductNames() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<String> names = page.getAllProductNames(driver);
        Assertions.assertFalse(names.isEmpty());
    }

    @Test
    void testAnadirProductoAlCarrito() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Añadir un producto
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Verificar que el carrito muestra "1"
        WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
        Assertions.assertEquals("1", badge.getText());
    }


}

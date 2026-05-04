package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
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
        page = new GoodSaucePage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testLoginIncorrecto() {
        page.login("standard_user", "wrong_password");

        WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));

        Assertions.assertTrue(
                error.getText().contains("Username and password do not match"),
                "Should show an error message for invalid login"
        );
    }



    @Test
    void testGetAllProductNames() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<String> names = page.getAllProductNames();
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
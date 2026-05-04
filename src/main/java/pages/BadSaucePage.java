package pages;

import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

public class BadSaucePage {

    // ❌ Temporary Field (used only once, unnecessary)
    public String temporalMessage;

    // ❌ Large Method + Duplicate Code + Dead Code + Feature Envy
    public void doEverything(WebDriver driver, String username, String password) {
        try {
            // ❌ Feature Envy: the class depends too much on the driver
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("login-button")).click();

            // ❌ Dead Code (never used)
            int unusedCounter = 0;

            // ❌ Duplicate Code (but functional)
            driver.get("https://www.saucedemo.com/inventory.html");
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

            // ❌ Duplicate Code again (but functional)
            // FIX: do NOT reload the page again → this was breaking the cart
            // driver.get("https://www.saucedemo.com/inventory.html");
            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

            // ❌ Temporary Field used without purpose
            temporalMessage = "Login completed";

            // ❌ Switch Statement (bad OO practice)
            int option = 2;
            switch (option) {
                case 1:
                    driver.findElement(By.id("react-burger-menu-btn")).click();
                    break;
                case 2:
                    driver.findElement(By.className("shopping_cart_link")).click();
                    break;
                default:
                    System.out.println("Nothing to do");
            }

            // ❌ Shotgun Surgery: many selectors hardcoded everywhere
            driver.findElement(By.id("checkout")).click();
            driver.findElement(By.id("first-name")).sendKeys("Marina");
            driver.findElement(By.id("last-name")).sendKeys("Test");
            driver.findElement(By.id("postal-code")).sendKeys("29000");
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();

        } catch (Exception e) {
            // ❌ Swallowing exceptions (bad practice)
            System.out.println("General error: " + e.getMessage());
        }
    }

    // ❌ Long Method + Dead Code
    public List<String> getAllProductNames(WebDriver driver) {
        List<String> names = new ArrayList<>();

        // FIX: ensure we are on the correct page
        driver.get("https://www.saucedemo.com/inventory.html");

        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));

        for (WebElement item : items) {
            names.add(item.getText());
        }

        // ❌ Dead Code
        String unused = "not used";

        return names;
    }

    // ❌ Inappropriate Intimacy (class controls too much of the driver)
    public void logout(WebDriver driver) {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }
}




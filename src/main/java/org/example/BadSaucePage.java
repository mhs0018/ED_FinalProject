package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class BadSaucePage {

    // ❌ Temporary Field (solo se usa en un método)
    public String temporalMessage;

    // ❌ Large Class + Long Method + Duplicate Code + Dead Code
    public void doEverything(WebDriver driver, String username, String password) {
        try {
            // ❌ Feature Envy: la clase depende demasiado del driver
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("login-button")).click();

            // ❌ Dead Code (nunca se usa)
            int unusedCounter = 0;

            // ❌ Duplicate Code
            driver.get("https://www.saucedemo.com/inventory.html");
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

            // ❌ Duplicate Code otra vez
            driver.get("https://www.saucedemo.com/inventory.html");
            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

            // ❌ Temporary Field usada sin sentido
            temporalMessage = "Login realizado";

            // ❌ Switch Statement (mala práctica OO)
            int option = 2;
            switch (option) {
                case 1:
                    driver.findElement(By.id("react-burger-menu-btn")).click();
                    break;
                case 2:
                    driver.findElement(By.className("shopping_cart_link")).click();
                    break;
                default:
                    System.out.println("Nada que hacer");
            }

            // ❌ Shotgun Surgery: si cambia un selector, hay que cambiarlo en 20 sitios
            driver.findElement(By.id("checkout")).click();
            driver.findElement(By.id("first-name")).sendKeys("Marina");
            driver.findElement(By.id("last-name")).sendKeys("Test");
            driver.findElement(By.id("postal-code")).sendKeys("29000");
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();

        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }

    // ❌ Método gigante innecesario (Long Method)
    public List<String> getAllProductNames(WebDriver driver) {
        List<String> names = new ArrayList<>();
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));

        for (WebElement item : items) {
            names.add(item.getText());
        }

        // ❌ Dead Code
        String unused = "no se usa";

        return names;
    }

    // ❌ Inappropriate Intimacy (la clase controla demasiado al driver)
    public void logout(WebDriver driver) {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }
}

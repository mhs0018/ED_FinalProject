package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GoodSaucePage {
    private final WebDriver driver;

    // ❌ NO Temporary Field
    public GoodSaucePage(WebDriver driver) {
        this.driver = driver;
    }
    // ❌ NO Large Class + Long Method + Duplicate Code + Dead Code First we will use shorter methods

    // ❌ NO Feature Envy, just a shorter method with only one responsability
    public void login(String "username", String "password") {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
    }

    // ❌ NO Dead Code

    // ❌ NO Duplicate Code --> A reusable method
    public void addToCart(String "productId") {
        driver.findElement(By.id("productId")).click();
    }
    // ❌ No unnecessary Temporary Field. A Clean method to go to the inventary
    public void goToInventory() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    // ❌ NO Switch Statement, better in two or more methods
    public void openCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public void openMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    // ❌ NO Shotgun Surgery --> Better a short method for the checkout
    public void checkout(String nombre, String apellido, String cp){
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys(nombre);
        driver.findElement(By.id("last-name")).sendKeys(apellido);
        driver.findElement(By.id("postal-code")).sendKeys(cp);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
    }
    //❌ Because it's no longer just one method, we don't use an Exception here




}

// ❌ Not an unnecesary Giant method Método gigante innecesario (Long Method)
public List<String> getAllProductNames() {
    List<String> names = new ArrayList<>();
    List<WebElement> items = items.findElements(By.className("inventory_item_name"));

    for (WebElement item : items) {
        names.add(item.getText());
    }
    return names;
}

// ❌ NO Dead Code





// ❌ NO Inappropriate Intimacy --> Simple and Clean method to logout
public void logout() {
    openMenu();
    driver.findElement(By.id("logout_sidebar_link")).click();
}
    }

            }
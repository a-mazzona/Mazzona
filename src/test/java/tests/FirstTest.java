package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstTest {

    private WebDriver driver;


    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initChromeDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(5000);
        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeButton.click();
        Thread.sleep(5000);
    }

    @Test
    public void secondTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.id("item_4_title_link"));
        String title = element.getText();
        Assertions.assertEquals(title, "Sauce Labs Backpack");
        System.out.println(title);
        Thread.sleep(5000);

    }

    @Test
    public void thirdTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(By.className("inventory_item_desc"));
        String description = elements.get(2).getText();
        System.out.println(description);
        Thread.sleep(5000);

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}

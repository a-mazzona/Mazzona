package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        Thread.sleep(5000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(5000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}

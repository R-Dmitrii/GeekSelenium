package Lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class AvtoruTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String AUTORU_BASE_URL = "https://4brain.ru/";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(AUTORU_BASE_URL);

    }

    @Test
    void workWithSkillsTest() {
        login();
        skillSelection();


    }



       @AfterEach
        void tearDown() {
           driver.quit();
    }

    void login() {
        driver.findElement(By.xpath("//a[@href='https://4brain.ru/login.php']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login']")));
        driver.findElement(By.xpath("//input[@name='login']")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("dmitrii-test@rambler.ru");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("8QGWB8II");
        driver.findElement(By.xpath("//button[.='Войти']")).click();
    }

    void skillSelection() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='skills.php']")));
        driver.findElement(By.xpath("//a[@href='courses.php']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='mystats.php']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//a[@href='mystats.php']")).isDisplayed(), true);
    }
}

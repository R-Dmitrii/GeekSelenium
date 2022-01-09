package Lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OzonTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String OZON_BASE_URL = "https://www.ozon.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(OZON_BASE_URL);
    }
        @Test
        void WorkWithTheSite() {
        XiaomiSearch();
    }

        void XiaomiSearch() {
            driver.findElement(By.xpath("//span[text()='Каталог']")).click();
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Смартфоны']")));
            driver.findElement(By.xpath("//span[text()='Смартфоны']")).click();
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    ("//a[@href='/category/smartfony-xiaomi-redmi/']")));
            driver.findElement(By.xpath("//a[@href='/category/smartfony-xiaomi-redmi/']")).click();
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    ("//a[@href='/category/smartfony-xiaomi-redmi7/']")));
            driver.findElement(By.xpath("//a[@href='/category/smartfony-xiaomi-redmi7/']")).click();
            Assertions.assertEquals(driver.findElement(By.xpath("//div/h1[@class='b3a0']"))
                    .isDisplayed(), true);
        }

        @AfterEach
        void tearDown() {
           driver.quit();
        }

}
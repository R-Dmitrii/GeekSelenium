package Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class authorization_avito {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://avito.ru");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@data-marker='header/login-button']")).click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("+79773747034");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sadw7799");
        driver.findElement(By.xpath("//button[@name='submit']")).click();

    }
}

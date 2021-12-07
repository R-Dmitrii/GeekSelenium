package Lesson_3;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search_avito {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://avito.ru");

        Cookie cookie = new Cookie("sessid", "b1346243573c761429e8ea95211125f9.1638906691");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        driver.findElement(By.xpath("//a[@href='/moskva/transport?cd=1']")).click();
            driver.findElement(By.xpath("//*[@id='app']/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/a")).click();
            //driver.findElement(By.xpath("//input[@placeholder='Модель']")).sendKeys("M5");
            driver.findElement(By.xpath("//*[@id='app']/div[4]/div[3]/div[3]/div[1]/div[2]/div[19]/a")).click();
            //driver.findElement(By.xpath("//div/span[text()='Поколение']")).sendKeys("F90 2020г");
        driver.findElement(By.xpath("//div/a[@title='F90 рестайлинг (2020—н. в.)']")).click();
        driver.findElement(By.xpath("//span[text()='Показать 10 объявлений']")).click();

        driver.quit();



    }
}

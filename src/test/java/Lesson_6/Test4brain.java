package Lesson_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4brain {
    WebDriver driver;
    MainPage mainPage;
    LoginBlock loginBlock;
    private final static String FOBRAIN_BASE_URL = "https://4brain.ru/";


    @BeforeAll
    static  void registerDriver() {

        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginBlock = new LoginBlock(driver);
        driver.get(FOBRAIN_BASE_URL);
    }

    @Test
    void SearchCoursesTest() throws InterruptedException {
        new MainPage(driver)
                .clickLoginButton();

        new LoginBlock(driver)
                .fillLoginInput("dmitrii-test@rambler.ru")
                .fillPasswordInput("8QGWB8II")
                .submitLogin();

        Thread.sleep(3000);

        new MainPage(driver)
                .clickToCourses()
                .clickMystats();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

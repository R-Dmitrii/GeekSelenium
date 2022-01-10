package Lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BaseView {


    @FindBy(xpath = "//a[@href='https://4brain.ru/login.php']")
    WebElement loginButton;

    public MainPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    @FindBy(xpath = "//a[@href='courses.php']")
    private WebElement Courses;

    public MainPage clickToCourses() {
        Courses.click();
        return this;
    }

    @FindBy(xpath = "//a[@href='mystats.php']")
    private WebElement Mystats;

    public MainPage clickMystats(){
        Mystats.click();
        return this;
    }


    public MainPage(WebDriver driver) {
        super(driver);
    }
}

package Lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginBlock extends BaseView {

    public LoginBlock(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginInput;

    public LoginBlock fillLoginInput(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    public LoginBlock fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }


    @FindBy(xpath = "//button[.='Войти']")
    private WebElement submitLoginButton;

    public LoginBlock submitLogin() {
        submitLoginButton.click();
        return this;
    }
}
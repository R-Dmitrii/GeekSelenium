package Lesson_6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginBlock extends BaseView {

    public LoginBlock(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginInput;

    @Step("Ввести логин в поле для логина")
    public LoginBlock fillLoginInput(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @Step("Ввести пароль в поле для пароля")
    public LoginBlock fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }


    @FindBy(xpath = "//button[.='Войти']")
    private WebElement submitLoginButton;

    @Step("Нажать на кнопку Войти")
    public LoginBlock submitLogin() {
        submitLoginButton.click();
        return this;
    }
}
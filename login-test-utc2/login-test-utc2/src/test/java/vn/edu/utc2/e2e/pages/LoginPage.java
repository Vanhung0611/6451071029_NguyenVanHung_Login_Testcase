package vn.edu.utc2.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import vn.edu.utc2.e2e.base.BasePage;

public class LoginPage extends BasePage {
    public static final String URL = "https://vanphongdientu.utc.edu.vn/Login";

    // Locators chuẩn theo DOM trang UTC
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("userpwd");
    private final By loginButton = By.cssSelector("input.submit_login");
    private final By rememberMeDisplay = By.cssSelector("label.check");
    private final By rememberMeCheckbox = By.id("persistent");
    private final By forgotPasswordLink = By.cssSelector("a[href='/Login/GetPass']");
    private final By emailUtcButton = By.xpath("//a[contains(text(), 'e-mail UTC')]");
    private final By helpDeskLink = By.cssSelector("a[href='http://hotrokythuat.utc.edu.vn']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(URL);
        return this;
    }

    public void fillUsername(String username) {
        type(usernameField, username);
    }

    public void fillPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void loginAs(String username, String password) {
        if (username != null && !username.isEmpty()) {
            fillUsername(username);
        }
        if (password != null && !password.isEmpty()) {
            fillPassword(password);
        }
        clickLogin();
    }

    public void toggleRememberMe() {
        click(rememberMeDisplay);
    }

    public boolean isRememberMeChecked() {
        WebElement el = driver.findElement(rememberMeCheckbox);
        return el.isSelected();
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

    public void clickEmailUtcLogin() {
        click(emailUtcButton);
    }

    public void clickHelpDeskLink() {
        click(helpDeskLink);
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("/Login");
    }

    public String getPasswordInputType() {
        return driver.findElement(passwordField).getAttribute("type");
    }
}
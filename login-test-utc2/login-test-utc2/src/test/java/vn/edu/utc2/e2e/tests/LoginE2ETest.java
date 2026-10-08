package vn.edu.utc2.e2e.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vn.edu.utc2.e2e.base.BaseTest;
import vn.edu.utc2.e2e.pages.LoginPage;

import java.time.Duration;

@Epic("Web UI Testing UTC")
@Feature("Automation Test Login")
public class LoginE2ETest extends BaseTest {

    @Test
    @DisplayName("TC1: Để trống user hoặc pass word (chỉ nhập pass)")
    @Story("TC1 - Để trống Username")
    void test_TC1_emptyUsername() {
        LoginPage loginPage = new LoginPage(driver).open();
        loginPage.loginAs("", "1256");

        Assertions.assertTrue(loginPage.isOnLoginPage(), "Lỗi: Đã rời khỏi trang Login!");
    }

    
}
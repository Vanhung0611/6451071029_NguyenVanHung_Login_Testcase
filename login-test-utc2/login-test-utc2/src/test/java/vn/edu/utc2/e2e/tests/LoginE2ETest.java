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

    @Test
    @DisplayName("TC2: Để trống user hoặc pass word (chỉ nhập user)")
    @Story("TC2 - Để trống Password")
    void test_TC2_emptyPassword() {
        LoginPage loginPage = new LoginPage(driver).open();
        loginPage.loginAs("huongnt", "");

        Assertions.assertTrue(loginPage.isOnLoginPage(), "Lỗi: Đã rời khỏi trang Login!");
    }

    @Test
    @DisplayName("TC3: Đúng tên sai mật khẩu")
    @Story("TC3 - Sai mật khẩu")
    void test_TC3_wrongPassword() {
        LoginPage loginPage = new LoginPage(driver).open();
        loginPage.loginAs("huongnt", "utc@235");

        Assertions.assertTrue(loginPage.isOnLoginPage(), "Lỗi: Đã rời khỏi trang Login!");
    }

    @Test
    @DisplayName("TC4: Sai tên, đúng mật khẩu")
    @Story("TC4 - Sai Username")
    void test_TC4_wrongUsername() {
        LoginPage loginPage = new LoginPage(driver).open();
        loginPage.loginAs("huongthunguyen", "123456@utc");

        Assertions.assertTrue(loginPage.isOnLoginPage(), "Lỗi: Đã rời khỏi trang Login!");
    }
    
    @Test
    @DisplayName("TC5: Đăng nhập thành công và chọn 'Giữ tôi luôn đăng nhập'")
    @Story("TC5 - Checkbox Giữ tôi luôn đăng nhập")
    void test_TC5_rememberMeCheckbox() {
        LoginPage loginPage = new LoginPage(driver).open();
        loginPage.toggleRememberMe();

        Assertions.assertTrue(loginPage.isRememberMeChecked(), "Lỗi: Checkbox chưa được chọn!");
    }
}
package all.onlinecinematester;

import all.TestBase;
import all.onlinecinematester.pages.ForgotPasswordPage;
import all.onlinecinematester.pages.LoginPage;
import all.onlinecinematester.pages.RegisterPage;
import org.junit.jupiter.api.*;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests extends TestBase {

    private RegisterPage registerPage;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;

    private final String BASE_URL = "https://lm.skillbox.cc/qa_tester/module06/";
    private final String NAME = "Vasya";
    private final String EMAIL = "skillbox@test.ru";
    private final String PASSWORD = "qwerty!123";



    // 1. Регистрация
    @Test
    public void registerUser() {
        driver.get(BASE_URL + "register/");

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Vasya", "skillbox@test.ru", "qwerty!123");

        Assertions.assertTrue(registerPage.isSuccessMessageVisible(), "После регистрации должно отображаться сообщение 'Спасибо за регистрацию!'");
    }

    // 2. Восстановление пароля - успешный сценарий
    @Test
    public void testPasswordRecoverySuccess() {
        driver.get(BASE_URL + "auth/index.html");
        loginPage = new LoginPage(driver);
        loginPage.goToForgotPassword();

        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.resetPassword(EMAIL);

        Assertions.assertTrue(forgotPasswordPage.isSuccessMessageVisible(), "Сообщение об успешной отправке не появилось!");
    }

    // 3. Восстановление пароля - неверный email
    @Test
    public void testPasswordRecoveryInvalidEmail() {
        driver.get(BASE_URL + "auth/index.html");
        loginPage = new LoginPage(driver);
        loginPage.goToForgotPassword();

        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.resetPassword("wrong_email@test.ru");

        Assertions.assertTrue(forgotPasswordPage.isErrorMessageVisible(), "Сообщение об ошибке не появилось!");
    }



    // 4. Восстановление пароля - пустое поле
    @Test
    public void testPasswordRecoveryEmptyField() {
        driver.get(BASE_URL + "auth/index.html");
        loginPage = new LoginPage(driver);
        loginPage.goToForgotPassword();

        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.resetPassword("");

        Assertions.assertTrue(forgotPasswordPage.isErrorMessageVisible(), "Ошибка при пустом поле должна отображаться!");
    }

    // 5. Восстановление пароля - невалидный формат email
    @Test
    public void testPasswordRecoveryInvalidFormat() {
        driver.get(BASE_URL + "auth/index.html");
        loginPage = new LoginPage(driver);
        loginPage.goToForgotPassword();

        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.resetPassword("invalid_email");

        Assertions.assertTrue(forgotPasswordPage.isErrorMessageVisible(), "Ошибка при невалидном email должна отображаться!");
    }
}
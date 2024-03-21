package work.mayflower.tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import work.mayflower.pages.HeaderElement;

public class LoginTests {
    //
//    https://mega.readyscript.ru/
//    Реализовать 3 теста и придумать 1 свой
//1. Зарегистрировать пользователя руками и на основании данных реализовать тест на проверку логина на сайт


    @Test
    public void loginTest() {
        HeaderElement headerElement = new HeaderElement();
        headerElement.loginDropdownButton.shouldBe(Condition.visible).click();
        headerElement.loginDropdownMenu.shouldBe(Condition.visible);
        headerElement.loginButton.shouldBe(Condition.visible).click();
    }
}

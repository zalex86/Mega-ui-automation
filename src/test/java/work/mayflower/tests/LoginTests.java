package work.mayflower.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import work.mayflower.BaseSetup;
import work.mayflower.pages.header.HeaderElement;
import work.mayflower.pages.header.LoginHandle;

@Feature("Authorization")
public class LoginTests extends BaseSetup {

    @Test(description = "Check log in on site process ")
    public void loginTest() {
        HeaderElement headerElement = new HeaderElement();
        headerElement.personalAccountButton.shouldBe(Condition.visible)
                .$(headerElement.buttonLabel).shouldHave(Condition.text("Личный кабинет"))
                .click();

        headerElement.dropdownMenu.shouldBe(Condition.visible)
                .$$(headerElement.dropdownListItem).shouldHave(CollectionCondition.size(2));
        headerElement.personalAccountMenuHeader.shouldNotBe(Condition.visible);
        headerElement.loginButton.shouldBe(Condition.visible)
                .click();

        LoginHandle loginHandle = new LoginHandle();
        loginHandle.loginHandleContent.shouldBe(Condition.visible)
                .$(loginHandle.submitButton).shouldBe(Condition.visible)
                .shouldHave(Condition.text("Войти"));
        loginHandle.emailInputlabel.shouldHave(Condition.text("Логин или E-mail"));
        loginHandle.passwordInputlabel.shouldHave(Condition.text("Пароль"));

        loginHandle.sendEmail(TESTER_EMAIL)
                .sendPassword(TESTER_PASSWORD)
                .clickSubmitButton();

        loginHandle.loginHandleContent.should(Condition.disappear);
        headerElement.personalAccountButton
                .$(headerElement.buttonLabel).shouldHave(Condition.text(TESTER_NAME_AND_SURNAME))
                .click();

        headerElement.dropdownMenu.shouldBe(Condition.visible)
                .$$(headerElement.dropdownListItem).shouldHave(CollectionCondition.size(7));
        headerElement.personalAccountMenuHeader.shouldBe(Condition.visible)
                .$(headerElement.accountName).shouldHave(Condition.text(TESTER_NAME_AND_SURNAME));
    }
}

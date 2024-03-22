package work.mayflower.pages.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginHandle {
    public final SelenideElement loginHandleContent = $(".modal-content");
    public final SelenideElement emailInput = $("#input-auth1");
    public final SelenideElement passwordInput = $("#input-auth2");
    public final SelenideElement emailInputlabel = $("label[for='input-auth1']");
    public final SelenideElement passwordInputlabel = $("label[for='input-auth2']");
    public final By submitButton = By.cssSelector("[type=\"submit\"]");


    public LoginHandle sendEmail(String testerEmail) {
        emailInput.shouldBe(Condition.visible).clear();
        emailInput.sendKeys(testerEmail);
        return this;
    }

    public LoginHandle sendPassword(String testerPassword) {
        passwordInput.shouldBe(Condition.visible).clear();
        passwordInput.sendKeys(testerPassword);
        return this;
    }

    public void clickSubmitButton() {
        loginHandleContent.$(submitButton).click();
    }
}
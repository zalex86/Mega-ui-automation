package work.mayflower.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

// page_url = https://mega.readyscript.ru/checkout/
public class CookiesHandle {
    public final SelenideElement cookiesContent = $(".cookies-policy__inner");
    public final By acceptCookiesButton = By.cssSelector("button");

    @Step("Accept cookies")
    public void acceptCookies() {
        cookiesContent.shouldBe(Condition.visible).$(acceptCookiesButton).click();
        cookiesContent.shouldNotBe(Condition.visible);
    }
}
package work.mayflower.pages.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import work.mayflower.BaseSetup;

import static com.codeborne.selenide.Selenide.$;

public class HeaderElement {
    public final SelenideElement hamburgerButton = $(".rs-catalog-show");
    public final SelenideElement personalAccountButton = $("a[data-bs-toggle='dropdown']");
    public final By buttonLabel = By.cssSelector("span");
    public final SelenideElement dropdownMenu = $(".dropdown-menu");
    public final By dropdownListItem = By.cssSelector("li");
    public final SelenideElement loginButton = $("a[href^=\"/auth\"]");
    public final SelenideElement personalAccountMenuHeader = $(".lk-dropdown__head");
    public final By accountName = By.cssSelector(".mb-3");
    public final SelenideElement cartButton = $("#rs-cart");

    public HamburgerElement clickHamburger() {
        hamburgerButton.shouldBe(Condition.visible).click();
        return new HamburgerElement();
    }

    public HeaderElement clickPersonalAccountButton() {
        personalAccountButton.click();
        return this;
    }

    public void authorizeOnSite() {
        clickPersonalAccountButton()
                .loginButton.click();
        LoginHandle loginHandle = new LoginHandle();
        loginHandle.emailInput.clear();
        loginHandle.emailInput.sendKeys(BaseSetup.TESTER_EMAIL);
        loginHandle.passwordInput.clear();
        loginHandle.passwordInput.sendKeys(BaseSetup.TESTER_PASSWORD);
    }
}
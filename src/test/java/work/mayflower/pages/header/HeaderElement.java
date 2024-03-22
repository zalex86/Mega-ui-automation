package work.mayflower.pages.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

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

    public HamburgerElement clickHamburger() {
        hamburgerButton.shouldBe(Condition.visible).click();
        return new HamburgerElement();
    }

    public HeaderElement clickPersonalAccountButton() {
        personalAccountButton.click();
        return this;
    }
}
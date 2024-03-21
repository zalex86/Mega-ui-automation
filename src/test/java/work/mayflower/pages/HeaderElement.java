package work.mayflower.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderElement {
    public final SelenideElement hamburgerButton = $(".rs-catalog-show");
    public final SelenideElement loginDropdownButton = $("a[data-bs-toggle='dropdown']");

    public final SelenideElement loginDropdownMenu = $(".dropdown-menu");

    public final SelenideElement loginButton = $("a[href^=\"/auth\"]");


    public HamburgerElement hamburgerElementClick() {
        hamburgerButton.shouldBe(Condition.visible).click();
        return new HamburgerElement();
    }

    public HeaderElement loginDropdownButtonClick() {
        loginDropdownButton.click();
        return this;
    }
}
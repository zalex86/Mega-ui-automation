package work.mayflower.pages.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import work.mayflower.pages.OrdersListPage;

import static com.codeborne.selenide.Selenide.$;
import static work.mayflower.BaseSetup.TESTER_EMAIL;
import static work.mayflower.BaseSetup.TESTER_PASSWORD;

public class HeaderElement {
    public final SelenideElement hamburgerButton = $(".rs-catalog-show");
    public final SelenideElement personalAccountButton = $("a[data-bs-toggle='dropdown']");
    public final By buttonLabel = By.cssSelector("span");
    public final SelenideElement dropdownMenu = $(".dropdown-menu");
    public final By dropdownListItem = By.cssSelector("li");
    public final SelenideElement loginButton = $("a[href^='/auth']");
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

    public HeaderElement authorizeOnSite() {
        clickPersonalAccountButton()
                .loginButton.click();
        new LoginHandle().sendEmail(TESTER_EMAIL)
                .sendPassword(TESTER_PASSWORD)
                .clickSubmitButton();
        return this;
    }

    public OrdersListPage passToOrdersListPage() {
        clickPersonalAccountButton().dropdownMenu.$$(dropdownListItem).get(2).click();
        return new OrdersListPage();
    }
}
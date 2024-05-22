package work.mayflower.pages.productList;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import work.mayflower.pages.CheckoutPage;

import static com.codeborne.selenide.Selenide.$;

public class CartHandle {
    public final SelenideElement cartHandleContent = $("#rs-cart-page");
    public final By itemName = By.cssSelector("a[class='modal-cart-item__title']");
    public final SelenideElement itemPrice = $("span[class='modal-cart-item__price']");
    public final SelenideElement itemsAmount = $(".rs-amount");
    public final SelenideElement cartButton = $("#rs-cart-page .btn-primary");

    @Step("Go to a checkout page")
    public CheckoutPage cartButtonClick() {
        cartButton.shouldBe(Condition.visible)
                .click();
        return new CheckoutPage();
    }
}
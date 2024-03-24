package work.mayflower.pages.plp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartHandle {
    public final SelenideElement cartHandleContent = $("#rs-cart-page");
    public final By itemName = By.cssSelector("a[class='modal-cart-item__title']");
    public final SelenideElement itemPrice = $("span[class='modal-cart-item__price']");
    public final SelenideElement itemsAmount = $(".rs-amount");
    public final SelenideElement cartButton = $("#rs-cart-page .btn-primary");

    public void cartButtonClick() {
        cartButton.shouldBe(Condition.visible)
                .click();
    }
}
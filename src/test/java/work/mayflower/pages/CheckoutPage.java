package work.mayflower.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import work.mayflower.BaseSetup;
import work.mayflower.helpers.PageObjectUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CheckoutPage {
    String page_url = BaseSetup.SERVER + "checkout/";

    public final SelenideElement clearCartButton = $(".rs-clean");
    public final ElementsCollection itemsInCartList = $$(".rs-cart-item");
    public final By itemName = By.cssSelector(".cart-checkout-item__title");
    public final By itemPrice = By.cssSelector("span[class='fw-bold']");
    public final By itemAmount = By.cssSelector("input[class='rs-amount']");
    public final SelenideElement cartTitle = $("h2"); //должно быть либо Корзина: либо Корзина пуста
    public final SelenideElement backButton = $(".rs-back-button");

    public CheckoutPage() {
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }
}
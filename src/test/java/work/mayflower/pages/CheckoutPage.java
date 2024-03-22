package work.mayflower.pages;

import com.codeborne.selenide.SelenideElement;
import work.mayflower.BaseSetup;
import work.mayflower.helpers.PageObjectUtils;

import static com.codeborne.selenide.Selenide.$;


public class CheckoutPage {
    String page_url = BaseSetup.SERVER + "checkout/";

    public final SelenideElement formCart = $("#rs-cart-form");
    public final SelenideElement linkClearClean = $(".rs-clean");
    public final SelenideElement divCartItem = $(".rs-cart-item");
    public final SelenideElement linkDigma = $(".cart-checkout-item__title");
    public final SelenideElement spanBold = $("span[class='fw-bold']");
    public final SelenideElement divCartAmount = $(".cart-amount__input");
    public final SelenideElement cartTitle = $("h2"); //должно быть либо Корзина: либо Корзина пуста

    public CheckoutPage() {
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }
}
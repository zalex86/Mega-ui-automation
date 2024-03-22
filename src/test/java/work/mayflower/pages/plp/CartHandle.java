package work.mayflower.pages.plp;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartHandle {
    public final SelenideElement cartHandleContent = $("#rs-cart-page");

    public final SelenideElement linkDigma = $("a[class='modal-cart-item__title']");

    public final SelenideElement spanCartItem = $("span[class='modal-cart-item__price']");

    public final SelenideElement inputProductsAmount = $(".rs-amount");

    public final SelenideElement linkPrimary = $("#rs-cart-page .btn-primary");

    
}
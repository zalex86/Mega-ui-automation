package work.mayflower.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// page_url = https://mega.readyscript.ru/checkout/finish/
public class CheckoutFinishPage {
    public final SelenideElement buttonCollapse = $("button[data-bs-target='#accordionContentCheckout-2']");

    public final SelenideElement divAccordionContentCheckout = $("#accordionContentCheckout-2");

    public final SelenideElement divDigma = $("div[class='mb-2']");

    public final SelenideElement finishOrder = $(".btn-primary");


}
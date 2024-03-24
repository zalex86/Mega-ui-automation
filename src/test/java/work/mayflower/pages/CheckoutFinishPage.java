package work.mayflower.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutFinishPage {
    private final String page_url = "https://mega.readyscript.ru/checkout/finish/";

    public final SelenideElement orderItemsDropdownButton = $("button[data-bs-target='#accordionContentCheckout-2']");
    public final ElementsCollection orderItemsList = $$("#accordionContentCheckout-2");
    public final By orderItemTitle = By.cssSelector("div[class='mb-2']");
    public final SelenideElement finishOrder = $(".btn-primary");
    public final SelenideElement totalSum = $(".fs-2");


}
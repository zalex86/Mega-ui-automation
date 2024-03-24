package work.mayflower.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import work.mayflower.BaseSetup;
import work.mayflower.helpers.PageObjectUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutFinishPage {

    public final SelenideElement orderItemsDropdownButton = $("button[data-bs-target='#accordionContentCheckout-2']");
    public final ElementsCollection orderItemsList = $$("#accordionContentCheckout-2");
    public final By orderItemTitle = By.cssSelector("div[class='mb-2']");
    public final SelenideElement finishOrder = $(".btn-primary");
    public final SelenideElement totalSum = $(".fs-2");

    public CheckoutFinishPage() {
        String page_url = BaseSetup.SERVER + "checkout/finish/";
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }
}
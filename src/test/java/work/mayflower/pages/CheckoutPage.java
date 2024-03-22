package work.mayflower.pages;

import com.codeborne.selenide.Condition;
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

    public final SelenideElement submitCheckoutFooter = $(".checkout-total-fixed_act");
    public final By submitCheckoutButton = By.cssSelector("button");

    public final SelenideElement onlineDelivery = $("label[for='dlv_5'] .checkout-radio__title");

    public final SelenideElement payByCard = $("label[for='pay_1'] .checkout-radio__title");

    public final SelenideElement addressInput = $("input[name='addr_address']");
    public final SelenideElement previousAddress = $(".rs-checkout_addressItem .radio-attr");

    public final SelenideElement inputUserFio = $("input[name='user_fio']");

    public final SelenideElement inputUserEmail = $("input[name='user_email']");


    public CheckoutPage() {
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }


    public CheckoutPage chooseDeliveryAddressUserAndPayment() {
        onlineDelivery.shouldBe(Condition.visible).click();
        previousAddress.shouldBe(Condition.visible).click();
        //addressInput.shouldBe(Condition.visible).sendKeys("Мира,2");
//        inputUserFio.shouldBe(Condition.visible).sendKeys(BaseSetup.TESTER_NAME_AND_SURNAME);
//        inputUserEmail.shouldBe(Condition.visible).sendKeys(BaseSetup.TESTER_EMAIL);
        payByCard.shouldBe(Condition.visible).click();
        return this;
    }

    public void clickSubmitCheckoutButton() {
        submitCheckoutFooter.$(submitCheckoutButton).click();
    }
}
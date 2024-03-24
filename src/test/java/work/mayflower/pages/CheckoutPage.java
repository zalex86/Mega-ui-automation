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
    //надо понять как скролить сюда
    public final SelenideElement payByCard = $("label[for='pay_1'] .checkout-radio__title");

    public final SelenideElement addressInput = $("input[name='addr_address']");
    public final SelenideElement previousAddress = $(".rs-checkout_addressItem .radio-attr");
    public final SelenideElement inputUserFio = $("input[name='user_fio']");
    public final SelenideElement inputUserEmail = $("input[name='user_email']");
    public final SelenideElement totalSum = $(".checkout-total-fixed__sum");

    public final SelenideElement deliveryBlock = $(".rs-checkout_deliveryBlock");
    public final By validationError = By.cssSelector(".invalid-feedback");

    public final SelenideElement addressBlock = $(".rs-checkout_addressBlock");
    public final SelenideElement paymentBlock = $(".rs-checkout_paymentBlock");


    public CheckoutPage() {
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }


    public CheckoutPage chooseDeliveryAddressUserAndPayment() {


        previousAddress.scrollIntoView(true).shouldBe(Condition.visible);

        previousAddress.click();
        //addressInput.shouldBe(Condition.visible).sendKeys("Мира,2");
//        inputUserFio.shouldBe(Condition.visible).sendKeys(BaseSetup.TESTER_NAME_AND_SURNAME);
//        inputUserEmail.shouldBe(Condition.visible).sendKeys(BaseSetup.TESTER_EMAIL);
        payByCard.scrollIntoView(true).shouldBe(Condition.visible);

        payByCard.click();

        return this;
    }

    public CheckoutFinishPage clickSubmitCheckoutButton() {
        submitCheckoutFooter.$(submitCheckoutButton).click();
        return new CheckoutFinishPage();
    }

    public CheckoutPage submitWithoutNesescaryFields() {
        submitCheckoutFooter.$(submitCheckoutButton).click();
        return this;
    }

    public SelenideElement getDeliveryValidationError() {
        return deliveryBlock.$(validationError);
    }

    public SelenideElement getAddressValidationError() {
        return addressBlock.$(validationError);
    }

    public SelenideElement getPaymentValidationError() {
        return paymentBlock.$(validationError);
    }

    public CheckoutPage toggleOnlineDelivery() {
        onlineDelivery.shouldBe(Condition.visible).click();
        return this;
    }

    public CheckoutPage chooseDeliveryAddess() {
        if (previousAddress.is(Condition.not(Condition.visible))) {
            addressInput.shouldBe(Condition.visible).sendKeys("Мира,4");
        } else {
            previousAddress.click();
        }
        return this;
    }

    public CheckoutPage toggleOnPaymentByCard() {
        payByCard.shouldBe(Condition.visible).click();
        return this;
    }
}
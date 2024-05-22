package work.mayflower.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import work.mayflower.BaseSetup;
import work.mayflower.pages.*;
import work.mayflower.pages.header.HeaderElement;
import work.mayflower.pages.productList.ProductListPage;

import static com.codeborne.selenide.Selenide.open;

@Feature("Checkout")
public class CheckoutTests extends BaseSetup {
    @Test(description = "Checkout with one product in cart by a logged in user")
    public void checkoutTest() {
        String productTitle = "Digma";
        new MainPage();
        new CookiesHandle().acceptCookies();
        HeaderElement headerElement = new HeaderElement().authorizeOnSite();
        int orderNumber = headerElement.passToOrdersListPage()
                .getTheLastOrderNumber();

        open(SERVER + "catalog/" + productTitle.toLowerCase() + "/");
        CheckoutPage checkoutPage = new ProductListPage(productTitle).getItemCard(1)
                .addItemToCart()
                .cartButtonClick();

        String checkoutSum = checkoutPage.totalSum.getText();
        checkoutPage.submitWithoutNecessaryFields()
                .getDeliveryValidationError().shouldBe(Condition.visible).shouldHave(Condition.text("Укажите тип доставки"));
        checkoutPage.toggleOnlineDelivery()
                .submitWithoutNecessaryFields()
                .getAddressValidationError().shouldBe(Condition.visible).shouldHave(Condition.text("Адрес - обязательное поле"));
        checkoutPage.chooseDeliveryAddess()
                .submitWithoutNecessaryFields()
                .getPaymentValidationError().shouldBe(Condition.visible).shouldHave(Condition.text("Укажите тип оплаты"));
        CheckoutFinishPage checkoutFinishPage = checkoutPage.toggleOnPaymentByCard()
                .clickSubmitCheckoutButton();

        checkoutFinishPage.orderItemsDropdownButton.shouldBe(Condition.visible).click();
        checkoutFinishPage.orderItemsList.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));
        checkoutFinishPage.totalSum.shouldHave(Condition.text(checkoutSum));
        checkoutFinishPage.finishOrder.shouldBe(Condition.visible).click();

        new MainPage();
        OrderCard newOrderItem = headerElement.passToOrdersListPage()
                .getOrderItem(1);
        newOrderItem.getOrderCard().$(newOrderItem.orderTitle).shouldHave(Condition.text(String.valueOf(orderNumber + 1)));
        newOrderItem.getOrderCard().$(newOrderItem.orderPrice).shouldHave(Condition.text(checkoutSum));
    }
}

package work.mayflower.tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import work.mayflower.BaseSetup;
import work.mayflower.pages.CheckoutPage;
import work.mayflower.pages.CookiesHandle;
import work.mayflower.pages.MainPage;
import work.mayflower.pages.header.HeaderElement;
import work.mayflower.pages.plp.ProductListPage;

import static com.codeborne.selenide.Selenide.open;

public class CheckoutTests extends BaseSetup {
    @Test(description = "Checkout with one product in cart")
    public void checkoutTest() {
        String productTitle = "Digma";
        new MainPage();
        new CookiesHandle().acceptCookies();
        new HeaderElement().clickPersonalAccountButton()
                .authorizeOnSite();

        open(SERVER + "catalog/" + productTitle.toLowerCase() + "/");
        new ProductListPage(productTitle).getItemCard(1)
                .addItemToCart()
                .cartButton.shouldBe(Condition.visible)
                .click();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.chooseDeliveryAddressUserAndPayment()
                .clickSubmitCheckoutButton();

        new MainPage();

    }
}

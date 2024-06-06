package work.mayflower.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import work.mayflower.BaseSetup;
import work.mayflower.pages.CheckoutPage;
import work.mayflower.pages.MainPage;
import work.mayflower.pages.header.HeaderElement;
import work.mayflower.pages.productList.CartHandle;
import work.mayflower.pages.productList.ItemCard;
import work.mayflower.pages.productList.ProductListPage;

import static com.codeborne.selenide.Selenide.open;

@Feature("Cart")
public class CartTests extends BaseSetup {

    @Test(description = "Check adding and removing a product from the cart")
    public void addAndRemoveProductFromCartTest() {
        String productTitle = "Digma";

        open(SERVER + "catalog/" + productTitle.toLowerCase() + "/");

        HeaderElement headerElement = new HeaderElement();
        headerElement.cartButton.click();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.cartTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Корзина пуста"));
        checkoutPage.backButton.click();

        ProductListPage productListPage = new ProductListPage(productTitle);
        productListPage.foundItems.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));

        ItemCard itemCard = productListPage.getItemCard(1);
        itemCard.getItemCard()
                .$(itemCard.addToCartButton).shouldBe(Condition.visible)
                .$(itemCard.buttonLabel).shouldHave(Condition.text("В корзину"));
        String itemName = itemCard.getItemName();
        String itemPrice = itemCard.getItemPrice();
        CartHandle cartHandle = itemCard.addItemToCart();

        itemCard.getItemCard().$(itemCard.addToCartButton)
                .$(itemCard.buttonLabel).shouldHave(Condition.text("Добавлено"));
        cartHandle.cartHandleContent.shouldBe(Condition.visible)
                .$(cartHandle.itemName).shouldBe(Condition.visible)
                .shouldHave(Condition.text(itemName));
        cartHandle.itemsAmount.shouldHave(Condition.value(String.valueOf(1)));
        cartHandle.itemPrice.shouldHave(Condition.text(itemPrice + " р."));
        cartHandle.cartButton.shouldBe(Condition.visible).click();

        checkoutPage.cartTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Корзина:"));
        checkoutPage.itemsInCartList.shouldHave(CollectionCondition.size(1))
                .get(0).$(checkoutPage.itemPrice).shouldHave(Condition.text(itemPrice + " р."));
        checkoutPage.itemsInCartList.get(0).$(checkoutPage.itemName).shouldHave(Condition.text(itemName));
        checkoutPage.itemsInCartList.get(0).$(checkoutPage.itemAmount).shouldHave(Condition.value(String.valueOf(1)));

        checkoutPage.clearCartButton.shouldBe(Condition.visible).click();
        new MainPage();
        headerElement.cartButton.click();
        checkoutPage.cartTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Корзина пуста"));
    }
}

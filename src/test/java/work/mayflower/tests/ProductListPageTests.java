package work.mayflower.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import work.mayflower.BaseSetup;
import work.mayflower.pages.header.HeaderElement;
import work.mayflower.pages.productList.ItemCard;
import work.mayflower.pages.productList.ProductListPage;

@Feature("PLP")
public class ProductListPageTests extends BaseSetup {
    @Test(description = "Check passing to a product list page and a product card view")
    public void openPLPTest() {
        String productTitle = "Digma";
        HeaderElement headerElement = new HeaderElement();
        ProductListPage productListPage = headerElement.clickHamburger()
                .hoverElectronicsItem()
                .hoverPadsItem()
                .clickDigmaLink();

        productListPage.name.shouldBe(Condition.visible).shouldHave(Condition.text(productTitle));
        productListPage.foundItems.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));
        ItemCard itemCard = productListPage.getItemCard(1);
        itemCard.getItemCard().$(itemCard.itemNameWithLink).shouldBe(Condition.visible)
                .shouldHave(Condition.text(productTitle))
                .parent().$(itemCard.addToCartButton).shouldBe(Condition.visible)
                .shouldHave(Condition.text("В корзину"));
    }
}

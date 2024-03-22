package work.mayflower.tests;

import com.codeborne.selenide.CollectionCondition;
import org.testng.annotations.Test;
import work.mayflower.BaseSetup;
import work.mayflower.pages.plp.ProductListPage;

import static com.codeborne.selenide.Selenide.open;

public class CartTests extends BaseSetup {
    //3. Проверка добавления товара в корзину и удаления из корзины (edited)
    @Test(description = "Проверка добавления товара в корзину и удаления из корзины")
    public void openPLPTest() {
        open(SERVER + "catalog/digma/");
        ProductListPage productListPage = new ProductListPage();
        productListPage.foundItems.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));

        productListPage.getItemCard(1)
                .addItemToCart();


    }
}

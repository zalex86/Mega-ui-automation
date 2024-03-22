package work.mayflower.tests;

import com.codeborne.selenide.Condition;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import work.mayflower.BaseSetup;
import work.mayflower.pages.MainPage;
import work.mayflower.pages.header.HeaderElement;
import work.mayflower.pages.plp.ItemCard;
import work.mayflower.pages.plp.ProductListPage;

public class PLPTests extends BaseSetup {
    @Test(description = "Проверить переход и отображение товаров в каталоге")
    public void openPLPTest() {
        new MainPage();
        HeaderElement headerElement = new HeaderElement();
        ProductListPage productListPage = headerElement.clickHamburger()
                .hoverElectronicsItem()
                .hoverPadsItem()
                .clickDigmaLink();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(productListPage.name.shouldBe(Condition.visible)
                .getText()).isEqualTo("Digma");
        softAssertions.assertThat(productListPage.foundItems).size().isEqualTo(1);
        softAssertions.assertAll();
        ItemCard itemCard = productListPage.getItemCard(1);
        itemCard.getItemCard().$(itemCard.itemNameWithLink).shouldBe(Condition.visible)
                .shouldHave(Condition.text("Digma"))
                .parent().$(itemCard.addToCartButton).shouldBe(Condition.visible)
                .shouldHave(Condition.text("В корзину"));
    }
}

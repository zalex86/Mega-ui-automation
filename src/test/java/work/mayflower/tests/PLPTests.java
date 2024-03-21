package work.mayflower.tests;

import com.codeborne.selenide.Condition;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import work.mayflower.pages.HeaderElement;
import work.mayflower.pages.ProductListPage;

public class PLPTests {
    //2. Проверить переход и отображение товаров в каталоге(синяя кнопка сверху) Электроника -> Планшеты -> Digma
    @Test
    public void openPLPTest(){
        HeaderElement headerElement = new HeaderElement();
        ProductListPage productListPage = headerElement.hamburgerElementClick()
                .hoverElectronicsItem()
                .hoverPadsItem()
                .clickDigmaLink();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(productListPage.name.shouldBe(Condition.visible).getText()).isEqualTo("Digma");
        softAssertions.assertThat(productListPage.foundItems).size().isEqualTo(1);
        softAssertions.assertAll();
        productListPage.foundItems.get(0).$(productListPage.addToCartButton).shouldBe(Condition.visible)
                .shouldHave(Condition.text("В корзину"));

    }
}

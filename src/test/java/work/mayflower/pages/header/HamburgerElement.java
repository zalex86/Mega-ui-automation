package work.mayflower.pages.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import work.mayflower.pages.plp.ProductListPage;

import static com.codeborne.selenide.Selenide.$;

public class HamburgerElement {
    public final SelenideElement categoriesElement = $(".head-dropdown-catalog__categories");
    public final SelenideElement electronicsItem = $("a[data-target='dropdown-subcat-2']");
    public final SelenideElement padsItem = $("a[data-target='dropdown-subsubcat-2-2']");
    public final SelenideElement digmaLink = $("a[href='/catalog/digma/']");

    public HamburgerElement() {
        categoriesElement.shouldBe(Condition.visible);
    }

    @Step("Hover Electronics item")
    public HamburgerElement hoverElectronicsItem() {
        electronicsItem.shouldBe(Condition.visible).hover();
        return this;
    }

    @Step("Hover Pads item")
    public HamburgerElement hoverPadsItem() {
        padsItem.shouldBe(Condition.visible).hover();
        return this;
    }

    @Step("Click Digma link in the list")
    public ProductListPage clickDigmaLink() {
        digmaLink.shouldBe(Condition.visible).click();
        return new ProductListPage("Digma");
    }


}
package work.mayflower.pages.plp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

public class ItemCard {

    @Getter
    private final SelenideElement itemCard;
    public final By addToCartButton = By.cssSelector(".rs-to-cart");
    public final By buttonLabel = By.cssSelector("span");
    public final By itemNameWithLink = By.cssSelector(".item-card__title");
    public final By itemPrice = By.cssSelector("span[class='rs-price-new']");


    public ItemCard(SelenideElement itemCard) {
        this.itemCard = itemCard;
    }

    public CartHandle addItemToCart() {
        itemCard.$(addToCartButton).shouldBe(Condition.visible).click();
        return new CartHandle();
    }

    public String getItemName() {
        return itemCard.$(itemNameWithLink).getText();
    }

    public String getItemPrice() {
        return itemCard.$(itemPrice).getText();
    }
}
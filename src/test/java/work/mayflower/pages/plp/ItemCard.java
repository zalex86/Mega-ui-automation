package work.mayflower.pages.plp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

public class ItemCard {

    @Getter
    private final SelenideElement itemCard;
    public final By addToCartButton = By.cssSelector(".rs-to-cart");
    public final By itemTitleWithLink = By.cssSelector(".item-card__title");


    public ItemCard(SelenideElement itemCard) {
        this.itemCard = itemCard;
    }

    public void addItemToCart() {
        itemCard.$(addToCartButton).shouldBe(Condition.visible).click();
    }
}
package work.mayflower.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

public class OrderCard {
    @Getter
    private final SelenideElement orderCard;
    public final By orderTitle = By.cssSelector(".lk-orders-item__title");
    public final By orderPrice = By.cssSelector(".lk-orders-item__price");

    public OrderCard(SelenideElement orderCard) {
        this.orderCard = orderCard;
    }
}
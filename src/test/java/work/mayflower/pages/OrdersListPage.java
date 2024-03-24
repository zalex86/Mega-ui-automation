package work.mayflower.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import work.mayflower.BaseSetup;
import work.mayflower.helpers.PageObjectUtils;

import static com.codeborne.selenide.Selenide.$$x;

public class OrdersListPage {

    public final ElementsCollection ordersItemsList = $$x("//div[@class='lk-orders-item']");

    public OrdersListPage() {
        String page_url = BaseSetup.SERVER + "my/orders/";
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }

    @Step("Get the order by number: {0}")
    public OrderCard getOrderItem(int itemNumber) {
        return new OrderCard(ordersItemsList.get(itemNumber - 1));
    }

    @Step("Get the last order's number")
    public int getTheLastOrderNumber() {
        int orderNumber = 0;

        if (!ordersItemsList.isEmpty()) {
            OrderCard orderCard = getOrderItem(1);
            orderNumber = Integer.parseInt(orderCard.getOrderCard().$(orderCard.orderTitle).getText().split(" ")[2]);
        }
        return orderNumber;
    }
}
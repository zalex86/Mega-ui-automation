package work.mayflower.pages;

import com.codeborne.selenide.ElementsCollection;
import work.mayflower.helpers.PageObjectUtils;

import static com.codeborne.selenide.Selenide.$$x;

public class OrdersListPage {
    String page_url = "https://mega.readyscript.ru/my/orders/";

    public final ElementsCollection ordersItemsList = $$x("//div[@class='lk-orders-item']");


    public OrdersListPage() {
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }

    public OrderCard getOrderItem(int itemNumber) {
        return new OrderCard(ordersItemsList.get(itemNumber-1));
    }

    public int getTheLastOrderNumber() {
        int orderNumber = 0;

        if (!ordersItemsList.isEmpty()) {
            OrderCard orderCard = getOrderItem(1);
            orderNumber = Integer.parseInt(orderCard.getOrderCard().$(orderCard.orderTitle).getText().split(" ")[2]);
        }
        return orderNumber;
    }
}
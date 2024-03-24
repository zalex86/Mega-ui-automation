package work.mayflower.pages.plp;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import work.mayflower.BaseSetup;
import work.mayflower.helpers.PageObjectUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class ProductListPage {
     String page_url = BaseSetup.SERVER + "catalog/";

     public final SelenideElement name = $("h1");
     public final ElementsCollection foundItems  = $$(".item-card");

     public ProductListPage(String productTitle) {
          PageObjectUtils.waitPageIsPresentByURL(page_url + productTitle.toLowerCase() +"/");
     }

     public ItemCard getItemCard(int itemNumber) {
          return new ItemCard(foundItems.get(itemNumber-1));
     }
}
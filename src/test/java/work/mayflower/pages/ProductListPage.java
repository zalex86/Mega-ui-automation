package work.mayflower.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import work.mayflower.helpers.PageObjectUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class ProductListPage {
     String page_url = "https://mega.readyscript.ru/catalog/digma/";

     public final SelenideElement name = $("h1");
     public final ElementsCollection foundItems = $$("div[class$='rs-offers-preview']");
     public final By addToCartButton = By.cssSelector(".rs-to-cart");

     ProductListPage() {
          PageObjectUtils.waitPageIsPresentByURL(page_url);
     }
     
}
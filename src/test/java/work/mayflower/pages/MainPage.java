package work.mayflower.pages;

import com.codeborne.selenide.SelenideElement;
import work.mayflower.helpers.PageObjectUtils;

import static com.codeborne.selenide.Selenide.$;
import static work.mayflower.BaseSetup.SERVER;

public class MainPage {
    String page_url = SERVER;

    public final SelenideElement linkCart = $("#rs-cart");


    MainPage() {
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }



}
package work.mayflower.pages;

import work.mayflower.helpers.PageObjectUtils;

public class MainPage {
    String page_url = "https://mega.readyscript.ru/";


    MainPage() {
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }



}
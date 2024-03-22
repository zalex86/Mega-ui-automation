package work.mayflower.pages;

import work.mayflower.helpers.PageObjectUtils;

import static work.mayflower.BaseSetup.SERVER;

public class MainPage {
    String page_url = SERVER;
    public MainPage() {
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }
}
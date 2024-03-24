package work.mayflower.pages;

import work.mayflower.helpers.PageObjectUtils;

import static work.mayflower.BaseSetup.SERVER;

public class MainPage {

    public MainPage() {
        String page_url = SERVER;
        PageObjectUtils.waitPageIsPresentByURL(page_url);
    }
}
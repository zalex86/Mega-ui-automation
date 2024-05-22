package work.mayflower.helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class PageObjectUtils {

    private PageObjectUtils() {
    }

    @Step("Wait for the page {0} to load")
    public static void waitPageIsPresentByURL(String pageUrl) {
        new WebDriverWait(WebDriverRunner.getWebDriver(), 15)
                .until(ExpectedConditions.urlContains(pageUrl));
    }
}

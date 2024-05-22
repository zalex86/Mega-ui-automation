package work.mayflower.helpers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static work.mayflower.BaseSetup.LOGGER;

public final class DriverFactory {

    public static void setUpDriver() {
        Configuration.browser = System.getProperty("gridBrowserName");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/configuration/chromedriver-win64/chromedriver.exe");
        Configuration.startMaximized = true;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (Configuration.browser) {
            case "chrome":
                capabilities = getChromeCapabilities();
                break;
            case "firefox":
                capabilities = getFireFoxCapabilities();
                break;
            default:
                LOGGER.log(Level.WARNING, "Browser " + Configuration.browser + " is not supported");
                break;
        }

        Configuration.browserCapabilities = capabilities;
    }

    private static DesiredCapabilities getChromeCapabilities() {
        Map<String, Object> prefsMap = new HashMap<>();
        prefsMap.put("profile.default_content_settings.popups", 0);
        prefsMap.put("intl.accept_languages", "en, en_US");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefsMap);
        options.addArguments("--test-type");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-password-manager");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return capabilities;
    }

    private static DesiredCapabilities getFireFoxCapabilities() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.useDownloadDir", true);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/pdf,application/vnd.ms-excel,application/zip");
        profile.setPreference("pdfjs.disabled", true);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        options.addArguments("--test-type");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-password-manager");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        return capabilities;
    }
}

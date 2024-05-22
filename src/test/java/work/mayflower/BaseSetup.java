package work.mayflower;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import work.mayflower.helpers.DriverFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;

public class BaseSetup {
    public static String SERVER;
    public static Logger LOGGER = Logger.getLogger("");
    public static String TESTER_EMAIL;
    public static String TESTER_PASSWORD;
    public static String TESTER_NAME_AND_SURNAME;

    @BeforeSuite
    public void setupServer() throws IOException {
        serverSetup();
        testerSetup();
    }

    @BeforeMethod
    public final void setUpDriver() {
        DriverFactory.setUpDriver();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .savePageSource(false)
                .includeSelenideSteps(false));
        open(SERVER);
    }

    @AfterMethod
    public final void closeWebDriver() {
        Selenide.closeWebDriver();
    }

    private void serverSetup() {
        SERVER = System.getProperty("server");
    }

    private void testerSetup() throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(Files.newInputStream(Path.of("src/test/resources/configuration/authorization.xml")));
        TESTER_EMAIL = properties.getProperty("testerEmail");
        TESTER_PASSWORD = properties.getProperty("password");
        TESTER_NAME_AND_SURNAME = properties.getProperty("nameAndSurname");
    }
}

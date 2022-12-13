package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import guru.qa.pages.RegistrationFormPage;
import guru.qa.utils.Data;
import guru.qa.utils.UserData;
import guru.qa.utils.UserDataGenerator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.LocalDateTime;

public class TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Data data = new Data();
    UserDataGenerator userDataGenerator = new UserDataGenerator();
    UserData testData = userDataGenerator.generateUserData();

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "770x1024";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterAll
    static void addAttachments() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String attachName = localDateTime.toString();

        Attach.screenshotAs("Screenshot " + attachName);
        Attach.pageSource("Page source " + attachName);
        Attach.addVideo("Video " + attachName);
        Attach.browserConsoleLogs();
    }
}

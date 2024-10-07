package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void beforeAll()
    {
        Configuration.pageLoadStrategy = "eager"; // команда для того, чтобы селенид не ждал загрузки всех картинок и тяжелых элементов. Только html.
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }
}

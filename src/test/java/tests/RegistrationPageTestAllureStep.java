package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationPageTestAllureStep {
        @BeforeAll
        public static void beforeAll()
        {
                Configuration.pageLoadStrategy = "eager";
                Configuration.browserSize = "1920x1080";
                Configuration.baseUrl = "https://demoqa.com";
                Configuration.holdBrowserOpen = true;
                SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        }
        @AfterEach
        public void addAttachments() {
                Attach.screenshotAs("Last screenshot");
        }

        @Test
        @Tag("RegForm")
        public void fillFormTest() {

        step ("Открытие формы", ()-> {
                open("/automation-practice-form");
                executeJavaScript("$('#fixedban').remove()");
                executeJavaScript("$('footer').remove()");
        });
        step("Заполнение формы", ()-> {$("#firstName").setValue("Alex");
                $("#lastName").setValue("Ivanov");
                $("#userEmail").setValue("simple@test.ru");
                $("#userNumber").setValue("8381238899");
                $("#currentAddress").setValue("Lenina Street 2");
                $("label[for='gender-radio-1']").click(); // сложный вариант. Используется тогда, когда элементы накладываются друг на друга
                $(byId("dateOfBirthInput")).click(); // Кликаем на поле с календарем. Первый вариант.
                $(".react-datepicker__month-container").shouldBe(Condition.visible);
                $(".react-datepicker__month-select").selectOption("April");
                $(".react-datepicker__year-select").selectOption("1991");
                $(byText("14")).click();
                $("#subjectsInput").setValue("English").pressEnter();
                $("label[for='hobbies-checkbox-1']").click(); // сложный вариант. Используется тогда, когда элементы накладываются друг на друга
                $("#uploadPicture").uploadFromClasspath("Блейд.jpg"); // Самый классный вариант. Здесь также обращаемся к id="uploadPicture".
                $("#uploadPicture").uploadFile(new File("Блейд.jpg")); // Вариант посложнее. Здесь также обращаемся к id="uploadPicture".
                $("#state").click();
                $("#stateCity-wrapper").$(byText("Haryana")).click();
                $("#city").click();
                $("#stateCity-wrapper").$(byText("Karnal")).click();
                $("#state").scrollIntoView(true).shouldBe(visible).click();
                $("#state input").setValue("Haryana").pressEnter();
                $("#city").scrollIntoView(true).shouldBe(visible).click();
                $("#city input").setValue("Karnal").pressEnter();
                $("#submit").click();

        });
        step("Проверка заполнения формы", ()-> {
                $(".table-responsive").shouldHave(text("Alex Ivanov"));
                $(".table-responsive").shouldHave(text("simple@test.ru"));
                $(".table-responsive").shouldHave(text("Male"));
                $(".table-responsive").shouldHave(text("8381238899"));
                $(".table-responsive").shouldHave(text("14 April,1991"));
                $(".table-responsive").shouldHave(text("English"));
                $(".table-responsive").shouldHave(text("Sports"));
                $(".table-responsive").shouldHave(text("Блейд.jpg"));
                $(".table-responsive").shouldHave(text("Lenina Street 2"));
                $(".table-responsive").shouldHave(text("Haryana Karnal"));
        });
        }
}
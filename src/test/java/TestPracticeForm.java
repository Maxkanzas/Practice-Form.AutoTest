import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestPracticeForm {
        @BeforeAll
        public static void beforeAll()
        {
                Configuration.pageLoadStrategy = "eager"; // команда для того, чтобы селенид не ждал загрузки всех картинок и тяжелых элементов. Только html.
                Configuration.holdBrowserOpen = true;
                Configuration.browserSize = "1920x1080";
                Configuration.baseUrl = "https://demoqa.com";
        }
        @Test
        void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("simple@test.ru");
        $("#userNumber").setValue("78381238899");
        $("#currentAddress").setValue("Lenina Street 2");
        $("label[for='gender-radio-1']").click();
        $(byId("dateOfBirthInput")).click();
        $(".react-datepicker__month-container").shouldBe(Condition.visible);
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1991");
        $(byText("14")).click();
        $("label[for='gender-radio-1']").click();
        $("#subjectsInput").shouldBe(visible).setValue("English").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Блейд.jpg/")); // Здесь также обращаемся к id="uploadPicture".
        $("#state").scrollIntoView(true).shouldBe(visible).click();
        $("#state input").setValue("Haryana").pressEnter();
        $("#city").scrollIntoView(true).shouldBe(visible).click();
        $("#city input").setValue("Karnal").pressEnter();
        $("#submit").click();
        }
}
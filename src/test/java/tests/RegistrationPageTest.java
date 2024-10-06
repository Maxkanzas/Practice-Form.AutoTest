package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageTest {

        @Test
        void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("simple@test.ru");
        $("#userNumber").setValue("8381238899");
        $("#currentAddress").setValue("Lenina Street 2");

        //Радио-баттон (выбор гендера)
        $("#gender-radio-3").parent().click(); // хороший вариант. Здесь мы обращаемся к родительскому элементу div.
        $(byText("Male")).click(); // Здесь по тексту мы ищем первый элемент в html. Валидный вариант, если сайт проверяем на одном языке. Если сайт проверяем на нескольких языках, то не очень хороший вариант.
        $("label[for='gender-radio-1']").click(); // сложный вариант. Используется тогда, когда элементы накладываются друг на друга
        $("genterWrapper").$(byText("Male")).click(); // самый лучший вариант локатора

        //Календарь
        $(byId("dateOfBirthInput")).click(); // Кликаем на поле с календарем. Первый вариант.
        $("dateOfBirthInput").click(); // Кликаем на поле с календарем. Другой вариант.
        $(".react-datepicker__month-container").shouldBe(Condition.visible);
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1991");
        $(byText("14")).click();

        // Автозаполняемое поле
        $("#subjectsInput").setValue("English").pressEnter();

        //Чек-бокс (выбор хобби)
        $("hobbiesWrapper").$(byText("Music")).click(); // самый лучший вариант локатора
        $("label[for='hobbies-checkbox-1']").click(); // сложный вариант. Используется тогда, когда элементы накладываются друг на друга

        //Выбор файла (загрузка картинки)
        $("#uploadPicture").uploadFromClasspath("Блейд.jpg"); // Самый классный вариант. Здесь также обращаемся к id="uploadPicture".
        $("#uploadPicture").uploadFile(new File("Блейд.jpg")); // Вариант посложнее. Здесь также обращаемся к id="uploadPicture".

        //Выбор из выпадающего меню
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        //Выбор из выпадающего меню
        $("#state").scrollIntoView(true).shouldBe(visible).click();
        $("#state input").setValue("Haryana").pressEnter();
        $("#city").scrollIntoView(true).shouldBe(visible).click();
        $("#city input").setValue("Karnal").pressEnter();
        $("#submit").click();

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
        }
}
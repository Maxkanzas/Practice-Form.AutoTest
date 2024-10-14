package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageObject {

    public SelenideElement

    firstNameInput = $("#firstName"),

    lastNameInput = $("#lastName"),

    userMailInput = $("#userEmail"),

    userNumberInput = $("#userNumber"),

    currentNumberInput = $("#currentAddress"),

    genterWrapper = $("#genterWrapper"),

    calendarInput = $("#dateOfBirthInput"),

    subjectInput = $("#subjectsInput"),

    hobbieInput = $("#hobbiesWrapper"),

    uploadpicture = $("#uploadPicture"),

    stateInput = $("#state"),

    cityInput = $("#city"),

    CityWrapper = $("#stateCity-wrapper"),

    submitInput = $("#submit"),

    responseTable = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPageObject openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPageObject setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPageObject setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPageObject setUserMail(String value) {
        userMailInput.setValue(value);
        return this;
    }

    public RegistrationPageObject setNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPageObject setCurrentNumberInput(String value) {
        currentNumberInput.setValue(value);
        return this;
    }

    public RegistrationPageObject setGenter(String value) {
        genterWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPageObject setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPageObject setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPageObject setHobbie(String value) {
        hobbieInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPageObject uploadPicture(String value) {
        uploadpicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPageObject setState(String value) {
        stateInput.hover().click();
        CityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPageObject setCity(String value) {
        cityInput.click();
        CityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPageObject clickSubmit() {
        submitInput.click();
        return this;
    }
    public RegistrationPageObject checkResults (String key, String value) {
        responseTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    public RegistrationPageObject negativeResults() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
}


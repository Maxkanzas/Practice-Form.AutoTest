package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageObject extends TestBase {

    public SelenideElement

    firstNameInput = $("#firstName"),

    lastNameInput = $("#lastName"),

    userMailInput = $("#userEmail"),

    userNumberInput = $("#userNumber"),

    currentNumberInput = $("#currentAddress"),

    genterWrapper = $("genterWrapper"),

    calendarInput = $("dateOfBirthInput"),

    subjectInput = $("#subjectsInput"),

    hobbieInput = $("hobbiesWrapper"),

    uploadpicture = $("#uploadPicture"),

    stateInput = $("#state"),

    cityInput = $("#city"),

    stateCityWrapper = $("#stateCity-wrapper"),

    submitInput = $("#submit"),

    responseTable = $(".table-responsive"),

    userFormInput = $("form#userForm");

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
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPageObject setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public void clickSubmit() {
        submitInput.click();
    }
    public RegistrationPageObject checkResults (String key, String value) {
        responseTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    public RegistrationPageObject negativeResults() {
        userFormInput.shouldHave(attribute("class", "was-validated"));
        return this;
    }
}


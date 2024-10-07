package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPageObject;

import static com.codeborne.selenide.Selenide.$;

public class FinalRegistrationPageTest {

        RegistrationPageObject registrationPage = new RegistrationPageObject();


        @Test
        void fillFormTest() {

                registrationPage
                        .openPage()
                        .setFirstName("Alex")
                        .setLastName("Ivanov")
                        .setUserMail("inch@mail.ru")
                        .setNumberInput("8972123456")
                        .setCurrentNumberInput("Lenina Street 2")
                        .setGenter("Male")
                        .setDateOfBirth("30", "April", "1991")
                        .setSubjects("English")
                        .setHobbie("Music")
                        .uploadPicture("Блейд.jpg")
                        .setCity("Haryana")
                        .setState("Karnal")
                        .clickSubmit();

                registrationPage
                        .checkResults("Student Name", "Alex Ivanov")
                        .checkResults("Student Email", "simple@test.ru")
                        .checkResults("Gender", "Male")
                        .checkResults("Mobile", "8381238899")
                        .checkResults("Date of Birth", "14 April,1991")
                        .checkResults("Subjects", "English")
                        .checkResults("Hobbies", "Sports")
                        .checkResults("Picture", "Блейд.jpg")
                        .checkResults("Address", "Lenina Street 2")
                        .checkResults("State and City", "Haryana Karnal");
        }

        @Test
        void fillRequiredFormTests() {
                registrationPage
                        .openPage()
                        .setFirstName("Alex")
                        .setLastName("Ivanov")
                        .setGenter("Male")
                        .setNumberInput("8972123456")
                        .clickSubmit();
                registrationPage
                        .checkResults("Student Name","Alex Ivanov")
                        .checkResults("Gender", "Male")
                        .checkResults("Mobile", "8972123456");
        }
        @Test
        void negativeFormTests() {
                registrationPage
                        .openPage()
                        .setFirstName("Alex")
                        .setLastName("Ivanov")
                        .setGenter("Male")
                        .clickSubmit()
                        .negativeResults();
        }
}
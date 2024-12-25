package tests;

import Utils.RandomData;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPageObject;

import static com.codeborne.selenide.Selenide.$;

public class FinalRegistrationPageTest extends TestBase {

        RegistrationPageObject registrationPage = new RegistrationPageObject();
        RandomData randomData = new RandomData();

        String
                firstName = randomData.getfirstName(),
                firstName1 = randomData.getfirstName(),
                lastName = randomData.lastName,
                lastName1 = randomData.lastName,
                userEmail = randomData.userEmail,
                phoneNumber = randomData.phoneNumber,
                address = randomData.address,
                gender = randomData.gender,
                dayOfBirth = randomData.dayOfBirth,
                monthOfBirth = randomData.monthOfBirth,
                yearOfBirth = randomData.yearOfBirth,
                subjects = randomData.subjects,
                hobbies = randomData.hobbies,
                pictureName = randomData.pictureName,
                state = randomData.state,
                city = randomData.city;




        @Test
        void fillFormTest() {

                registrationPage
                        .openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserMail(userEmail)
                        .setNumberInput(phoneNumber)
                        .setCurrentNumberInput(address)
                        .setGenter(gender)
                        .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                        .setSubjects(subjects)
                        .setHobbie(hobbies)
                        .uploadPicture(pictureName)
                        .setState(state)
                        .setCity(city)
                        .clickSubmit();

                registrationPage
                        .checkResults("Student Name", firstName + " " + lastName)
                        .checkResults("Student Email", userEmail)
                        .checkResults("Gender", gender)
                        .checkResults("Mobile", phoneNumber)
                        .checkResults("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                        .checkResults("Subjects", subjects)
                        .checkResults("Hobbies", hobbies)
                        .checkResults("Picture", pictureName)
                        .checkResults("Address", address)
                        .checkResults("State and City", state + " " + city);
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
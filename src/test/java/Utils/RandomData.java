package Utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

public class RandomData {
    Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String phoneNumber = faker.number().digits(10);
    public String address = faker.address().streetAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String dayOfBirth = Integer.toString(faker.number().numberBetween(1, 27));
    public String yearOfBirth = Integer.toString(faker.number().numberBetween(1990, 2023));
    public String monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String subjects = faker.options().option("History", "Arts", "Maths", "Social Studies");
    public String pictureName = "Блейд.jpg";
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String state = faker.options().option("NCR", "Haryana", "Uttar Pradesh", "Rajasthan");
    public String city = getCity();

    public String getCity(){
        return switch (state){
            case "NCR"->faker.options().option("Delhi", "Gurgaon","Noida");
            case "Uttar Pradesh"->faker.options().option("Agra", "Lucknow","Merrut");
            case "Haryana"->faker.options().option("Karnal", "Panipat");
            case "Rajasthan"->faker.options().option("Jaipur", "Jaiselmer");
            default -> "";
        };
    }
}
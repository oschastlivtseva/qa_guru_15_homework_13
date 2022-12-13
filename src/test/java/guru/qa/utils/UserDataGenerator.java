package guru.qa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class UserDataGenerator {

    UserData userData = new UserData();
    Faker faker = new Faker();
    Random random = new Random();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("en"));

    String generateFirstName() {
        return faker.name().firstName();
    }

    String generateLastName() {
        return faker.name().lastName();
    }

    String generateEmail() {
        return faker.internet().emailAddress();
    }

    String chooseGender() {
        List<String> genderOptions = Arrays.asList("Male", "Female", "Other");

        return genderOptions.get(random.nextInt(genderOptions.size()));
    }

    String generatePhoneNumber() {
        int randomNum = faker.number().numberBetween(100000, 999999);

        return "7888" + randomNum;
    }

    BirthDate generateRandomBirthdayDate() {
        Date randomDate = faker.date().birthday();
        String formattedDate = dateFormat.format(randomDate);
        String[] dateArray = formattedDate.split(" ");
        String day = dateArray[0];
        String month = dateArray[1];
        String year = dateArray[2];

        return new BirthDate(day, month, year);
    }

    String generateAddress() {
        return faker.address().fullAddress();
    }

    public UserData generateUserData() {
        userData.firstName = generateFirstName();
        userData.lastName = generateLastName();
        userData.email = generateEmail();
        userData.gender = chooseGender();
        userData.phoneNumber = generatePhoneNumber();
        userData.birthDate = generateRandomBirthdayDate();
        userData.address = generateAddress();

        return userData;
    }
}

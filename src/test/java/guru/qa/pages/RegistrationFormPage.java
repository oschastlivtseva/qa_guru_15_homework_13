package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.GeneralElementsComponent;
import guru.qa.pages.components.ResultsModalComponent;
import guru.qa.pages.components.UploadComponent;
import guru.qa.utils.BirthDate;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormPage {

    private GeneralElementsComponent generalElementsComponent = new GeneralElementsComponent();
    private CalendarComponent calendarComponent = new CalendarComponent();
    private UploadComponent uploadComponent = new UploadComponent();
    private ResultsModalComponent resultsModalComponent = new ResultsModalComponent();

    private SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        emailInput = $("#userEmail"),
        genderSelection = $("#genterWrapper"),
        phoneNumberInput = $("#userNumber"),
        dateOfBirthInput = $("#dateOfBirthInput"),
        subjectsInput = $("#subjectsInput"),
        addressInput = $("#currentAddress"),
        stateSelection = $("#state"),
        citySelection = $("#city");

    public RegistrationFormPage openPage() {
        step("Open page with registration form", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').hide()");
        });

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        step("Set first name: " + firstName, () -> {
            generalElementsComponent.inputInField(firstNameInput, firstName);
        });

        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        step("Set last name: " + lastName, () -> {
            generalElementsComponent.inputInField(lastNameInput, lastName);
        });

        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        step("Set email: " + email, () -> {
        generalElementsComponent.inputInField(emailInput, email);
        });

        return this;
    }

    public RegistrationFormPage selectGender(String genderValue) {
        step("Select gender: " + genderValue, () -> {
        generalElementsComponent.clickRadioButton(genderSelection, genderValue);
        });

        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        step("Set phoneNumber: " + phoneNumber, () -> {
        generalElementsComponent.inputInField(phoneNumberInput, phoneNumber);
        });

        return this;
    }

    public RegistrationFormPage setBirthdayDate(BirthDate birthdayDate) {
        step("Set birthdayDate", () -> {
        dateOfBirthInput.click();
        calendarComponent.setDate(birthdayDate.day, birthdayDate.month, birthdayDate.year);
        });

        return this;
    }

    public RegistrationFormPage selectSubject(String subjectValue) {
        step("Select subject: " + subjectValue, () -> {
        generalElementsComponent.inputInAutoCompleteField(subjectsInput, subjectValue);
        });

        return this;
    }

    public RegistrationFormPage selectHobby (String hobbyValue) {
        step("Select hobby: " + hobbyValue, () -> {
        generalElementsComponent.clickCheckBox(hobbyValue);
        });

        return this;
    }

    public RegistrationFormPage uploadPicture (String pictureName) {
        step("Upload picture with name: " + pictureName, () -> {
        uploadComponent.uploadPicture(pictureName);
        });

        return this;
    }

    public RegistrationFormPage setAddress (String address) {
        step("Set address: " + address, () -> {
        generalElementsComponent.inputInField(addressInput, address);
        });

        return this;
    }

    public RegistrationFormPage selectState(String state) {
        step("Select state: " + state, () -> {
        stateSelection.scrollTo();
        generalElementsComponent.selectDropdownValue(stateSelection, state);
        });

        return this;
    }

    public RegistrationFormPage selectCity(String city) {
        step("Select city: " + city, () -> {
        generalElementsComponent.selectDropdownValue(citySelection, city);
        });

        return this;
    }

    public RegistrationFormPage submitForm() {
        step("Submit registration form", () -> {
        generalElementsComponent.clickSubmitButton();
        });

        return this;
    }

    public RegistrationFormPage checkResultsTableIsVisible() {
        step("Check that results table is visible", () -> {
        resultsModalComponent.checkIsVisible();
        });

        return this;
    }

    public RegistrationFormPage checkResults(String fieldName, String fieldValue) {
        step("Check that field '" + fieldName + "' contains value '" + fieldValue + "'", () -> {
        resultsModalComponent.checkResult(fieldName, fieldValue);
        });

        return this;
    }
}

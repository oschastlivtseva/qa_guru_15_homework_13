package guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GeneralElementsComponent {
    public GeneralElementsComponent inputInField(SelenideElement element, String value) {
        element.setValue(value);

        return this;
    }

    public GeneralElementsComponent inputInAutoCompleteField(SelenideElement element, String value) {
        element.click();
        element.setValue(value).pressEnter();

        return this;
    }

    public GeneralElementsComponent clickRadioButton(SelenideElement element, String buttonValue) {
        element.$(byText(buttonValue)).click();

        return this;
    }

    public GeneralElementsComponent clickCheckBox(String checkBoxValue) {
        $(byText(checkBoxValue)).click();

        return this;
    }

    public GeneralElementsComponent selectDropdownValue(SelenideElement element, String dropdownOption) {
        element.click();
        $(byText(dropdownOption)).click();

        return this;
    }

    public GeneralElementsComponent clickSubmitButton() {
        $("#submit").click();

        return this;
    }
}

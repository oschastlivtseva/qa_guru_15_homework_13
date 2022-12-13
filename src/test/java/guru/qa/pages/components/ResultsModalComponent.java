package guru.qa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModalComponent {

    public ResultsModalComponent checkIsVisible() {
        $(".modal-content").shouldBe(visible);

        return this;
    }

    public ResultsModalComponent checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));

        return this;
    }
}

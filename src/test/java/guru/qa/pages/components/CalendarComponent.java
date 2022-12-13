package guru.qa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public CalendarComponent setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").click();
        $(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $("[value='" + year + "']").scrollTo();
        $("[value='" + year + "']").click();
        $(".react-datepicker__month .react-datepicker__day--0" + day).click();

        return this;
    }
}

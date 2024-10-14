package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate (String day, String month, String year) {
        $(".react-datepicker__month-container").shouldBe(Condition.visible);
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1991");
        $(byText("30")).click();
    }
}

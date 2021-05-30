package tests;

import allureAnnotations.JiraIssue;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@JiraIssue("QC3-43")
@Feature("News page tests")
public class NewsPage extends TestBase {

    SelenideElement searchField = $("[placeholder='Поиск по новостям']");

    @Test
    @DisplayName("Page news should be loaded")
    void checkNewsPage() {
        step("Open main page", () -> open(""));
        step("Choose Russian language", () ->$(".lang-wrap").click());
        step("Click news", () -> $$(".menu-item").filterBy(text("Новости")).first().click());
        step ("Search text on the page", () -> searchField.shouldBe(visible));
    }

    @Test
    @AllureId("1922")
    @DisplayName("Page search news should be loaded")
    void searchNews() {
        open("/news");
        $(".lang-wrap").click();
        $(searchField).val("Компания Севергрупп, крупная инвестиционная компания");
        $(withText("В Санкт-Петербурге работают такие компании «Севергрупп» как «Силовые машины», «Лента», «Свеза», «Ава-Петер»")).shouldBe(visible);
    }

    @Test
    @Story("Console test")
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        open("/news");
        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs, not(containsString("SEVERE")));
    }
}
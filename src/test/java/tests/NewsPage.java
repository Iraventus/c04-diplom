package tests;

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

public class NewsPage extends TestBase {
    private final String search = "//*[@placeholder='Поиск по новостям']";

    @Test
    @DisplayName("Page news should be loaded")
    void checkNewsPage() {
        step("Open main page", () -> open(""));
        step("Choose Russian language", () ->$(".lang-wrap").click());
        step("Click news", () -> $$(".menu-item").filterBy(text("Новости")).first().click());
        step ("Search text on the page", () -> $x(search).shouldBe(visible));
    }

    @Test
    @DisplayName("Page search news should be loaded")
    void searchNews() {
        open("/news");
        $(".lang-wrap").click();
        $x(search).val("Компания Севергрупп, крупная инвестиционная компания");
        $(withText("В Санкт-Петербурге работают такие компании «Севергрупп» как «Силовые машины», «Лента», «Свеза», «Ава-Петер»")).shouldBe(visible);
    }

    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        open("/news");
        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs, not(containsString("SEVERE")));
    }
}
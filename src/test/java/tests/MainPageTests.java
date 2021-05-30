package tests;

import allureAnnotations.JiraIssue;
import config.ConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@JiraIssue("QC3-43")
@Feature("Main page tests")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Page should have title")
    void titlePageTest() {
        open("");
        $(".lang-wrap").click();
        $(".title").shouldHave(text("Инвестиционная группа"));
    }

    @Test
    @DisplayName("Page elements should be loaded")
    void checkElementsTest() {
        open("");
        $(".menu-item").shouldBe(visible);
        $(".lang-wrap").shouldBe(visible);
        $(".symbol-search").shouldBe(visible);
    }

    @Test
    @DisplayName("Page should have English text")
    void checkChangeLanguage() {
        open("");
        $(".title").shouldHave(text(ConfigHelper.getText()));
    }
}

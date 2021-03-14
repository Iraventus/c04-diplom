package tests;

import config.ConfigHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Page should have title")
    void titlePageTest() {
        open("");
        $(".title").shouldHave(text("Инвестиционная"));
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
    @DisplayName("Page should change language")
    void checkChangeLanguage() {
        open("");
        $(".lang-wrap").click();
        $(".title").shouldHave(text(ConfigHelper.getText()));
    }
}

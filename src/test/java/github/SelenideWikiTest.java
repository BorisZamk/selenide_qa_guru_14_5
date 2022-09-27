package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.headless;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        headless = true; // добавил для эксперимента, запуск браузера в скрытом режиме
    }

    @Test
    void shouldFindJUnit5ExmplInSelenideWiki() {


//        Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

        Configuration.holdBrowserOpen = true;


        // Откройте страницу Selenide в Github
        open("/selenide/selenide");

        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".js-wiki-more-pages-link").click();
        $$("[data-filterable-for=wiki-pages-filter] li").findBy(text("SoftAssertions")).shouldBe(visible);

        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$("[data-filterable-for=wiki-pages-filter] li").findBy(text("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}

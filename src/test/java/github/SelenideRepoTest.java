package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepoTest {

    @BeforeAll
    static void configure() {
//        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    void shouldFindSelenideAsRepo() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        open("https://github.com/");

        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();

        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}

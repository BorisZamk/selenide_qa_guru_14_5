package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SolutionsCompareHoverTest {

    @BeforeAll
    static void configure() {
//        Configuration.baseUrl = "https://github.com/";
//        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
        Configuration.headless = true;
    }

    @Test
    void isCompareFeaturesPageOpen() {


        // Откройте страницу github.com
        open("https://github.com/");

        // Подвести курсор на раздел Solutions и выбрать пункт Compare all
        $("header").$(byText("Solutions")).hover();
        $(byText("Compare all")).click();

        // Проверить, что открылся раздел с заголовком Compare features
        $(".application-main").shouldHave(text("Compare features"));

    }
}

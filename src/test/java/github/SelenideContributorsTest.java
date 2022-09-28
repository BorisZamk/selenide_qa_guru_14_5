package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.headless;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideContributorsTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        headless = true; // добавил для эксперимента, запуск браузера в скрытом режиме
    }

    @Test
    void andreySolntsevTheFirstContributers (){
//        Configuration.holdBrowserOpen = true;

        // Откройте страницу Selenide в Github
        open("/selenide/selenide");

        // Ищем блок с иконками Contributors и наводимся на первую из списка
        $(".Layout-sidebar").$(byText("Contributors"))
                .ancestor(".BorderGrid-cell").$$("ul li")
                .first().hover();
//        Проверил на скорость выполнения 2 варианта поиска:
//        $$("ul li").first().hover();  (8сек)
//        $("ul li").hover();           (9сек)
//
//        $(".Layout-sidebar").$(byText("Contributors"))
//                .ancestor(".BorderGrid-cell").$("ul li").hover();

        //Проверяем что в popover есть Андрей Солнцев
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }
}

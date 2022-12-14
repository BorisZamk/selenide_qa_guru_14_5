package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragNDropTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = " https://the-internet.herokuapp.com";
//        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
        Configuration.headless = true;
    }

    @Test
    void actionDrugNDrop() {

        // Открываем страницу /drag_and_drop
        open("/drag_and_drop");

        // Сохраняем состояние текста квадратов до начала теста
        String squareA = $("#column-a").text();

        // Перносим элемент
        // К сожалению, ни один из 3х вариантов не работает у меня почему то
//        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
//        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(300, 200).release().perform();
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();

        // Проверяем, что квадрат поменялся местами
        $("#column-a").shouldNotHave(Condition.exactTextCaseSensitive(squareA));
    }

    @Test
    void drugNDrop() {
        // Открываем страницу /drag_and_drop
        open("/drag_and_drop");

        // Сохраняем состояние текста квадратов до начала теста
        String squareB = $("#column-b").text();

        // Перносим элемент
        $("#column-a").dragAndDropTo("#column-b");

        // Проверяем, что квадрат поменялся местами
        $("#column-a").shouldHave(Condition.exactTextCaseSensitive(squareB));
    }
}

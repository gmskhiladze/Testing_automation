package Selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideBasics2Test {

    @Test
    public void find_books() {
        open("https://demoqa.com/books" );

        var elements = $(".rt-tbody").$$(".rt-tr-group");

        filter_books(elements);
    }

    public void filter_books(@NotNull ElementsCollection elements) {
        var f_books = elements.stream().filter(el -> {
            var title = el.lastChild().$$("div:nth-child(2)").texts();
            var publisher = el.lastChild().$$("div:nth-child(4)").texts();

            var result = title.contains("Javascript") && publisher.toString().equals("O'Reilly Media");

            return result;
        });

        check_assertion(f_books);
    }

    public void check_assertion(Stream<SelenideElement> f_books) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(f_books.count(), 10);
    }
}

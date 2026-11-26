package org.example.Questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductosEnCarrito {
    public static Question<List<String>> nombres() {

        return actor -> {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            List<WebElement> filas = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                            org.openqa.selenium.By.xpath("//tbody[@id='tbodyid']/tr/td[2]"), 0));
            return filas.stream().map(WebElement::getText).collect(Collectors.toList());
        };
    }
}

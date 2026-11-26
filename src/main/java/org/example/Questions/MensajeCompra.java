package org.example.Questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.example.Pages.HomePage;

public class MensajeCompra {
    public static Question<String> confirmacion() {
        return Text.of(HomePage.LBL_MENSAJE_COMPRA);
    }
}

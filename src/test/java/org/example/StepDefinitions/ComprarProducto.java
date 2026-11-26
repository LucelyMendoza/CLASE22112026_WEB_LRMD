package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.Pages.HomePage;
import org.example.Questions.MensajeCompra;
import org.example.Utils.PreAndProsCondition;
import org.example.Utils.ScreenShot;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class ComprarProducto {
    @And("selecciona el boton place order")
    public void seleccionaElBotonPlaceOrder() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_PLACE_ORDER));
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 5");
    }

    @And("ingresa los datos de compra nombre {string}, pais {string}, ciudad {string}, tarjeta {string}, mes {string} y anio {string}")
    public void ingresaLosDatosDeCompra(String nombre, String pais, String ciudad, String tarjeta, String mes, String anio) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(nombre).into(HomePage.INP_NOMBRE),
                Enter.theValue(pais).into(HomePage.INP_PAIS),
                Enter.theValue(ciudad).into(HomePage.INP_CIUDAD),
                Enter.theValue(tarjeta).into(HomePage.INP_TARJETA),
                Enter.theValue(mes).into(HomePage.INP_MES),
                Enter.theValue(anio).into(HomePage.INP_ANIO)
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 6");
    }

    @When("selecciona el boton purchase")
    public void seleccionaElBotonPurchase() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_PURCHASE));
    }

    @Then("el sistema muestra la confirmacion de compra {string}")
    public void elSistemaMuestraLaConfirmacionDeCompra(String mensaje) {
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 7");
        theActorInTheSpotlight().should(
                seeThat(
                        MensajeCompra.confirmacion(),
                        equalTo(mensaje)
                )
        );
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_OK_COMPRA));
    }
}

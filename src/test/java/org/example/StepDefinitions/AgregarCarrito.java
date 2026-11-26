package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import org.example.Pages.HomePage;
import org.example.Questions.ProductosEnCarrito;
import org.example.Questions.ResponseCode;
import org.example.Tasks.NavigateHome;
import org.example.Utils.Parameters;
import org.example.Utils.PreAndProsCondition;
import org.example.Utils.ScreenShot;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;

public class AgregarCarrito {
    @Given("el {actor} esta en la página de inicio")
    public void elUsuarioEstaEnLaPáginaDeInicio(Actor actor) {
        actor.attemptsTo(NavigateHome.theHomepage());
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 1");
    }

    @And("selecciona el producto {string}")
    public void seleccionaElProducto(String producto) {
        Parameters.PRODUCTO_ACTUAL = producto;
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.LNK_PRODUCTO.of(producto)));
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 2");
    }

    @When("agrega el producto al carrito")
    public void agregaElProductoAlCarrito() {
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 3");
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_AGREGAR_CARRITO));
        // no se toma captura aqui: el alert del navegador esta abierto
    }

    @Then("el sistema muestra un mensaje que contiene {string}")
    public void elSistemaMuestraUnMensajeQueContiene(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat(
                        ResponseCode.alertMessage(),
                        containsString(mensaje)
                )
        );
    }

    @And("acepta el mensaje de confirmacion")
    public void aceptaElMensajeDeConfirmacion() {
        theActorInTheSpotlight().asksFor(ResponseCode.alertMessage());
    }

    @When("ingresa al carrito")
    public void ingresaAlCarrito() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.LNK_CARRITO));
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 4");
    }

    @Then("el carrito muestra el producto {string}")
    public void elCarritoMuestraElProducto(String producto) {
        theActorInTheSpotlight().should(
                seeThat(
                        ProductosEnCarrito.nombres(),
                        hasItem(producto)
                )
        );
    }
}

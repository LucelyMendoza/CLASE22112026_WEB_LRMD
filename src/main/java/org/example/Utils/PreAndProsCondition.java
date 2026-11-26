package org.example.Utils;

import io.cucumber.java.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PreAndProsCondition {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreAndProsCondition.class);
    public static String screenShot = Parameters.RutaEvidencia;

    @Before()
    public void beforeScenario(Scenario scenario) {
        LOGGER.info("_____________________________________________________");
        LOGGER.info("Running:" + scenario.getName());
        OnStage.setTheStage(new OnlineCast());
        LOGGER.info("create folder for screenshot");
        screenShot += ScreenShot.getCurrentDateTime() + "_" + scenario.getName();
        Parameters.RutaEvidenciaActual = screenShot;
        ScreenShot.createFolder(screenShot);
        // La sesión se limpia sola: Chrome corre en modo --incognito (ver serenity.conf)
    }

    @After()
    public void afterScenario(Scenario scenario) {
        //realizar alguna acción al finalizar el scenario
        LOGGER.info("finishing:" + scenario.getName());
        screenShot = Parameters.RutaEvidencia;
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        LOGGER.info("step in:" + scenario.getName());
    }
}

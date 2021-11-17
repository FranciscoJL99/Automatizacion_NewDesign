package com.newdesing.automation.interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Espera implements Interaction {


    private final int durationTime;
    private static final Logger LOGGER = LoggerFactory.getLogger(Espera.class.getName());

    public Espera(int durationTime) {
        this.durationTime = durationTime;
    }


    public static Interaction porUnMomento(int durationTime) {
        return instrumented(Espera.class, durationTime);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), durationTime);
        try {
            wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
        } catch (Exception e) {
            LOGGER.info("Se genero tiempo de espera");
        }


    }
}
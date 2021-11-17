package com.newdesing.automation.tasks;

import com.newdesing.automation.interactions.Espera;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;


import static com.newdesing.automation.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarOpcion implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(OPCION_PROGRAMAR_PRESENTACION),
                Espera.porUnMomento(1),
                Scroll.to(OPCION_PROGRAMAR_PRESENTACION),
                Click.on(OPCION_PROGRAMAR));
    }

    public static Performable deProgramacion() {
        return instrumented(SeleccionarOpcion.class);
    }
}

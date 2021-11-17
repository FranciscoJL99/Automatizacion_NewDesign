package com.newdesing.automation.questions;

import static com.newdesing.automation.userinterfaces.Calendario.OPCION_PROGRAMAR_PRESENTACION;
import net.serenitybdd.screenplay.Question;

public class Fecha {

    public static Question<String> enCalendario() {
        return actor ->
                OPCION_PROGRAMAR_PRESENTACION.resolveFor(actor).getText();
    }

}

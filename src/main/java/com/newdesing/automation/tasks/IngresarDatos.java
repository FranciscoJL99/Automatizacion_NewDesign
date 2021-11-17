package com.newdesing.automation.tasks;

import com.newdesing.automation.interactions.IngresarFechas;
import com.newdesing.automation.models.DatosProgramacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;


import static com.newdesing.automation.userinterfaces.Calendario.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarDatos implements Task {

    DatosProgramacion datosProgramacion;

    public IngresarDatos(DatosProgramacion datosProgramacion) {
        this.datosProgramacion = datosProgramacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(IngresarFechas.enCalendario(datosProgramacion.getDia(), datosProgramacion.getMes(), datosProgramacion.getTemporada())
                , Click.on(HORA.of(datosProgramacion.getHora() + " " + datosProgramacion.getRangoHora()))
                , SendKeys.of(datosProgramacion.getCorreo()).into(CAMPO_EMAIL)
                , Click.on(BOTON_AGENDAR)
                , SendKeys.of(datosProgramacion.getNombre()).into(CAMPO_NOMBRE)
                , SendKeys.of(datosProgramacion.getCelular()).into(CAMPO_CELULAR)
                , Click.on(BOTON_AGENDAR)
        );
    }


    public static Performable deProgramacion(DatosProgramacion datosProgramacion) {
        return instrumented(IngresarDatos.class, datosProgramacion);
    }
}

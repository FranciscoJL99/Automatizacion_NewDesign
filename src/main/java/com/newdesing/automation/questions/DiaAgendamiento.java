package com.newdesing.automation.questions;

import com.newdesing.automation.models.DatosProgramacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.newdesing.automation.userinterfaces.Calendario.DIA_EN_MENSAJE_AGENDAMIENTO;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class DiaAgendamiento implements Question<Boolean> {
    DatosProgramacion datosProgramacion;
    public DiaAgendamiento(DatosProgramacion datosProgramacion) {
        this.datosProgramacion = datosProgramacion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
       return  the(DIA_EN_MENSAJE_AGENDAMIENTO).answeredBy(actor).getText().equals(datosProgramacion.getDia());
    }

    public static DiaAgendamiento correcto(DatosProgramacion datosProgramacion) {
        return new DiaAgendamiento(datosProgramacion);
    }
}

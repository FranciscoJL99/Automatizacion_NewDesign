package com.newdesing.automation.questions;

import com.newdesing.automation.models.DatosProgramacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.newdesing.automation.userinterfaces.Calendario.HORA_EN_MENSAJE_AGENDAMIENTO;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class HoraAgendamiento implements Question<Boolean> {
    DatosProgramacion datosProgramacion;
    public HoraAgendamiento(DatosProgramacion datosProgramacion) {
        this.datosProgramacion = datosProgramacion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
       return  the(HORA_EN_MENSAJE_AGENDAMIENTO).answeredBy(actor).getText().equals(datosProgramacion.getHora()+ " " + datosProgramacion.getRangoHora());
    }

    public static HoraAgendamiento correcto(DatosProgramacion datosProgramacion) {
        return new HoraAgendamiento(datosProgramacion);
    }
}

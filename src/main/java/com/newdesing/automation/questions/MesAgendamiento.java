package com.newdesing.automation.questions;

import com.newdesing.automation.models.DatosProgramacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.newdesing.automation.userinterfaces.Calendario.MENSAJE_AGENDAMIENTO;
import static com.newdesing.automation.userinterfaces.Calendario.MES_EN_MENSAJE_AGENDAMIENTO;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class MesAgendamiento implements Question<Boolean> {
    DatosProgramacion datosProgramacion;
    public MesAgendamiento(DatosProgramacion datosProgramacion) {
        this.datosProgramacion = datosProgramacion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
       return  the(MES_EN_MENSAJE_AGENDAMIENTO).answeredBy(actor).getText().equals(datosProgramacion.getMes().toUpperCase());
    }

    public static MesAgendamiento correcto(DatosProgramacion datosProgramacion) {
        return new MesAgendamiento(datosProgramacion);
    }
}

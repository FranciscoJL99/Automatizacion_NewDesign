package com.newdesing.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.newdesing.automation.userinterfaces.Calendario.MENSAJE_AGENDAMIENTO;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class MensajeAgendamiento implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
       return  the(MENSAJE_AGENDAMIENTO).answeredBy(actor).isPresent();
    }

    public static MensajeAgendamiento presente() {
        return new MensajeAgendamiento();
    }
}

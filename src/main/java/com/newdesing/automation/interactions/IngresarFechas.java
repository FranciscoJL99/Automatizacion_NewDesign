package com.newdesing.automation.interactions;

import com.newdesing.automation.questions.Fecha;
import com.newdesing.automation.userinterfaces.HomePage;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;


import java.util.Locale;
import static com.newdesing.automation.userinterfaces.Calendario.*;
import static com.newdesing.automation.utils.ObtenerNumeroMes.numeroMes;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarFechas implements Interaction {
    String dia,  mes, temporada;

    public IngresarFechas(String dia, String mes, String temporada) {
        this.dia = dia;
        this.mes = mes;
        this.temporada = temporada;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        String mesYear = mes.toUpperCase(Locale.ROOT) + " DE " + temporada;
        String fechaNumerica = temporada+"-"+numeroMes(mes)+"-"+dia;
        actor.attemptsTo(Click.on(OPCION_CALENDARIO));
        System.out.println(actor.asksFor(Fecha.enCalendario()) + " " + mesYear);
        while(!actor.asksFor(Fecha.enCalendario()).equals(mesYear)) {
            actor.attemptsTo(Click.on(CONTINUAR_CALENDARIO));
        }
        actor.attemptsTo(Click.on(DIA_EN_CALENDARIO.of(fechaNumerica))
        );

    }
    public static Interaction enCalendario(String dia, String mes, String temporada) {
        return instrumented(IngresarFechas.class, dia, mes, temporada);
    }
}

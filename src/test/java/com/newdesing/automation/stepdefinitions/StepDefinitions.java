package com.newdesing.automation.stepdefinitions;

import com.newdesing.automation.exceptions.ResultNotWaited;
import com.newdesing.automation.models.DatosProgramacion;
import com.newdesing.automation.questions.DiaAgendamiento;
import com.newdesing.automation.questions.HoraAgendamiento;
import com.newdesing.automation.questions.MensajeAgendamiento;
import com.newdesing.automation.questions.MesAgendamiento;
import com.newdesing.automation.tasks.IngresarDatos;
import com.newdesing.automation.tasks.SeleccionarOpcion;
import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.newdesing.automation.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitions {
    public static final String ACTOR = "Actor";

    @Managed
        private WebDriver hisBrowser;

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR).can(BrowseTheWeb.with(hisBrowser));
    }
    @Dado("^Que me encuentro en la pagina de new Desing$")
    public void queMeEncuentroEnLaPaginaDeNewDesing() {
        theActorInTheSpotlight().attemptsTo(Open.url("https://newdesign.millionandup.com/"));
    }

    @Cuando("^Solicito la programacion de una presentacion$")
    public void solicitoLaProgramacionDeUnaPresentacion() {
        theActorInTheSpotlight().attemptsTo(SeleccionarOpcion.deProgramacion());
    }

    @Y("^Selecciono la opcion de video llamada$")
    public void seleccionoLaOpcionDeVideoLlamada() {
        theActorInTheSpotlight().attemptsTo(Click.on(OPCION_VIDEO_LLAMADA));
    }

    @E("^Ingreso los datos necesarios$")
    public void ingresoLosDatosNecesarios(List<DatosProgramacion> datosProgramacions) {
        theActorInTheSpotlight().attemptsTo(IngresarDatos.deProgramacion(datosProgramacions.get(0)));
    }

    @Entonces("^Se realiza la programacion exitosa de la presentacion$")
    public void seRealizaLaProgramacionExitosaDeLaPresentacion(List<DatosProgramacion> datosProgramacions) {
        theActorInTheSpotlight().should(seeThat(MensajeAgendamiento.presente(), Matchers.equalTo(true)).orComplainWith(ResultNotWaited.class, ResultNotWaited.MENSAJE_AGENDAMIENTO_NO_PRESENTE));
        theActorInTheSpotlight().should(seeThat(DiaAgendamiento.correcto(datosProgramacions.get(0)), Matchers.equalTo(true)).orComplainWith(ResultNotWaited.class, ResultNotWaited.DIA_AGENDAMIENTO_NO_CORRECTO));
        theActorInTheSpotlight().should(seeThat(MesAgendamiento.correcto(datosProgramacions.get(0)), Matchers.equalTo(true)).orComplainWith(ResultNotWaited.class, ResultNotWaited.MES_AGENDAMIENTO_NO_CORRECTO));
        theActorInTheSpotlight().should(seeThat(HoraAgendamiento.correcto(datosProgramacions.get(0)), Matchers.equalTo(true)).orComplainWith(ResultNotWaited.class, ResultNotWaited.HORA_AGENDAMIENTO_NO_CORRECTO));

    }
}

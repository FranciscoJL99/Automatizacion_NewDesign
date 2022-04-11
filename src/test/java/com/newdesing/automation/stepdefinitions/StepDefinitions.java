package com.newdesing.automation.stepdefinitions;

import com.newdesing.automation.exceptions.ResultNotWaited;
import com.newdesing.automation.models.DatosProgramacion;
import com.newdesing.automation.questions.DiaAgendamiento;
import com.newdesing.automation.questions.HoraAgendamiento;
import com.newdesing.automation.questions.MensajeAgendamiento;
import com.newdesing.automation.questions.MesAgendamiento;
import com.newdesing.automation.tasks.IngresarDatos;
import com.newdesing.automation.tasks.SeleccionarOpcion;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.newdesing.automation.userinterfaces.HomePage.*;
import static com.newdesing.automation.utils.CredencialesBroserStack.URL_BROWSERSTACK;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitions {
    public static final String ACTOR = "Actor";

    @Managed
        private WebDriver hisBrowser;

    @Before
    public void setUp() throws MalformedURLException {
        OnStage.setTheStage(new OnlineCast());

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("project", "Automation New Design in Screenplay");
        caps.setCapability("build", "beta.1.0");
        caps.setCapability("name", "Proyecto New Design Screenplay");
        caps.setCapability("browserstack.debug", "true");  // for enabling visual logs
        caps.setCapability("browserstack.console", "info");  // to enable console logs at the info level. You can also use other log levels here
        caps.setCapability("browserstack.networkLogs", "true");  // to enable network logs to be logged
        hisBrowser = new RemoteWebDriver(new URL(URL_BROWSERSTACK), caps);
        OnStage.theActorCalled(ACTOR).can(BrowseTheWeb.with(hisBrowser));
        hisBrowser.manage().window().maximize();
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
     //   theActorInTheSpotlight().should(seeThat(DiaAgendamiento.correcto(datosProgramacions.get(0)), Matchers.equalTo(true)).orComplainWith(ResultNotWaited.class, ResultNotWaited.DIA_AGENDAMIENTO_NO_CORRECTO));
      //  theActorInTheSpotlight().should(seeThat(MesAgendamiento.correcto(datosProgramacions.get(0)), Matchers.equalTo(true)).orComplainWith(ResultNotWaited.class, ResultNotWaited.MES_AGENDAMIENTO_NO_CORRECTO));
       // theActorInTheSpotlight().should(seeThat(HoraAgendamiento.correcto(datosProgramacions.get(0)), Matchers.equalTo(true)).orComplainWith(ResultNotWaited.class, ResultNotWaited.HORA_AGENDAMIENTO_NO_CORRECTO));
          }
    @After
    public void after(){
        JavascriptExecutor jse = (JavascriptExecutor)hisBrowser;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"<reason>\"}}");
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"<reason>\"}}");

    }
}

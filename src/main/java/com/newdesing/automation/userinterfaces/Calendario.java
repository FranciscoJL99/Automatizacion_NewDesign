package com.newdesing.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Calendario {

    public static final Target OPCION_PROGRAMAR_PRESENTACION = Target.the("Mes y año en calendario").
        locatedBy("//h2[@class='fc-toolbar-title']");
    public static final Target CONTINUAR_CALENDARIO = Target.the("Continuar al siguiente mes en calendario").
            locatedBy("//button[@aria-label='next']");
    public static final Target DIA_EN_CALENDARIO = Target.the("Dias presentes en calendario").
            locatedBy("//td[@data-date='{0}']");
    public static final Target HORA = Target.the("Hora a programar").
            locatedBy("//span[@class='initial-time' and contains(text(),'{0}')]");
    public static final Target CAMPO_EMAIL = Target.the("Campo para ingresar email").
            located(By.xpath("//input[@class='clean-txt email show-schedule']"));
    public static final Target BOTON_AGENDAR = Target.the("Boton agendar").
            located(By.id("btnSendModal"));
    public static final Target OPCION_CALENDARIO = Target.the("Calendario en programacion").
            locatedBy("//*[@id='scheduleForm']/div[3]");
    public static final Target CAMPO_NOMBRE = Target.the("Campo de nombre en calendario").
            locatedBy("//input[@class='clean-txt show-schedule']");
    public static final Target CAMPO_CELULAR = Target.the("Campo de celular en calendario").
            locatedBy("//input[@class='clean-txt international-phone-number show-schedule']");
    public static final Target MENSAJE_AGENDAMIENTO = Target.the("Campo de celular en calendario").
            locatedBy("//div[@class='d-flex schedule-response-text']");
    public static final Target DIA_EN_MENSAJE_AGENDAMIENTO = Target.the("Campo de celular en calendario").
            locatedBy("//span[@class='schedule-response-day mt-n2 day-number']");
    public static final Target MES_EN_MENSAJE_AGENDAMIENTO = Target.the("Campo de celular en calendario").
            locatedBy("//span[@class='schedule-response-bold ml-3 month']");
    public static final Target HORA_EN_MENSAJE_AGENDAMIENTO = Target.the("Campo de celular en calendario").
            locatedBy("//span[@class='schedule-response-bold hour-init']");
}

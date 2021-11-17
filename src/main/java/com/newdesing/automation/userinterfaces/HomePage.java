package com.newdesing.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target OPCION_PROGRAMAR_PRESENTACION = Target.the("Opcion de programar presentacion de proyecto").
        located(By.xpath("//*[@id='section-location-index']/div[3]/div[1]/h2[1]/span[1]"));
    public static final Target OPCION_PROGRAMAR = Target.the("Opcion de programar presentacion de proyecto").
            located(By.xpath("//*[@id='addressBtn']"));
    public static final Target OPCION_VIDEO_LLAMADA = Target.the("Opcion programacion por video llamada").
            locatedBy("//button[@schedule-requested='Project presentation (Zoom Call)']");



}

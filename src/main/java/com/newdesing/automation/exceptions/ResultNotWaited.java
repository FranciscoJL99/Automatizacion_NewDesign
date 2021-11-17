package com.newdesing.automation.exceptions;

public class ResultNotWaited extends AssertionError{
    public static final String MENSAJE_AGENDAMIENTO_NO_PRESENTE = "El mensaje esperado para agendar no esta presente, no se realizo el agendamiento";
    public static final String DIA_AGENDAMIENTO_NO_CORRECTO = "El dia presentado no es el correcto";
    public static final String MES_AGENDAMIENTO_NO_CORRECTO = "El mes presentado no es el correcto";
    public static final String HORA_AGENDAMIENTO_NO_CORRECTO = "La hora presentada no es la correcta";


    public ResultNotWaited(String message, Throwable cause) {
        super(message,cause);
    }

}

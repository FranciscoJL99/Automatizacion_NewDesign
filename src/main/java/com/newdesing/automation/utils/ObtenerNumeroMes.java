package com.newdesing.automation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ObtenerNumeroMes {
    public static int numeroMes(String mes) throws ParseException {
        Date date = new SimpleDateFormat("MMM").parse(mes);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return (cal.get(Calendar.MONTH)+1);
    }
}

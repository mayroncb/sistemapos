/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3construcoes.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author paulolira
 */
public class SistemaUtil {

    public static void addNotificacao(FacesMessage.Severity tipo, String message, String titulo) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(tipo, titulo, message));
        RequestContext.getCurrentInstance().update("growl");
    }

    public static void updateDataTable(String titulo) {

    }

    public static Date timeMillisToDate(Long timemillis) {
        Date date = new Date(timemillis);
        SimpleDateFormat fdate = new SimpleDateFormat("dd-MM-yyyy");
      //  date = fdate.parse(date);
        
        return null;
    }
}

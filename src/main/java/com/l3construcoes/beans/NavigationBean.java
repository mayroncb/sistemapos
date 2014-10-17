/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.beans;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author paulolira
 */
public class NavigationBean implements Serializable {
    
    
    private static final long serialVersionUID = 1520318172495977648L;
    
    /**
     * Redirect to login page.
     * @return Login page name.
     */
    public String redirectToLogin() {
        return "/login.xhtml?faces-redirect=true";
    }
    
     /**
     * Redirect to login page.
     * @return Login page name.
     */
    public String toLogin() {
        return "/login.xhtml";
    }
    
    /**
     * Redirect to home page.
     * @return home page name.
     */
    public String redirectToHome() {
        return "/dashboard.xhtml";
    }

     /**
     * Redirect to login page.
     * @return Login page name.
     */
    public void toHome() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/html/admin/dashboard.xhtml"); 
    }
}

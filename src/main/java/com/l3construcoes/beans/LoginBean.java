/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.beans;

import com.l3construcoes.entidades.User;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author paulolira
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
    
    
    private User user;
    
    private boolean loggedIn;
    
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;
    
    @PostConstruct
    private void init(){
        user = new User();
        navigationBean = new NavigationBean();
    }
    
    public void doLogin() throws IOException{
        System.out.println(user.getUserName() + user.getPasswd() + "<<<<<<<");
        if(user.getUserName().equals("paulo")
                && "1234".equals(user.getPasswd())  ){
            System.out.println("IFFFF");
            loggedIn = true;
            navigationBean.toHome();
        } else {
            addNotificacao("kjhjkh", "kljh");
            //return navigationBean.redirectToLogin();
        }
    }

        public void addNotificacao(String message, String tipo) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, tipo, message));
        RequestContext.getCurrentInstance().update("growl");
    }
    
    
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NavigationBean getNavigationBean() {
        return navigationBean;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
    
    
    
}

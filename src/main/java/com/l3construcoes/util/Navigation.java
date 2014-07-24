package com.l3construcoes.util;

 
public enum Navigation {
    
    LOGIN_PAGE("/html/Login/login.xhtml"),
    ADMIN_PAGE("/html/Admin/dashboard.xhtml");

    private String navigation;

    private Navigation(String navigation) {
        this.navigation = navigation;
    }

    public String getNavigation() {
        return navigation;
    }
    
}

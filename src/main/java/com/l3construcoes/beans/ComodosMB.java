/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.beans;

import com.l3construcoes.entidades.Comodo;
import com.l3construcoes.service.ComodoService;
import com.l3construcoes.service.ComodoServiceImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author paulolira
 */
@ManagedBean(name = "comodoMB")
@SessionScoped
@Component
public class ComodosMB {
    
    private ComodoService service;
    
    private Comodo selectedComodo;
    
    @PostConstruct
    private void init(){
        selectedComodo = new Comodo();
        service = new ComodoServiceImpl();
        comodos = service.getAllComodos();
    }

    public void alterComodo(){
        service.alterarComodo(selectedComodo);
 
 
    }
    
    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }
    
    private List<Comodo> comodos;

    public Comodo getSelectedComodo() {
        return selectedComodo;
    }

    public void setSelectedComodo(Comodo selectedComodo) {
        this.selectedComodo = selectedComodo;
    }
    
    
    
    
}

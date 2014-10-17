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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author paulolira
 */
@ManagedBean(name = "comodoMB")
@ViewScoped
@Component
public class ComodosMB {
    
    private ComodoService service;
    
    private List<Comodo> comodos;
    
    private Comodo selectedComodo;
    
    private Comodo comodo;
    
    @PostConstruct
    private void init(){  
        selectedComodo = new Comodo();
        service = new ComodoServiceImpl();
        comodo = new Comodo();
    }
    
    public void addComodo(){
        service.addComodo(comodo);
        addNotificacao(comodo.getDescricao(), "Adicionado: ");
        RequestContext.getCurrentInstance().update("form:comodos");
        comodo = new Comodo();
        
    }

    public void alterComodo(){
        service.alterarComodo(selectedComodo);  
        addNotificacao(selectedComodo.getDescricao(), "Alterado: ");
        RequestContext.getCurrentInstance().update("form:comodos");
        selectedComodo = new Comodo();
    }
    
    public void removeComodo(Comodo c){
        service.removeComodo(c); 
        RequestContext.getCurrentInstance().update("form:comodos");
        addNotificacao(c.getDescricao(), "Removido: ");
        comodos = service.getAllComodos();
       
    }
    
    public List<Comodo> getComodos() {
        return service.getAllComodos();
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }

    public Comodo getSelectedComodo() {
        return selectedComodo;
    }

    public void setSelectedComodo(Comodo selectedComodo) {
        this.selectedComodo = selectedComodo;
    }

    public Comodo getComodo() {
        return comodo;
    }

    public void setComodo(Comodo comodo) {
        this.comodo = comodo;
    }
    
    
    public void addNotificacao(String message, String tipo) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, tipo, message));
        RequestContext.getCurrentInstance().update("growl");
    }
    
}

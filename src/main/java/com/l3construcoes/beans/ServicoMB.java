/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.beans;

import com.l3construcoes.entidades.Comodo;
import com.l3construcoes.entidades.Servico;
import com.l3construcoes.service.ServicoService;
import com.l3construcoes.service.ServicoServiceImpl;
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
@ManagedBean(name = "servicoMB")
@ViewScoped
@Component
public class ServicoMB {
    
    private ServicoService service;
    
    private List<Servico> servicos;
    
    private Servico selectedServico;
    
    private Servico servico;
    
    @PostConstruct
    private void init(){  
        selectedServico = new Servico();
        service = new ServicoServiceImpl();
        servico = new Servico();
    }
    
    public void addServico(){
        service.addServico(servico);
        addNotificacao(servico.getDescricao(), "Adicionado: ");
        RequestContext.getCurrentInstance().update("form:servicos");
        servico = new Servico();
        
    }

    public void alterServico(){
        service.alterarServico(selectedServico);  
        addNotificacao(selectedServico.getDescricao(), "Alterado: ");
        RequestContext.getCurrentInstance().update("form:servicos");
        selectedServico = new Servico();
    }
    
    public void removeServico(Servico c){
        service.removeServico(c);
        RequestContext.getCurrentInstance().update("form:servicos");
        addNotificacao(c.getDescricao(), "Removido: ");
        servicos = service.getAllServicos();
    }
    
    public void addNotificacao(String message, String tipo) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, tipo, message));
        RequestContext.getCurrentInstance().update("growl");
    }

    public ServicoService getService() {
        return service;
    }

    public void setService(ServicoService service) {
        this.service = service;
    }

    public List<Servico> getServicos() {
        return service.getAllServicos();
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Servico getSelectedServico() {
        return selectedServico;
    }

    public void setSelectedServico(Servico selectedServico) {
        this.selectedServico = selectedServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    
    
}

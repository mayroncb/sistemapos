/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.beans;

import com.l3construcoes.entidades.Cliente;
import com.l3construcoes.service.ClienteService;
import com.l3construcoes.service.ClienteServiceImpl;
import com.l3construcoes.util.Constants;
import com.l3construcoes.util.SistemaUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.springframework.dao.DuplicateKeyException;

/**
 *
 * @author paulolira
 */
@RequestScoped
@ManagedBean(name = "manterClienteMB")
public class ManterClienteMB implements Serializable{
    
    private ClienteService clienteService;    
    private Cliente cliente;
    private List<Cliente> clientes;
    private Cliente selectedCliente;

    @PostConstruct
    private void init(){
        cliente = new Cliente();
        clienteService = new ClienteServiceImpl();
        clientes = clienteService.findAll();
        Object object = FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("editUser");
        if(object != null){
            cliente = (Cliente) object;
            FacesContext.getCurrentInstance().
                    getExternalContext().getSessionMap().remove("editUser");
        }
    }
    
    public void irEditarCliente(Cliente c) throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("editUser", c);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/l3"+Constants.LINK_EDITAR_CLIENTE);
    }
    
    public String editarCliente() throws IOException{
        clienteService.editar(cliente);
        SistemaUtil.addNotificacao(FacesMessage.SEVERITY_INFO, cliente.getNome(), "Alerado");
       return Constants.LINK_DASHBOARD;
    }
    
    public String saveCliente() {
        try {
            clienteService.save(cliente);
            SistemaUtil.addNotificacao(FacesMessage.SEVERITY_INFO ,"Cliente", "Adicionado com Sucesso");
        } catch (DuplicateKeyException e)  {
            SistemaUtil.addNotificacao(FacesMessage.SEVERITY_FATAL ,"CPF Já Cadastrado!", "Erro");
        }  
        return Constants.LINK_DASHBOARD;          
    }
    
    public void deleteCliente(Cliente c){
        clienteService.remove(c);
        SistemaUtil.addNotificacao(FacesMessage.SEVERITY_INFO, cliente.getNome(), "Removido");
        RequestContext.getCurrentInstance().update("form:clientes_tbl");
    }
    
    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clienteService.findAll();
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }
    
    
    
    
}

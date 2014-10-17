/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.beans;

import com.l3construcoes.entidades.Cliente;
import com.l3construcoes.entidades.Projeto;
import com.l3construcoes.service.ClienteService;
import com.l3construcoes.service.ClienteServiceImpl;
import com.l3construcoes.service.ProjetoService;
import com.l3construcoes.service.ProjetoServiceImpl;
import com.l3construcoes.util.Constants;
import com.l3construcoes.util.SistemaUtil;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import lombok.Data;
import org.primefaces.context.RequestContext;

/**
 *
 * @author paulolira
 */
/**
 *
 * @author paulolira
 */
@Data
@ManagedBean(name = "listarProjetosMB")
@ViewScoped
public class ListarProjetosMB implements Serializable {
    
    private ProjetoService service;
    
    private ClienteService clienteService;
    
    private String qtdProjetos;
    
    private List<Projeto> listaProjetosPorCliente;
    
    private List<Projeto> projetos;
    
    private Cliente cliente;
    
    private List<Cliente> clientes;
    
    private Projeto projetoSelected;
    
    
    
    @PostConstruct
    public void init(){
        clienteService = new ClienteServiceImpl();
        service = new ProjetoServiceImpl();
        clientes = clienteService.findAll();
        cliente = new Cliente();
        projetos = service.getProjects();
    }
    
    public String irEditarProjeto(){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.getSessionMap().put("editProjectId", projetoSelected.getId());
        return Constants.LINK_EDITAR_PROJETO;
    }
    
    public void projetosPorCliente(){
        listaProjetosPorCliente = service.getProjetosPorCliente(cliente); 
        RequestContext.getCurrentInstance().update("form:table_projetos");
    }
    
    public void removerProjeto(){
        service.remover(projetoSelected);
        listaProjetosPorCliente = service.getProjetosPorCliente(cliente); 
        SistemaUtil.addNotificacao( FacesMessage.SEVERITY_INFO , "Removido com sucesso", "Projeto");
        RequestContext.getCurrentInstance().update("form:table_projetos");
        
    }
    
    public List<Projeto.EstatusProjeto> estatusProjeto(){
        List<Projeto.EstatusProjeto> estatus = new ArrayList<>();
        estatus.addAll(Arrays.asList(Projeto.EstatusProjeto.values()));
        return estatus;
    }
    
 
}

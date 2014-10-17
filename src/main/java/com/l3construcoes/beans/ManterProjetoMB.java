/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.beans;

import com.l3construcoes.entidades.Cliente;
import com.l3construcoes.entidades.Comodo;
import com.l3construcoes.entidades.Endereco;
import com.l3construcoes.entidades.Projeto;
import com.l3construcoes.service.ClienteService;
import com.l3construcoes.service.ComodoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author paulolira
 */
@ManagedBean(name = "manterProjetoMB")
@ViewScoped
public class ManterProjetoMB implements Serializable {
    
    private Projeto projeto;
    
    private ComodoService comodoService;
    
    private boolean copiarEndereco;
    
    private Cliente cliente;
    
    private Comodo selectedComodo = new Comodo();
    
    
    public void copiarEnderecoCliente() {
        if (!copiarEndereco) {
            projeto.setEndereco(cliente.getEndereco());
        } else {
            projeto.setEndereco(new Endereco());
        }
    }
    
    public String onFlowProcess(FlowEvent event) {     
        if (event.getOldStep().equals("servicos")) {
            //viewConfirmationProject();
        }    
        return event.getNewStep();
    }
       
    public double getCalcM2() {
        double result = 0;
        result = (projeto.getTerreno().getLateral() * projeto.getTerreno().getFrente());
        projeto.getTerreno().setTotal(result);
        return result;
    }
    
    public List<Comodo> loadComodos(){
        List<Comodo> listReturn = new ArrayList<>();
        if (("Normal").equalsIgnoreCase(projeto.getTipo())) {
            listReturn = comodoService.getAllComodosByPadrao(projeto.getTipo());
        } else if (("Basico").equalsIgnoreCase(projeto.getTipo())) {
            listReturn = comodoService.getAllComodosByPadrao(projeto.getTipo());
        }
     return listReturn;   
    }
    
    public Projeto getProjeto() {
        return projeto;
    }
    
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isCopiarEndereco() {
        return copiarEndereco;
    }

    public void setCopiarEndereco(boolean copiarEndereco) {
        this.copiarEndereco = copiarEndereco;
    }
    
    
    
}

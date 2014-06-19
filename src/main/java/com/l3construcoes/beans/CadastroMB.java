/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3construcoes.beans;

import com.l3construcoes.entidades.Cliente;
import com.l3construcoes.entidades.Endereco;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author paulolira
 */
@ManagedBean(name = "cadastroMB")
@ViewScoped
public class CadastroMB implements Serializable{

    private boolean skip;
    
    private Cliente cliente;
    
    private Endereco endereco;

    public CadastroMB() {
        this.endereco = new Endereco();
        this.cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        System.out.println(cliente.getNome());
        this.cliente = cliente;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            System.out.println("true");
            skip = false;
            return "confirm";
        } else {
            System.out.println(event.getNewStep());
            return event.getNewStep();
        }
    }
}

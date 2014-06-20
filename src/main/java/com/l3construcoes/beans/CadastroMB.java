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
import javax.faces.bean.SessionScoped;

/**
 *
 * @author paulolira
 */
@ManagedBean(name = "cadastroMB")
@SessionScoped
public class CadastroMB implements Serializable {

    private boolean skip;

    private Cliente cliente;

    private Endereco endereco;

    private Endereco enderecoObra;

    private int pavimentos;

    private int frente;

    private int lateral;

    public int getCalcM2(){
        int result = 0;
        result = (getLateral() * getFrente()) * getPavimentos();
        System.err.println(result);
        return result;
    }

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

    public Endereco getEnderecoObra() {
        return enderecoObra;
    }

    public void setEnderecoObra(Endereco enderecoObra) {
        this.enderecoObra = enderecoObra;
    }

    public int getPavimentos() {
        return pavimentos;
    }

    public void setPavimentos(int pavimentos) {
        this.pavimentos = pavimentos;
    }

    public int getFrente() {
        return frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getLateral() {
        return lateral;
    }

    public void setLateral(int fundo) {
        this.lateral = fundo;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
}

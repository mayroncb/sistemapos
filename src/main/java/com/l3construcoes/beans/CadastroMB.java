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
import com.l3construcoes.service.ComodoService;
import com.l3construcoes.service.ComodoServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

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

    private String padraoProjeto;

    private ComodoService comodoService = new ComodoServiceImpl();

    private Projeto projeto;

    private Comodo selectedComodo = new Comodo();

    private boolean copiarEndereco;

    private List<Comodo> comodos;

    private List<Comodo> comodosSelecionados;

    @PostConstruct
    private void init() {
        comodos = new ArrayList<Comodo>();
        padraoProjeto = "Basico";
        filterComodosList(getPadraoProjeto());
        comodosSelecionados = new ArrayList<Comodo>();
        System.err.println(comodos.size());
        this.endereco = new Endereco();
        this.cliente = new Cliente();
        projeto = new Projeto();
    }

    public void filterComodosList(String mPadraoProjeto) {
        if (("Normal").equalsIgnoreCase(mPadraoProjeto)) {
            comodos = comodoService.getAllComodosByPadrao(mPadraoProjeto);
        } else if (("Basico").equalsIgnoreCase(mPadraoProjeto)) {
            comodos = comodoService.getAllComodosByPadrao(mPadraoProjeto);
        }
    }

    public void viewConfirmationProject() {
        RequestContext.getCurrentInstance().openDialog("confirmModal");
    }

    public int getCalcM2() {
        int result = 0;
        projeto.getTerreno().setFrente(getFrente());
        projeto.getTerreno().setLateral(getLateral());
        projeto.setQtdPavimentos(getPavimentos());
        result = (getLateral() * getFrente()) * getPavimentos();
        projeto.getTerreno().setTotal(result);
        return result;
    }

    public void calcularAreaTotalDoProjeto() {
        int total = 0;
        for (Comodo com : comodosSelecionados) {
            total += com.getTamMedio();
        }
        projeto.setTamanhoTotal(total);
    }

    public void copiarEnderecoCliente() {
        if (!copiarEndereco) {
            projeto.setEndereco(cliente.getEndereco());
        } else {
            projeto.setEndereco(new Endereco());
        }

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

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public boolean isCopiarEndereco() {
        return copiarEndereco;
    }

    public void setCopiarEndereco(boolean copiarEndereco) {
        this.copiarEndereco = copiarEndereco;
    }

    public Comodo getSelectedComodo() {
        return selectedComodo;
    }

    public void setSelectedComodo(Comodo selectedComodo) {
        this.selectedComodo = selectedComodo;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }

    public List<Comodo> getComodosSelecionados() {
        return comodosSelecionados;
    }

    public void setComodosSelecionados(List<Comodo> comodosSelecionados) {
        this.comodosSelecionados = comodosSelecionados;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public String getPadraoProjeto() {
        return padraoProjeto;
    }

    public void setPadraoProjeto(String padraoProjeto) {
        filterComodosList(padraoProjeto);
        this.padraoProjeto = padraoProjeto;
    }
}

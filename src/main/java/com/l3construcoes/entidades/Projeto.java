/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author paulolira
 */
@Document(collection = "projetos")
public class Projeto implements  Serializable{
    
    @Id
    private String id;
    
    private String tipo;
    
    private BigDecimal custo;
    
    private Date dataContrato;
    
    private Endereco endereco;
    
    private Cliente cliente;
    
    private List<Servico> servicos;
    
    private List<Comodo> comodos;
    
    private Terreno terreno;

    private int tamanhoTotal;
    
    private int qtdPavimentos;
    
    public Projeto() {
        endereco = new Endereco();
        servicos = new ArrayList<Servico>();
        comodos = new ArrayList<Comodo>();
        terreno = new Terreno();
    }
  
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }


    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTamanhoTotal() {
        return tamanhoTotal;
    }

    public void setTamanhoTotal(int tamanhoTotal) {
        this.tamanhoTotal = tamanhoTotal;
    }

    public int getQtdPavimentos() {
        System.err.println("Get");
        return qtdPavimentos;
    }

    public void setQtdPavimentos(int qtdPavimentos) {
        System.err.println("Set:: " + qtdPavimentos );
        this.qtdPavimentos = qtdPavimentos;
    }

}

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
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author paulolira
 */
@Data
@Document(collection = "projetos")
public class Projeto implements  Serializable{
    
    @Id
    private String id;
    
    private String idCliente;
    
    private String tipo;
    
    private BigDecimal custo;
    
    private Date dataCadastro;
    
    private Date dataContrato;
    
    private Endereco endereco;
    
    private List<Servico> servicos;
    
    private List<Comodo> comodos;
    
    private Terreno terreno;
    
    private EstatusProjeto estatus = EstatusProjeto.NOVO;

    private int tamanhoTotal;
    
    private int qtdPavimentos;
    
    public Projeto() {
        qtdPavimentos = 1;
        endereco = new Endereco();
        servicos = new ArrayList<Servico>();
        comodos = new ArrayList<Comodo>();
        terreno = new Terreno();
    }
    
    
    
  
    



public enum EstatusProjeto {
   
    NOVO("Novo"),
    INICIADO("Iniciado"),
    TERMINADO("Terminado");
    
    private String text;

        private EstatusProjeto(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
}
}

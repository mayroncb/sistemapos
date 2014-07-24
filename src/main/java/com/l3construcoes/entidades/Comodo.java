/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.entidades;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author paulolira
 */
@Document(collection = "comodos")
public class Comodo implements Serializable{
    
    @Id
    private String id;
    
    private String descricao;
    
    private int tamMedio;
    
    private String padrao;
    
    private int quantidade;

    public String getPadrao() {
        return padrao;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

    public int getTamMedio() {
        return tamMedio;
    }

    public void setTamMedio(int tamMedio) {
        this.tamMedio = tamMedio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + this.tamMedio;
        hash = 23 * hash + Objects.hashCode(this.padrao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comodo other = (Comodo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.tamMedio != other.tamMedio) {
            return false;
        }
        if (!Objects.equals(this.padrao, other.padrao)) {
            return false;
        }
        return true;
    }

    

}

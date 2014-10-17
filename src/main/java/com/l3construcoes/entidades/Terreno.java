/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.entidades;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author paulolira
 */
@Document(collection = "terrenos")
public class Terreno implements Serializable{
    
    @Id
    private String id;
    
    private double lateral ;
    
    private double frente;
    
    private double total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLateral() {
        return lateral;
    }

    public void setLateral(double lateral) {
         
        this.lateral =  lateral;
    }

    public double getFrente() {
        return frente;
    }

    public void setFrente(double frente) {
        
        this.frente = frente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
         
        this.total = total;
    }
    
}

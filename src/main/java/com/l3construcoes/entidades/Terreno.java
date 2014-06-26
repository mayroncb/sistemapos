/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.entidades;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

/**
 *
 * @author paulolira
 */
public class Terreno implements Serializable{
    
    @Id
    private String id;
    
    private int lateral;
    
    private int frente;
    
    private int total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLateral() {
        return lateral;
    }

    public void setLateral(int lateral) {
        this.lateral = lateral;
    }

    public int getFrente() {
        return frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.enums;

/**
 *
 * @author paulolira
 */
public enum TipoProjetoEnum {
    
    BASICO(1),NORMAL(2);
    
    private int tipo;

    TipoProjetoEnum(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
        
}

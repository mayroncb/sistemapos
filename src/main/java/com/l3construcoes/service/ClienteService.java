/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.service;

import com.l3construcoes.entidades.Cliente;
import java.util.List;

/**
 *
 * @author paulolira
 */
public interface ClienteService {
    
    void save(Cliente c);
    void remove(Cliente c);
    List<Cliente> findAll();
    void editar(Cliente c);
    Cliente findById(String id);
    
}

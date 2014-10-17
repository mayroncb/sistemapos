/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.DAO;

import com.l3construcoes.entidades.Cliente;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author paulolira
 */
public interface ClienteDao extends CrudRepository<Cliente, Serializable>{
    
    @Override
    List<Cliente> findAll();
    
    Cliente findById(String id);
    
    void editar(Cliente c);
    
}

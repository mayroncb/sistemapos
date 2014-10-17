/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.service;

import com.l3construcoes.DAO.ClienteDao;
import com.l3construcoes.DAO.ClienteDaoImpl;
import com.l3construcoes.entidades.Cliente;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author paulolira
 */
@Service
public class ClienteServiceImpl implements ClienteService, Serializable{

    ClienteDao dao = new ClienteDaoImpl();
   
    @Override
    public void save(Cliente c) {
        dao.save(c);
    }  

    @Override
    public List<Cliente> findAll() {
        return dao.findAll();
    }

    @Override
    public void remove(Cliente c) {
        dao.delete(c.getId());
    }

    @Override
    public void editar(Cliente c) {
        dao.editar(c);
    }

    @Override
    public Cliente findById(String id) {
       return dao.findById(id);
    }
    
    
    
}

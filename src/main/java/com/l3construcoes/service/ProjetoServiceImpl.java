/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.service;

import com.l3construcoes.DAO.ProjetoDao;
import com.l3construcoes.DAO.ProjetoDaoImpl;
import com.l3construcoes.entidades.Cliente;
import com.l3construcoes.entidades.Projeto;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author paulolira
 */
@Service("projetoService")
@Transactional(readOnly = false)
public class ProjetoServiceImpl implements ProjetoService, Serializable{

    ProjetoDao dao = new ProjetoDaoImpl();
    
    @Override
    public void salvar(Projeto projeto) {
        dao.salvar(projeto);
    }

    @Override
    public List<Projeto> getProjects() {
        return dao.getAllProjects();
    }

    @Override
    public List<Projeto> getProjetosPorCliente(Cliente c) {
       return dao.getProjetosPorCliente(c);
    }

    @Override
    public void alterar(Projeto projeto) {
        dao.alterar(projeto);
    }

    @Override
    public Projeto findById(String id) {
        return dao.findById(id);
    }

    @Override
    public void remover(Projeto projeto) {
         dao.remover(projeto);
    }
    
}

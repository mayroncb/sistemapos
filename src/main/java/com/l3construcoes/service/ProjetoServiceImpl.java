/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.service;

import com.l3construcoes.DAO.ProjetoDao;
import com.l3construcoes.DAO.ProjetoDaoImpl;
import com.l3construcoes.entidades.Projeto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author paulolira
 */
@Service("projetoService")
@Transactional(readOnly = false)
public class ProjetoServiceImpl implements ProjetoService{

    ProjetoDao dao = new ProjetoDaoImpl();
    
    @Override
    public void salvar(Projeto projeto) {
        dao.salvar(projeto);
    }
    
}

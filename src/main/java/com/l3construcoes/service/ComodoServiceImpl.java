/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.service;

import com.l3construcoes.DAO.ComodoDao;
import com.l3construcoes.DAO.ComodoDaoImp;
import com.l3construcoes.entidades.Comodo;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author paulolira
 */
@Service("comodoService")
@Transactional(readOnly = false)
public class ComodoServiceImpl implements ComodoService, Serializable{


    ComodoDao comodoDao = new ComodoDaoImp();
    
    @Override
    public List<Comodo> getAllComodos() {
        return comodoDao.getAllComodos();
    }

    @Override
    public List<Comodo> getAllComodosByPadrao(String padrao) {
        return comodoDao.getAllComodosByPadrao(padrao);
    }

    @Override
    public void alterarComodo(Comodo c) {
        comodoDao.alterarComodo(c);
    }

    @Override
    public void removeComodo(Comodo c) {
        comodoDao.removeComodo(c);
    }

    @Override
    public void addComodo(Comodo c) {
        comodoDao.addComodo(c);
    }
}

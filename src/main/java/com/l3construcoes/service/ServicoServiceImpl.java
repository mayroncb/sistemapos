/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.service;

import com.l3construcoes.DAO.ServicoDao;
import com.l3construcoes.DAO.ServicoDaoImpl;
import com.l3construcoes.entidades.Servico;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author paulolira
 */
@Service("servicoService")
@Transactional(readOnly = false)
public class ServicoServiceImpl implements ServicoService, Serializable {

    ServicoDao dao = new ServicoDaoImpl();
    
    @Override
    public List<Servico> getAllServicos() {
        return dao.getAllServicos();
    }

    @Override
    public List<Servico> getAllServicosPorTipo(String tipo) {
        System.err.println(">>>> "+dao.getAllServicosPorTipo(tipo).size());
        return  dao.getAllServicosPorTipo(tipo);
    }
    
}

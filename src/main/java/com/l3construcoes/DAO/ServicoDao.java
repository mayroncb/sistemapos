/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.DAO;

import com.l3construcoes.entidades.Comodo;
import com.l3construcoes.entidades.Servico;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author paulolira
 */
public interface ServicoDao extends CrudRepository<Servico, Serializable>{
    
    List<Servico> getAllServicos();
    List<Servico> getAllServicosPorTipo(String tipo);
    
    
}

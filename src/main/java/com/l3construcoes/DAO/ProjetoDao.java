/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.DAO;

import com.l3construcoes.entidades.Projeto;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author paulolira
 */
public interface ProjetoDao extends CrudRepository<Projeto, Serializable>{
    
    void salvar(Projeto projeto);
    
}

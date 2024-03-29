/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.DAO;

import com.l3construcoes.entidades.Cliente;
import com.l3construcoes.entidades.Projeto;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author paulolira
 */
public interface ProjetoDao extends CrudRepository<Projeto, Serializable>{
    
    Projeto findById(String id);
    void salvar(Projeto projeto);
    void remover(Projeto projeto);
    void alterar(Projeto projeto);
    List<Projeto> getAllProjects();
    List<Projeto> getProjetosPorCliente(Cliente c);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.service;

import com.l3construcoes.entidades.Cliente;
import com.l3construcoes.entidades.Projeto;
import java.util.List;

/**
 *
 * @author paulolira
 */
public interface ProjetoService {
    
    void salvar(Projeto projeto);
    void alterar(Projeto projeto);
    void remover(Projeto projeto);
    Projeto findById(String id);
    List<Projeto> getProjects();
    List<Projeto> getProjetosPorCliente(Cliente c);
    
    
}

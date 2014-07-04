/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.service;

import com.l3construcoes.entidades.Projeto;
import java.util.List;

/**
 *
 * @author paulolira
 */
public interface ProjetoService {
    
    void salvar(Projeto projeto);
    List<Projeto> getProjects();
    
}

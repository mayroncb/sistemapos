/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.service;

import com.l3construcoes.entidades.Servico;
import java.util.List;

/**
 *
 * @author paulolira
 */
public interface ServicoService {
    
    Servico getServico(String descricao);
    void addServico(Servico servico);
    void removeServico(Servico servico);
    void alterarServico(Servico servico);
    List<Servico> getAllServicos();
    List<Servico> getAllServicosPorTipo(String tipo);
    
}

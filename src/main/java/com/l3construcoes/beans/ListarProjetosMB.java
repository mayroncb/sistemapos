/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.l3construcoes.beans;

import com.l3construcoes.entidades.Projeto;
import com.l3construcoes.service.ProjetoService;
import com.l3construcoes.service.ProjetoServiceImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.stereotype.Component;

/**
 *
 * @author paulolira
 */
/**
 *
 * @author paulolira
 */
@ManagedBean(name = "listarProjetosMB")
@SessionScoped
@Component
public class ListarProjetosMB {
    
    private ProjetoService service; 
    
    private String qtdProjetos;
    
    @PostConstruct
    public void init(){
       service = new ProjetoServiceImpl();
    }
    
    public List<Projeto> getAllProjects(){
        return service.getProjects();
    }

    public String getQtdProjetos() {
        qtdProjetos = String.valueOf(getAllProjects().size());
        return qtdProjetos;
    }    
}

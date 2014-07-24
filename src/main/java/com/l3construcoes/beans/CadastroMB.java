/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3construcoes.beans;

import com.l3construcoes.entidades.Cliente;
import com.l3construcoes.entidades.Comodo;
import com.l3construcoes.entidades.Endereco;
import com.l3construcoes.entidades.Projeto;
import com.l3construcoes.entidades.Servico;
import com.l3construcoes.service.ComodoService;
import com.l3construcoes.service.ComodoServiceImpl;
import com.l3construcoes.service.ProjetoService;
import com.l3construcoes.service.ProjetoServiceImpl;
import com.l3construcoes.service.ServicoService;
import com.l3construcoes.service.ServicoServiceImpl;
import com.l3construcoes.util.CalcUtils;
import com.l3construcoes.util.Navigation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author paulolira
 */
@ManagedBean(name = "cadastroMB")
@SessionScoped
@Component
public class CadastroMB {

    private boolean skip;

    private Cliente cliente;

    private Endereco enderecoObra;

    private Projeto projeto;

    private Comodo selectedComodo = new Comodo();

    private boolean copiarEndereco;

    private List<Comodo> comodos;

    private List<Comodo> comodosSelecionados;

    private List<Servico> servicosProjetos;

    private List<Servico> servicosServicos;

    private List<Servico> servicosOutros;

    private List<Servico> selectedServicosProjetos;

    private List<Servico> selectedServicosServicos;

    private List<Servico> selectedServicosOutros;

    private ComodoService comodoService;

    private ServicoService servicoService;

    private ProjetoService projetoService;
    
    private Comodo comodoEmSelecionados;

    @PostConstruct
    private void init() {
        servicoService = new ServicoServiceImpl();
        comodoService = new ComodoServiceImpl();
        projetoService = new ProjetoServiceImpl();
        comodosSelecionados = new ArrayList<Comodo>();
        selectedServicosProjetos = new ArrayList<Servico>();
        selectedServicosServicos = new ArrayList<Servico>();
        selectedServicosOutros = new ArrayList<Servico>();
        comodos = new ArrayList<Comodo>();
        projeto = new Projeto();

        servicosProjetos = servicoService.getAllServicosPorTipo("Projeto");
        servicosOutros = servicoService.getAllServicosPorTipo("Outros");
        servicosServicos = servicoService.getAllServicosPorTipo("Servico");

        projeto.setTipo("Basico");
        filterComodosList();

        this.cliente = new Cliente();

    }

    public void filterComodosList() {
        if (("Normal").equalsIgnoreCase(projeto.getTipo())) {
            comodos = comodoService.getAllComodosByPadrao(projeto.getTipo());
        } else if (("Basico").equalsIgnoreCase(projeto.getTipo())) {
            comodos = comodoService.getAllComodosByPadrao(projeto.getTipo());
        }
    }

    public void viewConfirmationProject() {
        List<Servico> allServicos = new ArrayList<Servico>();
        allServicos.addAll(selectedServicosOutros);
        allServicos.addAll(selectedServicosProjetos);
        allServicos.addAll(selectedServicosServicos);
        projeto.setServicos(allServicos);
        
        BigDecimal custo = new BigDecimal(0);
        BigDecimal valuesServices = new BigDecimal(BigInteger.ONE);
        valuesServices = CalcUtils.loadAllValuesByService(projeto.getServicos());
        int tamanhoTotal = CalcUtils.loadAllSizeByRoom(comodosSelecionados);
        

        projeto.setComodos(comodosSelecionados);
        projeto.setTamanhoTotal(tamanhoTotal);
        if (projeto.getQtdPavimentos() > 1) {
            custo = CalcUtils.calcValueOfTheProject(projeto.getQtdPavimentos(),
                    valuesServices, tamanhoTotal);
        } else {
            custo = CalcUtils.calcValueOfTheProject(valuesServices, tamanhoTotal);
        }
        projeto.setCusto(custo);
        projeto.setCliente(cliente);
    }

    public void salvar() {
        projetoService.salvar(projeto);
        addNotificacao("Adicionado com Sucesso!!!", "Sucesso");
        RequestContext.getCurrentInstance().closeDialog("confirmModal");

    }

    public int getCalcM2() {
        int result = 0;
        result = (projeto.getTerreno().getLateral() * projeto.getTerreno().getFrente());
        projeto.getTerreno().setTotal(result);
        return result;
    }

    public void copiarEnderecoCliente() {
        if (!copiarEndereco) {
            projeto.setEndereco(cliente.getEndereco());
        } else {
            projeto.setEndereco(new Endereco());
        }
    }

    public void addComodoEmComodosSelecionados() {
        if (selectedComodo != null) {
            addNotificacao(selectedComodo.getDescricao(), "Adicionado: ");
            comodosSelecionados.add(selectedComodo);
            RequestContext.getCurrentInstance().update("form:comodosSelecionados");
        }
    }

    public void addNotificacao(String message, String tipo) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, tipo, message));
        RequestContext.getCurrentInstance().update("growl");
    }

    public void removeComodoEmComodosSelecionados(Comodo c) {
        if (c != null) {
            comodosSelecionados.remove(c);
            RequestContext.getCurrentInstance().update("form:comodosSelecionados");
            addNotificacao(c.getDescricao(), "Removido: ");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Endereco getEnderecoObra() {
        return enderecoObra;
    }

    public void setEnderecoObra(Endereco enderecoObra) {
        this.enderecoObra = enderecoObra;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public boolean isCopiarEndereco() {
        return copiarEndereco;
    }

    public void setCopiarEndereco(boolean copiarEndereco) {
        this.copiarEndereco = copiarEndereco;
    }

    public Comodo getSelectedComodo() {
        return selectedComodo;
    }

    public void setSelectedComodo(Comodo selectedComodo) {
        this.selectedComodo = selectedComodo;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }

    public List<Comodo> getComodosSelecionados() {
        return comodosSelecionados;
    }

    public void setComodosSelecionados(List<Comodo> comodosSelecionados) {
        this.comodosSelecionados = comodosSelecionados;
    }

    public String onFlowProcess(FlowEvent event) {
        System.err.print(event.getOldStep().toString());
        if (skip) {
            skip = false;
            return "confirm";
        } else {

            if (event.getNewStep().toString().contains("servicos")) {
                addNotificacao(String.valueOf(getCalcM2()), "Tamanho do terreno: ");
            } else if (event.getOldStep().toString().contains("servicos")) {
                viewConfirmationProject();
            }
            return event.getNewStep();
        }
    }

    public List<Servico> getServicosProjetos() {
        return servicosProjetos;
    }

    public void setServicosProjetos(List<Servico> servicosProjetos) {
        this.servicosProjetos = servicosProjetos;
    }

    public List<Servico> getServicosServicos() {
        return servicosServicos;
    }

    public void setServicosServicos(List<Servico> servicosServicos) {
        this.servicosServicos = servicosServicos;
    }

    public List<Servico> getServicosOutros() {
        return servicosOutros;
    }

    public void setServicosOutros(List<Servico> servicosOutros) {
        this.servicosOutros = servicosOutros;
    }

    public List<Servico> getSelectedServicosProjetos() {
        return selectedServicosProjetos;
    }

    public void setSelectedServicosProjetos(List<Servico> selectedServicosProjetos) {
        this.selectedServicosProjetos = selectedServicosProjetos;
    }

    public List<Servico> getSelectedServicosServicos() {
        return selectedServicosServicos;
    }

    public void setSelectedServicosServicos(List<Servico> selectedServicosServicos) {
        this.selectedServicosServicos = selectedServicosServicos;
    }

    public List<Servico> getSelectedServicosOutros() {
        return selectedServicosOutros;
    }

    public void setSelectedServicosOutros(List<Servico> selectedServicosOutros) {
        this.selectedServicosOutros = selectedServicosOutros;
    }

    public Comodo getComodoEmSelecionados() {
         return comodoEmSelecionados;
    }

    public void setComodoEmSelecionados(Comodo comodoEmSelecionados) {
        this.comodoEmSelecionados = comodoEmSelecionados;
    }
    
    

}

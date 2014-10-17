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
import com.l3construcoes.service.ClienteService;
import com.l3construcoes.service.ClienteServiceImpl;
import com.l3construcoes.service.ComodoService;
import com.l3construcoes.service.ComodoServiceImpl;
import com.l3construcoes.service.ProjetoService;
import com.l3construcoes.service.ProjetoServiceImpl;
import com.l3construcoes.service.ServicoService;
import com.l3construcoes.service.ServicoServiceImpl;
import com.l3construcoes.util.CalcUtils;
import com.l3construcoes.util.Constants;
import com.l3construcoes.util.SistemaUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author paulolira
 */
@ManagedBean(name = "cadastroMB")
@ViewScoped
@Component
public class CadastroMB implements Serializable{

    private boolean skip;
    
    private List<Cliente> clientes;
    
    private Cliente selectedCliente;
    
    private Cliente cliente;
    
    private ClienteService clienteService;

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
    
    private Projeto projetoSelected;

    @PostConstruct
    private void init() {
        selectedCliente = new Cliente();
        servicoService = new ServicoServiceImpl();
        comodoService = new ComodoServiceImpl();
        projetoService = new ProjetoServiceImpl();
        clienteService = new ClienteServiceImpl();
        comodosSelecionados = new ArrayList<Comodo>();
        selectedServicosProjetos = new ArrayList<Servico>();
        selectedServicosServicos = new ArrayList<Servico>();
        selectedServicosOutros = new ArrayList<Servico>();
        comodos = new ArrayList<Comodo>();
        projeto = new Projeto();
        servicosProjetos = servicoService.getAllServicosPorTipo("Projeto");
        servicosOutros = servicoService.getAllServicosPorTipo("Outros");
        servicosServicos = servicoService.getAllServicosPorTipo("Servico");
        clientes = clienteService.findAll();
        projeto.setTipo("Basico");
        this.cliente = new Cliente();
        if (FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().containsKey("editProjectId")) {
            String id = (String) FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().get("editProjectId");
            projeto = projetoService.findById(id);
            cliente = clienteService.findById(projeto.getIdCliente());
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().remove("editProjectId");
            for (Servico serv: projeto.getServicos()) {
                if (serv.getTipo().equalsIgnoreCase("Outros")) {
                    selectedServicosOutros.add(serv);
                } 
                if (serv.getTipo().equalsIgnoreCase("Projeto")) {
                   selectedServicosProjetos.add(serv);
                } 
                if (serv.getTipo().equalsIgnoreCase("Servico")) {
                    selectedServicosServicos.add(serv);
                }
            }
            comodosSelecionados = projeto.getComodos();
        } 
        filterComodosList();


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
        projeto.setIdCliente(cliente.getId());
    }
    
    public double somarServicoes(){
        double result = 0;
        double outrosCalc = selectedServicosOutros.stream().mapToDouble(s -> s.getValor().doubleValue()).sum();
        double projetosCalc = selectedServicosProjetos.stream().mapToDouble(s -> s.getValor().doubleValue()).sum();
        double servicosCal = selectedServicosServicos.stream().mapToDouble(s -> s.getValor().doubleValue()).sum();   
        result = outrosCalc + projetosCalc + servicosCal;
        return result;
    }

    public String salvar() {
        projeto.setDataCadastro(new Date(System.currentTimeMillis()));
        projeto.setEstatus(Projeto.EstatusProjeto.NOVO);
        projetoService.salvar(projeto);
        addNotificacao("Adicionado com Sucesso!!!", "Sucesso");
        return Constants.LINK_DASHBOARD;
    }

    public double getCalcM2() {
        double result = 0;
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
    
    public String irListarProjetos(){
        return Constants.LINK_LISTAR_PROJETOS;
    }
    
    public String  alterarProjeto(){
        projetoService.alterar(projeto);
        SistemaUtil.addNotificacao(FacesMessage.SEVERITY_INFO , "Alterado com Sucesso", "Projeto");
        return  Constants.LINK_LISTAR_PROJETOS;
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
        System.out.println(event.getOldStep());
        
        if (event.getOldStep().equals("servicos")) {
            viewConfirmationProject();
        }    
        return event.getNewStep();
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

    public List<Cliente> getClientes() {
        return clienteService.findAll();
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public Projeto getProjetoSelected() {
        return projetoSelected;
    }

    public void setProjetoSelected(Projeto projetoSelected) {
        this.projetoSelected = projetoSelected;
    }

    
    
}

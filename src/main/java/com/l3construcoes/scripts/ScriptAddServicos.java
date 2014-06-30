package com.l3construcoes.scripts;

import com.l3construcoes.entidades.Comodo;
import com.l3construcoes.entidades.Servico;
import com.l3construcoes.util.SpringMongoConfig;
import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paulolira
 */
public class ScriptAddServicos {

    public static void main(String[] args) {

        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

        Servico arquitetonico = new Servico();
        arquitetonico.setCodigo("0001");
        arquitetonico.setTipo("Projeto");
        arquitetonico.setDescricao("Arquitetônico");
        arquitetonico.setValor(new BigDecimal(20));

        mongoOperation.save(arquitetonico);

        Servico ambientacao = new Servico();
        ambientacao.setCodigo("0002");
        ambientacao.setTipo("Projeto");
        ambientacao.setDescricao("Ambientação Residencial");
        ambientacao.setValor(new BigDecimal(60));

        mongoOperation.save(ambientacao);

        Servico ambientacaoCom = new Servico();
        ambientacaoCom.setCodigo("0003");
        ambientacaoCom.setTipo("Projeto");
        ambientacaoCom.setDescricao("Ambientação Comercial");
        ambientacaoCom.setValor(new BigDecimal(120));

        mongoOperation.save(ambientacaoCom);

        Servico eletrico = new Servico();
        eletrico.setCodigo("0004");
        eletrico.setTipo("Projeto");
        eletrico.setDescricao("Eletrico");
        eletrico.setValor(new BigDecimal(5));

        mongoOperation.save(eletrico);

        Servico hidraulico = new Servico();
        hidraulico.setCodigo("0005");
        hidraulico.setTipo("Projeto");
        hidraulico.setDescricao("Hidráulico");
        hidraulico.setValor(new BigDecimal(5));

        mongoOperation.save(hidraulico);

        Servico estrutural = new Servico();
        estrutural.setCodigo("0006");
        estrutural.setTipo("Projeto");
        estrutural.setDescricao("Estrutural");
        estrutural.setValor(new BigDecimal(5));

        mongoOperation.save(estrutural);

        Servico avaliacao = new Servico();
        avaliacao.setCodigo("0007");
        avaliacao.setTipo("Servico");
        avaliacao.setDescricao("Avaliacao");
        avaliacao.setValor(new BigDecimal(5));

        mongoOperation.save(avaliacao);

        Servico orcamento = new Servico();
        orcamento.setCodigo("0008");
        orcamento.setTipo("Servico");
        orcamento.setDescricao("Orçamento");
        orcamento.setValor(new BigDecimal(5));

        mongoOperation.save(orcamento);

        Servico documentacao = new Servico();
        documentacao.setCodigo("0009");
        documentacao.setTipo("Servico");
        documentacao.setDescricao("Documentação");
        documentacao.setValor(new BigDecimal(5));
        
        Servico acompanhamento = new Servico();
        acompanhamento.setCodigo("0010");
        acompanhamento.setTipo("Servico");
        acompanhamento.setDescricao("Acompanhamento");
        acompanhamento.setValor(new BigDecimal(1000));

        mongoOperation.save(acompanhamento);
        
        Servico laudo = new Servico();
        laudo.setCodigo("0011");
        laudo.setTipo("Servico");
        laudo.setDescricao("Laudo");
        laudo.setValor(new BigDecimal(1000));

        mongoOperation.save(laudo);
        
        Servico rt = new Servico();
        rt.setCodigo("0012");
        rt.setTipo("Outros");
        rt.setDescricao("RT");
        rt.setValor(new BigDecimal(500));

        mongoOperation.save(rt);
        
        Servico bancoCx = new Servico();
        bancoCx.setCodigo("0013");
        bancoCx.setTipo("Outros");
        bancoCx.setDescricao("Caixa Econômica");
        bancoCx.setValor(new BigDecimal(35));

        mongoOperation.save(bancoCx);
        
        Servico bb = new Servico();
        bb.setCodigo("0014");
        bb.setTipo("Outros");
        bb.setDescricao("Banco do Brasil");
        bb.setValor(new BigDecimal(35));

        mongoOperation.save(bb);
        
        Servico bn = new Servico();
        bn.setCodigo("0015");
        bn.setTipo("Outros");
        bn.setDescricao("Banco do Nordeste");
        bn.setValor(new BigDecimal(35));

        mongoOperation.save(bn);

    }

}

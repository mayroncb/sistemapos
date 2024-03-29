/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3construcoes.DAO;

import com.l3construcoes.entidades.Servico;
import java.io.Serializable;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulolira
 */
@Repository("servicoDao")
public class ServicoDaoImpl implements ServicoDao, Serializable {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");


    @Override
    public List<Servico> getAllServicos() {
        return mongoOperation.findAll(Servico.class);
    }

    @Override
    public List<Servico> getAllServicosPorTipo(String tipo) {
        return mongoOperation.find(new Query(Criteria.where("tipo").in(tipo)), Servico.class);
    }

    @Override
    public <S extends Servico> S save(S s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Servico> Iterable<S> save(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servico findOne(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Servico> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Servico> findAll(Iterable<Serializable> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Servico t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iterable<? extends Servico> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servico getServico(String descricao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addServico(Servico servico) {
        mongoOperation.save(servico);
    }

    @Override
    public void removeServico(Servico servico) {
        Query qRemove = new Query();
        qRemove.addCriteria(Criteria.where("id").is(servico.getId()));
        mongoOperation.remove(qRemove, Servico.class);
    }

    @Override
    public void alterarServico(Servico servico) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(servico.getId()));
        Servico upServico = mongoOperation.findOne(query, Servico.class);
        upServico.setDescricao(servico.getDescricao());
        upServico.setTipo(servico.getTipo());
        upServico.setValor(servico.getValor());
        mongoOperation.save(upServico);
    }

    public MongoOperations getMongoOperation() {
        return mongoOperation;
    }

    public void setMongoOperation(MongoOperations mongoOperation) {
        this.mongoOperation = mongoOperation;
    }
    
    

}

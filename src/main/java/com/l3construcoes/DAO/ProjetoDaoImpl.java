/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3construcoes.DAO;

import com.l3construcoes.entidades.Cliente;
import com.l3construcoes.entidades.Projeto;
import com.l3construcoes.util.SpringMongoConfig;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulolira
 */
@Repository("projetoDao")
public class ProjetoDaoImpl implements ProjetoDao, Serializable {

 ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    @Override
    public void salvar(Projeto projeto) {
        mongoOperation.save(projeto);
    }

    @Override
    public <S extends Projeto> S save(S s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Projeto> Iterable<S> save(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Projeto findOne(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Projeto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Projeto> findAll(Iterable<Serializable> itrbl) {
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
    public void delete(Projeto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iterable<? extends Projeto> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projeto> getAllProjects() {
        return mongoOperation.findAll(Projeto.class);
    }

    @Override
    public List<Projeto> getProjetosPorCliente(Cliente c) {
        Query query = new Query();
        query.addCriteria(Criteria.where("idCliente").is(c.getId()));
        List<Projeto> projetos = mongoOperation.find(query, Projeto.class);
        return projetos;
    }

    @Override
    public void alterar(Projeto projeto) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(projeto.getId()));
        Projeto projetoTmp = mongoOperation.findOne(query, Projeto.class);
        if (projetoTmp != null) {
            projeto.setIdCliente(projetoTmp.getIdCliente());
        }
        mongoOperation.save(projeto);
    }

    @Override
    public Projeto findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Projeto projetoTmp = mongoOperation.findOne(query, Projeto.class);
        return projetoTmp;
    }

    public MongoOperations getMongoOperation() {
        return mongoOperation;
    }

    public void setMongoOperation(MongoOperations mongoOperation) {
        this.mongoOperation = mongoOperation;
    }

    @Override
    public void remover(Projeto projeto) {
        Query qRemove = new Query();
        qRemove.addCriteria(Criteria.where("id").is(projeto.getId()));
        mongoOperation.remove(qRemove, Projeto.class);
    }

}

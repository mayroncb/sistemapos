/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3construcoes.DAO;

import com.l3construcoes.entidades.Comodo;
import com.l3construcoes.util.SpringMongoConfig;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulolira
 */
@Repository("comodoDao")
public class ComodoDaoImp implements ComodoDao, Serializable {

 ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");


    public ComodoDaoImp() {
        super();
    }

    @Override
    public List<Comodo> getAllComodos() {
        return mongoOperation.findAll(Comodo.class);
    }

    @Override
    public Comodo getComodo(String descricao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addComodo(Comodo comodo) {
        mongoOperation.save(comodo);
    }

    @Override
    public <S extends Comodo> S save(S s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Comodo> Iterable<S> save(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comodo findOne(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Comodo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Comodo> findAll(Iterable<Serializable> itrbl) {
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
    public void delete(Comodo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iterable<? extends Comodo> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comodo> getAllComodosByPadrao(String padrao) {
        Query queryByPadrao = new Query();
        queryByPadrao.addCriteria(Criteria.where("padrao").in(padrao));
        return mongoOperation.find(queryByPadrao, Comodo.class);
    }

    @Override
    public void alterarComodo(Comodo c) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(c.getId()));
        Comodo upComodo = mongoOperation.findOne(query, Comodo.class);
        upComodo.setDescricao(c.getDescricao());
        upComodo.setTamMedio(c.getTamMedio());
        upComodo.setPadrao(c.getPadrao());
        mongoOperation.save(upComodo);
    }

    @Override
    public void removeComodo(Comodo c) {
        Query qRemove = new Query();
        qRemove.addCriteria(Criteria.where("id").is(c.getId()));
        mongoOperation.remove(qRemove, Comodo.class);
    }

    public MongoOperations getMongoOperation() {
        return mongoOperation;
    }

    public void setMongoOperation(MongoOperations mongoOperation) {
        this.mongoOperation = mongoOperation;
    }
    
    

}

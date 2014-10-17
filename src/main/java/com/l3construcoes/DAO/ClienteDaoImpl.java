/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3construcoes.DAO;

import com.l3construcoes.entidades.Cliente;
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
@Repository
public class ClienteDaoImpl implements ClienteDao, Serializable {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    @Override
    public <S extends Cliente> S save(S entity) {
        mongoOperation.save(entity);
        return null;
    }

    @Override
    public <S extends Cliente> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findOne(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> findAll() {
        return mongoOperation.findAll(Cliente.class);
    }

    @Override
    public Iterable<Cliente> findAll(Iterable<Serializable> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Serializable id) {
        Query qRemove = new Query();
        qRemove.addCriteria(Criteria.where("id").is(id));
        mongoOperation.remove(qRemove, Cliente.class);
    }

    @Override
    public void delete(Cliente entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iterable<? extends Cliente> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Cliente c) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(c.getId()));
        Cliente cliente = mongoOperation.findOne(query, Cliente.class);
        if (cliente != null) {
            mongoOperation.save(c);
        }

    }

    @Override
    public Cliente findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Cliente c = mongoOperation.findOne(query, Cliente.class);
        return c;
    }

}

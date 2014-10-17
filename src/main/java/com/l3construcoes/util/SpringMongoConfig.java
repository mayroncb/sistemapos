/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3construcoes.util;

import com.l3construcoes.entidades.Cliente;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import java.io.Serializable;
import java.net.UnknownHostException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 *
 * @author paulolira
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.l3construcoes.DAO")
@ComponentScan("com.l3construcoes.DAO")
public class SpringMongoConfig implements Serializable {
    MongoTemplate mongoTemplate;
    SimpleMongoDbFactory fac;
    MongoClient mongo;

    public SpringMongoConfig() throws UnknownHostException {
        this.mongo = new MongoClient();
    }
    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
    //    UserCredentials user = new UserCredentials("admin", "DimnKxC7qBdV");
//        return new SimpleMongoDbFactory(
//                new MongoClient("mongodb://104.131.222.105:27017"), "sistema" );
//   return new SimpleMongoDbFactory(
//                new MongoClient(new ServerAddress("104.131.222.105", 27017)), "l3sistema" );
        
        return new SimpleMongoDbFactory(mongo, "l3sistema");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        if (mongoTemplate == null ) {
            mongoTemplate = new MongoTemplate(mongoDbFactory());
            mongoTemplate.indexOps(Cliente.class).ensureIndex(
                new Index().on("cpf", Sort.Direction.ASC).unique(Index.Duplicates.DROP));
            mongoTemplate.setWriteConcern(WriteConcern.SAFE);
        }
        
        return mongoTemplate;
    }

}

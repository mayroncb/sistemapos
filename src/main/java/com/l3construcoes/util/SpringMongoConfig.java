/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3construcoes.util;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import java.io.Serializable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 *
 * @author paulolira
 */
@Configuration
public class SpringMongoConfig implements Serializable {

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
    //    UserCredentials user = new UserCredentials("admin", "DimnKxC7qBdV");
//        return new SimpleMongoDbFactory(
//                new MongoClient("mongodb://104.131.222.105:27017"), "sistema" );
//   return new SimpleMongoDbFactory(
//                new MongoClient(new ServerAddress("104.131.222.105", 27017)), "l3sistema" );
        return new SimpleMongoDbFactory(new MongoClient(), "l3sistema");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;

    }

}

package com.l3construcoes.scripts;


import com.l3construcoes.entidades.Comodo;
import com.l3construcoes.util.SpringMongoConfig;
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
public class ScriptAddComodos {

    public static void main(String[] args) {

        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

        Comodo quarto = new Comodo();
        quarto.setTipo("Quarto");
        quarto.setDescricao("Quarto");
        quarto.setTamMedio(10);
        quarto.setPadrao("Basico");
         mongoOperation.save(quarto);

        Comodo suite = new Comodo();
        suite.setTipo("Suite");
        suite.setDescricao("Suite");
        suite.setTamMedio(12);
        suite.setPadrao("Basico");
         mongoOperation.save(suite);

        Comodo closet = new Comodo();
        closet.setTipo("Closet");
        closet.setDescricao("Closet");
        closet.setTamMedio(3);
        closet.setPadrao("Basico");
         mongoOperation.save(closet);

        Comodo salaunica = new Comodo();
        salaunica.setTipo("Sala Única");
        salaunica.setDescricao("Sala Única");
        salaunica.setTamMedio(16);
        salaunica.setPadrao("Basico");
         mongoOperation.save(salaunica);

        Comodo salaestar = new Comodo();
        salaestar.setTipo("Sala de Estar");
        salaestar.setDescricao("Sala Estar");
        salaestar.setTamMedio(10);
        salaestar.setPadrao("Basico");
         mongoOperation.save(salaestar);

        Comodo salajantar = new Comodo();
        salajantar.setTipo("Sala de Jantar");
        salajantar.setDescricao("Sala de Jantar");
        salajantar.setTamMedio(8);
        salajantar.setPadrao("Basico");
         mongoOperation.save(salajantar);

        Comodo cozinha = new Comodo();
        cozinha.setTipo("Cozinha");
        cozinha.setDescricao("Cozinha");
        cozinha.setTamMedio(6);
        cozinha.setPadrao("Basico");
         mongoOperation.save(cozinha);

        Comodo aservico = new Comodo();
        aservico.setTipo("Área de Serviço");
        aservico.setDescricao("Área de Serviço");
        aservico.setTamMedio(4);
        aservico.setPadrao("Basico");
         mongoOperation.save(aservico);

        Comodo garagemint = new Comodo();
        garagemint.setTipo("Garagem / Terraço");
        garagemint.setDescricao("Garagem / Terraço");
        garagemint.setTamMedio(18);
        garagemint.setPadrao("Basico");
         mongoOperation.save(garagemint);

        Comodo garagem = new Comodo();
        garagem.setTipo("Garage");
        garagem.setDescricao("Garagem");
        garagem.setTamMedio(15);
        garagem.setPadrao("Basico");
         mongoOperation.save(garagem);

        Comodo terraco = new Comodo();
        terraco.setTipo("Terraço");
        terraco.setDescricao("Terraço");
        terraco.setTamMedio(4);
        terraco.setPadrao("Basico");
         mongoOperation.save(terraco);

        Comodo despensa = new Comodo();
        despensa.setTipo("Despensa");
        despensa.setDescricao("Despensa");
        despensa.setTamMedio(3);
        despensa.setPadrao("Basico");
         mongoOperation.save(despensa);

        Comodo quartoNormal = new Comodo();
        quartoNormal.setTipo("Quarto");
        quartoNormal.setDescricao("Quarto");
        quartoNormal.setTamMedio(12);
        quartoNormal.setPadrao("Normal");
         mongoOperation.save(quartoNormal);

        Comodo suiteN = new Comodo();
        suiteN.setTipo("Suite");
        suiteN.setDescricao("Suite");
        suiteN.setTamMedio(14);
        suiteN.setPadrao("Normal ");
         mongoOperation.save(suiteN);

        Comodo closetN = new Comodo();
        closetN.setTipo("Closet");
        closetN.setDescricao("Closet");
        closetN.setTamMedio(5);
        closetN.setPadrao("Normal ");
         mongoOperation.save(closetN);

        Comodo salaunicaN = new Comodo();
        salaunicaN.setTipo("Sala Única");
        salaunicaN.setDescricao("Sala Única");
        salaunicaN.setTamMedio(20);
        salaunicaN.setPadrao("Normal");
         mongoOperation.save(salaunicaN);

        Comodo salaestarN = new Comodo();
        salaestarN.setTipo("Sala de Estar");
        salaestarN.setDescricao("Sala Estar");
        salaestarN.setTamMedio(12);
        salaestarN.setPadrao("Normal");
         mongoOperation.save(salaestarN);

        Comodo salajantarN = new Comodo();
        salajantarN.setTipo("Sala de Jantar");
        salajantarN.setDescricao("Sala de Jantar");
        salajantarN.setTamMedio(10);
        salajantarN.setPadrao("Normal");
         mongoOperation.save(salajantarN);

        Comodo cozinhaN = new Comodo();
        cozinhaN.setTipo("Cozinha");
        cozinhaN.setDescricao("Cozinha");
        cozinhaN.setTamMedio(8);
        cozinhaN.setPadrao("Normal");
         mongoOperation.save(cozinhaN);

        Comodo aservicoN = new Comodo();
        aservicoN.setTipo("Área de Serviço");
        aservicoN.setDescricao("Área de Serviço");
        aservicoN.setTamMedio(6);
        aservicoN.setPadrao("Normal");
         mongoOperation.save(aservicoN);

        Comodo garagemintN = new Comodo();
        garagemintN.setTipo("Garagem / Terraço");
        garagemintN.setDescricao("Garagem / Terraço");
        garagemintN.setTamMedio(20);
        garagemintN.setPadrao("Normal");
         mongoOperation.save(garagemintN);

        Comodo garagemN = new Comodo();
        garagemN.setTipo("Garage");
        garagemN.setDescricao("Garagem");
        garagemN.setTamMedio(17);
        garagemN.setPadrao("Normal");
         mongoOperation.save(garagemN);

        Comodo terracoN = new Comodo();
        terracoN.setTipo("Terraço");
        terracoN.setDescricao("Terraço");
        terracoN.setTamMedio(6);
        terracoN.setPadrao("Normal");
         mongoOperation.save(terracoN);

        Comodo despensaN = new Comodo();
        despensaN.setTipo("Despensa");
        despensaN.setDescricao("Despensa");
        despensaN.setTamMedio(5);
        despensaN.setPadrao("Normal");

        mongoOperation.save(despensaN);
    }

}

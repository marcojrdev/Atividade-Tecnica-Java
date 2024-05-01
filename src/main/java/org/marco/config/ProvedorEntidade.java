package org.marco.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@ApplicationScoped
public class ProvedorEntidade {

    private EntityManagerFactory factory;


    public ProvedorEntidade() {
        this.factory = Persistence.createEntityManagerFactory("atividadePU");
        System.out.println("-------------INVOCOU-----------");
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return this.factory.createEntityManager();
    }

    public void fechaProvedor(@Disposes EntityManager m) {
        m.close();
    }

}

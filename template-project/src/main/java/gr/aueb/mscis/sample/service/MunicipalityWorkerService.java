package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.MunicipalityWorker;
import gr.aueb.mscis.sample.persistence.JPAUtil;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MunicipalityWorkerService {

    EntityManager em;

    public MunicipalityWorkerService() {
        em = JPAUtil.getCurrentEntityManager();
    }

    public MunicipalityWorker createMunicipalityWorker(String firstName, String lastName, String registryOffice){

        if (firstName == null) {
            //TODO: create custom exception
        }
        if (lastName == null) {
            //TODO: create custom exception
        }

        MunicipalityWorker newMunWorker = new MunicipalityWorker(firstName, lastName, registryOffice);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newMunWorker);
        tx.commit();

        return newMunWorker;

    }
}

package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.MunicipalityWorker;
import gr.aueb.mscis.sample.persistence.JPAUtil;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * The type Municipality worker service.
 */
public class MunicipalityWorkerService {

    /**
     * The Em.
     */
    private EntityManager em;

    /**
     * Instantiates a new Municipality worker service.
     */
    public MunicipalityWorkerService() {
        em = JPAUtil.getCurrentEntityManager();
    }

    /**
     * Create municipality worker municipality worker.
     *
     * @param firstName      the first name
     * @param lastName       the last name
     * @param registryOffice the registry office
     * @return the municipality worker
     */
    public MunicipalityWorker createMunicipalityWorker(final String firstName,final String lastName,final String registryOffice){

//        if (firstName == null) {
//
//        }
//        if (lastName == null) {
//
//        }

        MunicipalityWorker newMunWorker = new MunicipalityWorker(firstName, lastName, registryOffice);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newMunWorker);
        tx.commit();

        return newMunWorker;
    }
}

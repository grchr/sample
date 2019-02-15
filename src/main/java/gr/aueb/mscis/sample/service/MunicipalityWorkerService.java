package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.helper.UserDataValidator;
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
    public MunicipalityWorker createMunicipalityWorker(String firstName, String lastName, String userName, String password, String phoneNumber,
                                                       String email, String vatNumber, String registryOffice){

//        if (firstName == null) {
//
//        }
//        if (lastName == null) {
//
//        }
        em = JPAUtil.getCurrentEntityManager();
        if(UserDataValidator.isValidEmailFormat(email)){
            System.out.println("VALID EMAIL FORMAT");
        } else {
            System.out.println("INVALID EMAIL FORMAT");
        }
        if(UserDataValidator.isValidPhoneNumber(phoneNumber)) {
            System.out.println("VALID PHONE NUMBER");
        } else {
            System.out.println("INVALID PHONE NUMBER");
        }
        MunicipalityWorker newMunWorker = new MunicipalityWorker(firstName, lastName, userName, password, phoneNumber, email, vatNumber, registryOffice);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newMunWorker);
        tx.commit();

        return newMunWorker;
    }

    public MunicipalityWorker updateMunicipalityWorker(String firstName, String lastName, String userName, String password, String phoneNumber,
                                                       String email, String vatNumber, String registryOffice, MunicipalityWorker municipalityWorker) {

        if (firstName != null) {
            municipalityWorker.setFistName(firstName);
        }
        if (lastName != null) {
            municipalityWorker.setLastName(lastName);
        }
        if (userName != null) {
            municipalityWorker.setUserName(userName);
        }
        if (password != null) {
            municipalityWorker.setPassword(password);
        }
        if (phoneNumber != null) {
            municipalityWorker.setPhoneNumber(phoneNumber);
        }
        if (email != null) {
            municipalityWorker.setEmail(email);
        }
        if (vatNumber != null) {
            municipalityWorker.setVatNumber(vatNumber);
        }
        if (registryOffice != null) {
            municipalityWorker.setRegistryOffice(registryOffice);
        }
        em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(municipalityWorker);
        tx.commit();

        return municipalityWorker;
    }
}

package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.enums.PrivilegeLevel;
import gr.aueb.mscis.sample.helper.UserDataValidator;
import gr.aueb.mscis.sample.model.Administrator;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AdministratorService {

    private EntityManager em;

    public AdministratorService(){
        em = JPAUtil.getCurrentEntityManager();
    }

    public Administrator createAdministrator(String firstName, String lastName, String userName, String password, String phoneNumber,
                                             String email, String vatNumber, PrivilegeLevel privilegeLevel){

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
        Administrator newAdmin = new Administrator(firstName, lastName, userName, password, phoneNumber,
                email, vatNumber, privilegeLevel);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newAdmin);
        tx.commit();

        return newAdmin;
    }
}

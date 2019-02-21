package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.dao.AdministratorDao;
import gr.aueb.mscis.sample.enums.PrivilegeLevel;
import gr.aueb.mscis.sample.helper.UserDataValidator;
import gr.aueb.mscis.sample.model.Administrator;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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

    public Administrator updateAdministrator(String firstName, String lastName, String userName, String password, String phoneNumber,
                                             String email, String vatNumber, PrivilegeLevel privilegeLevel, Administrator administrator) {
        if (firstName != null) {
            administrator.setFistName(firstName);
        }
        if (lastName != null) {
            administrator.setLastName(lastName);
        }
        if (userName != null) {
            administrator.setUserName(userName);
        }
        if (password != null) {
            administrator.setPassword(password);
        }
        if (phoneNumber != null) {
            administrator.setPhoneNumber(phoneNumber);
        }
        if (email != null) {
            administrator.setEmail(email);
        }
        if (vatNumber != null) {
            administrator.setVatNumber(vatNumber);
        }
        if (privilegeLevel != null) {
            administrator.setPrivilege(privilegeLevel);
        }

        em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(administrator);
        tx.commit();

        return administrator;
    }

    public Administrator findAdminByUsername(String username) {
        AdministratorDao administratorDao = new AdministratorDao();
        List<Administrator> foundAdmins = administratorDao.findByUserName(username);
        Administrator foundAdmin = null;
        if (foundAdmins.size() != 0) {
            foundAdmin = foundAdmins.get(0);
        }
        return foundAdmin;
    }
}

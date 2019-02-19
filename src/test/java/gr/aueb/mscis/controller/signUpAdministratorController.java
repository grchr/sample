package gr.aueb.mscis.controller;

import gr.aueb.mscis.sample.controllers.UserController;
import gr.aueb.mscis.sample.enums.PrivilegeLevel;
import gr.aueb.mscis.sample.model.Administrator;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import gr.aueb.mscis.sample.service.AdministratorService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

public class signUpAdministratorController {

    private EntityManager em;

    @After
    public void tearDown(){
        em.close();
    }

    @Before
    public void setup(){
        // prepare database for each test
        em = JPAUtil.getCurrentEntityManager();
        Initializer dataHelper = new Initializer();
        dataHelper.prepareAdministratorData();
    }

    @Test
    public void testControllerAdministrator(){
        UserController userController = new UserController();
        userController.signUpUser("Admin", "Adminopoulos", "megaAdmin", "1234", "341414","email@svfs.vd", "123456",
                "62626", null, PrivilegeLevel.FULL, true, false,false);
        AdministratorService administratorService = new AdministratorService();
        Administrator createdAdmin = administratorService.findAdminByUsername("megaAdmin");
        Assert.assertNotNull(createdAdmin);
    }
}

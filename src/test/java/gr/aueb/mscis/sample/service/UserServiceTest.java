package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.User;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

public class UserServiceTest {

    protected EntityManager em;

    @After
    public void tearDown(){
        em.close();
    }

    @Before
    public void setup(){
        // prepare database for each test
        em = JPAUtil.getCurrentEntityManager();
        Initializer dataHelper = new Initializer();
        dataHelper.prepareUserData();
    }

    @Test
    public void testPersistAValidUser(){

        UserService service = new UserService();
        User newUser = service.createUser("Django", "Tarantino");
        User newUser2 = service.createUser("Teo", "Aggelis", "0900900900", "test@gmail.com", "5887527591");
        // EntityManager.persist() updates the ID of the persisted object
        Assert.assertNotNull(newUser.getId());
        Assert.assertNotNull(newUser2.getId());
        em.close(); // close session

        // new session, data will be retrieved from database
        em = JPAUtil.getCurrentEntityManager();

        User savedUser = em.find(User.class, newUser.getId());
        User savedUser2 = em.find(User.class, newUser2.getId());
        Assert.assertNotNull(savedUser);
        Assert.assertNotNull(savedUser2);
        System.out.println(savedUser);
        System.out.println(savedUser2);
        Assert.assertEquals("Django", savedUser.getFistName());
        Assert.assertEquals("Tarantino", savedUser.getLastName());
        Assert.assertEquals("Teo", savedUser2.getFistName());

    }
}

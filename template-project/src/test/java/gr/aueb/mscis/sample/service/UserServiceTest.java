package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.Movie;
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
        dataHelper.prepareData();

    }

    @Test
    public void testPersistAValidUser(){

        UserService service = new UserService();
        User newUser = service.createUser("Django", "Tarantino");
        // EntityManager.persist() updates the ID of the persisted object
        Assert.assertNotEquals(0, newUser.getId());
        em.close(); // close session

        // new session, data will be retrieved from database
        em = JPAUtil.getCurrentEntityManager();

        User savedUser = em.find(User.class, newUser.getId());
        Assert.assertNotNull(savedUser);
        System.out.println("User: " + savedUser.getFistName() + " " + savedUser.getLastName());
        Assert.assertEquals("Django", savedUser.getFistName());

    }
}

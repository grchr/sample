package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.MunicipalityWorker;
import gr.aueb.mscis.sample.model.User;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

public class MunicipalityWorkerServiceTest {

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
        dataHelper.prepareMunicipalityWorkerData();
    }

    @Test
    public void testPersistAValidMunicipalityWorker() {

        MunicipalityWorkerService municipalityWorkerService = new MunicipalityWorkerService();
        MunicipalityWorker newMunWorker = municipalityWorkerService.createMunicipalityWorker("Michael", "Stefanoudakis", "Athens Registry Office");
        // EntityManager.persist() updates the ID of the persisted object
        Assert.assertNotNull(newMunWorker.getId());
        em.close(); // close session

        // new session, data will be retrieved from database
        em = JPAUtil.getCurrentEntityManager();

        MunicipalityWorker savedMunWorker = em.find(MunicipalityWorker.class, newMunWorker.getId());
        Assert.assertNotNull(savedMunWorker);
        System.out.println("id: " + savedMunWorker.getId() + " User: " + savedMunWorker.getFistName() + " " + savedMunWorker.getLastName());
        Assert.assertEquals("Michael", savedMunWorker.getFistName());
    }
}

package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.dao.MunicipalityWorkerDao;
import gr.aueb.mscis.sample.model.MunicipalityWorker;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class MunicipalityWorkerUpdateServiceTest {

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
        dataHelper.prepareMunicipalityWorkerData();
    }

    @Test
    public void testMunicipalityWorkerUpdateService() {

        MunicipalityWorkerService municipalityWorkerService = new MunicipalityWorkerService();
        MunicipalityWorker newMunWorker = municipalityWorkerService.createMunicipalityWorker("Tim", "Duncan", "timD", "12345", "5334",
                "spurs@texas.com", "12134", "Dallas Office");
        Assert.assertNotNull(newMunWorker.getId());
        em.close(); // close session

        // new session, data will be retrieved from database
        em = JPAUtil.getCurrentEntityManager();

        MunicipalityWorker savedMunWorker = em.find(MunicipalityWorker.class, newMunWorker.getId());
        Assert.assertNotNull(savedMunWorker);
        System.out.println(savedMunWorker);
        MunicipalityWorker updatedWorker = municipalityWorkerService.updateMunicipalityWorker(null, "Obadaya", null, null, null,
                null, null, null, savedMunWorker);
        //System.out.println(updatedWorker);
        MunicipalityWorkerDao municipalityWorkerDao = new MunicipalityWorkerDao();
        List<MunicipalityWorker> workers = municipalityWorkerDao.getMunWorkerByLastName("Obadaya");
        for (MunicipalityWorker worker : workers) {
            System.out.println(worker);
        }
        List<MunicipalityWorker> workers2 = municipalityWorkerDao.getMunWorkerByLastName("Duncan");
        System.out.println(workers2.size());

    }
}

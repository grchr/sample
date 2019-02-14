package gr.aueb.mscis.sample.dao;

import gr.aueb.mscis.sample.model.MunicipalityWorker;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import gr.aueb.mscis.sample.service.MunicipalityWorkerService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class MunicipalityWorkerDaoTest {

    private EntityManager em;

    @After
    public void tearDown(){
        em.close();
    }

    @Test
    public void testMunicipalityWorkerDao() {
        em = JPAUtil.getCurrentEntityManager();
        MunicipalityWorkerService municipalityWorkerService = new MunicipalityWorkerService();
        MunicipalityWorker newMunWorker = municipalityWorkerService.createMunicipalityWorker("V", "Span", "Athens Registry Office");
        Assert.assertNotNull(newMunWorker.getId());
        em.close(); // close session

        // new session, data will be retrieved from database
        em = JPAUtil.getCurrentEntityManager();

        MunicipalityWorkerDao munDao = new MunicipalityWorkerDao();
        List<MunicipalityWorker> workers = munDao.getMunWorkerByLastName("Span");
        //System.out.println("====> " + workers.size());
        for (MunicipalityWorker m : workers) {
            System.out.println(m);
        }
        Assert.assertNotEquals(0, workers.size());


    }
}

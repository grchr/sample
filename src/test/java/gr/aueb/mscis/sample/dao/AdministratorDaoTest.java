package gr.aueb.mscis.sample.dao;

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
import java.util.List;

public class AdministratorDaoTest {

    private EntityManager em;

    @After
    public void tearDown(){
        em.close();
    }

    @Before
    public void setup() {
        em = JPAUtil.getCurrentEntityManager();
        Initializer dataHelper = new Initializer();
        dataHelper.prepareAdministratorData();
    }

    @Test
    public void testAdministratorDao(){
        em = JPAUtil.getCurrentEntityManager();
        AdministratorService adminService = new AdministratorService();
        Administrator newMunWorker = adminService.createAdministrator("Mr", "Joker", "mrJ", "12345", "5334",
                "spurs@texas.com", "12134", PrivilegeLevel.FULL);
        Assert.assertNotNull(newMunWorker.getId());
        em.close(); // close session

        // new session, data will be retrieved from database
        em = JPAUtil.getCurrentEntityManager();

        AdministratorDao adminDao = new AdministratorDao();
        List<Administrator> admins = adminDao.findByLastName("Joker");
        for (Administrator m : admins) {
            System.out.println(m);
        }
        Assert.assertNotEquals(0, admins.size());
    }
}

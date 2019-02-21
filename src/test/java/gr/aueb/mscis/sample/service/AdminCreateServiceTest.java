package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.enums.PrivilegeLevel;
import gr.aueb.mscis.sample.model.Administrator;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class AdminCreateServiceTest {

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
    public void testCreateAdministratorServiceTest() {

        AdministratorService administratorService = new AdministratorService();
        Administrator newAdmin = administratorService.createAdministrator("Admin", "Adminopoulos", "megaAdmin", "1234",
                "341414","ABGKABDD@sszb.vc", "123456", PrivilegeLevel.FULL);
        System.out.println(newAdmin);
        Assert.assertNotNull(newAdmin.getId());


        Administrator foundAdmin = administratorService.findAdminByUsername("megaAdmin");
        Administrator updatedAdmin = administratorService.updateAdministrator("Roger", null, "mpalourdos", null, null, null,
                null, PrivilegeLevel.REPORT, foundAdmin);

        Administrator megaAdmin = administratorService.findAdminByUsername("megaAdmin");
        Assert.assertNull(megaAdmin);
        Administrator mpalourdos = administratorService.findAdminByUsername("mpalourdos");
        System.out.println(mpalourdos);
        Assert.assertEquals(mpalourdos.getUserName(), "mpalourdos");
        List<Administrator> allAdmins = administratorService.findAll();
        System.out.println(allAdmins.size());
        Assert.assertEquals(2, allAdmins.size());
    }

}

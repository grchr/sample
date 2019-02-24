package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.model.Vaccine;
import gr.aueb.mscis.vacpro.persistence.Initializer;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class VaccineServiceTest {

    private EntityManager em;

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        em.close();
    }

    /**
     * Sets .
     */
    @Before
    public void setup() {
        // prepare database for each test
        em = JPAUtil.getCurrentEntityManager();
        Initializer dataHelper = new Initializer();
        dataHelper.prepareVaccineData();
    }

    @Test
    public void testVaccineCreateService(){
        VaccineService vaccineService = new VaccineService();
        Vaccine vaccine = new Vaccine("hepatitis", 400, "typeA", 2);
        vaccine = vaccineService.createVaccine(vaccine);
        System.out.println(vaccine);
        Assert.assertNotEquals(1, vaccine.getId());
    }

    @Test
    public void testVaccineFindAllService(){
        VaccineService vaccineService = new VaccineService();
        Vaccine vaccine = new Vaccine("hepatitis", 400, "typeA", 2);
        vaccine = vaccineService.createVaccine(vaccine);
        List<Vaccine> vaccines = vaccineService.findAll();
        Assert.assertEquals(2, vaccines.size());
    }
}

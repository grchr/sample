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

/**
 * The type Vaccine service test.
 */
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

	/**
	 * Test vaccine create service.
	 */
	@Test
	public void testVaccineCreateService() {
		VaccineService vaccineService = new VaccineService();
		Vaccine vaccine = vaccineService.createVaccine(new Vaccine("hepatitis", 400, "typeA", 2));
		System.out.println(vaccine);
		Assert.assertEquals("hepatitis", vaccine.getDisease());
	}

	/**
	 * Test vaccine find all service.
	 */
	@Test
	public void testVaccineFindAllService() {
		VaccineService vaccineService = new VaccineService();
		Vaccine vaccine = vaccineService.createVaccine(new Vaccine("hepatitis", 400, "typeA", 2));
		List<Vaccine> vaccines = vaccineService.findAll();
		Assert.assertEquals(2, vaccines.size());
	}
}

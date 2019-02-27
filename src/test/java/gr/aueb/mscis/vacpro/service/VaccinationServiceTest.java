package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.enums.VaccinationStatus;
import gr.aueb.mscis.vacpro.model.Vaccination;
import gr.aueb.mscis.vacpro.model.Vaccine;
import gr.aueb.mscis.vacpro.persistence.Initializer;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The type Vaccination service test.
 */
public class VaccinationServiceTest {

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
		dataHelper.prepareVaccinationData();
	}

	/**
	 * Test create vaccination.
	 */
	@Test
	public void testCreateVaccination() {
		VaccinationService vaccinationService = new VaccinationService();
		List<Vaccination> vaccinations = vaccinationService.findAll();
		Assert.assertEquals(4, vaccinations.size());

	}

	/**
	 * Test update vaccination.
	 */
	@Test
	public void testUpdateVaccination() {
		VaccinationService vaccinationService = new VaccinationService();
		List<Vaccination> vaccinations = vaccinationService.findAll();
		for (Vaccination vacs : vaccinations) {
			vacs.setStatus(VaccinationStatus.NOTIFIED);
			vaccinationService.updateVaccination(vacs);
		}
		vaccinations = vaccinationService.findAll();
		Assert.assertEquals(VaccinationStatus.NOTIFIED, vaccinations.get(0).getStatus());
	}

	/**
	 * Test get vaccinations for today.
	 */
	@Test
	public void testGetVaccinationsForToday() {
		VaccinationService vaccinationService = new VaccinationService();
		Date today = new Date(119, 1, 24);
		System.out.println("Check to send notification for day : " + today);
		List<Vaccination> vaccinations = vaccinationService.findVaccinationsThatNeedNotification(today);
		Assert.assertEquals(1, vaccinations.size());

	}


	/**
	 * Create monthly vaccination report test.
	 */
	@Test
	public void createMonthlyVaccinationReportTest() {
		VaccinationService vaccinationService = new VaccinationService();

		Map<Vaccine, Integer> report = vaccinationService.createMonthlyVaccinationReport(new Date(119, 2, 01), new Date(130, 1, 5));
		Assert.assertEquals(1, report.size());
		Assert.assertNotNull(report.keySet());
	}
}

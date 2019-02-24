package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.model.Address;
import gr.aueb.mscis.vacpro.model.MunicipalityWorker;
import gr.aueb.mscis.vacpro.model.User;
import gr.aueb.mscis.vacpro.persistence.Initializer;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * The type Municipality worker service test.
 */
public class MunicipalityWorkerServiceTest {

	/**
	 * The Em.
	 */
	protected EntityManager em;

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
		dataHelper.prepareMunicipalityWorkerData();
	}

	/**
	 * Create municipality worker test.
	 */
	@Test
	public void createMunicipalityWorkerTest() {

		MunicipalityWorkerService municipalityWorkerService = new MunicipalityWorkerService();
		MunicipalityWorker newMunWorker = municipalityWorkerService.createMunicipalityWorker("Tim", "Duncan", "timD", "12345", "6944816378",
				"spurs@texas.com", "123456789", "Dallas Office", new Address());
		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull(newMunWorker.getId());
		em.close(); // close session

		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();

		MunicipalityWorker savedMunWorker = em.find(MunicipalityWorker.class, newMunWorker.getId());
		Assert.assertNotNull(savedMunWorker);
		assertEquals("Tim", savedMunWorker.getFistName());
	}

	/**
	 * Update municipality worker test.
	 */
	@Test
	public void updateMunicipalityWorkerTest() {
		MunicipalityWorkerService municipalityWorkerService = new MunicipalityWorkerService();

		List<User> mun = em.createQuery("Select a From User a where  a.class like :userType", User.class)
				.setParameter("userType", "MUN_W").getResultList();

		MunicipalityWorker worker = municipalityWorkerService.updateMunicipalityWorker("newFirstname", "newLastname", "newUsername",
				"newPassword", "newPhone", "newEmail", "newVat", "newReg",
				(MunicipalityWorker) mun.get(0));

		assertEquals("newReg", worker.getRegistryOffice());
		assertEquals("newFirstname", worker.getFistName());
		assertEquals("newLastname", worker.getLastName());
		assertEquals("newPhone", worker.getPhoneNumber());
		assertEquals("newEmail", worker.getEmail());
		assertEquals("newVat", worker.getVatNumber());
		assertEquals("newPassword", worker.getPassword());
		assertEquals("newUsername", worker.getUserName());
	}
}

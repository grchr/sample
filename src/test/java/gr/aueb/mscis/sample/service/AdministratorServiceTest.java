package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.enums.PrivilegeLevel;
import gr.aueb.mscis.sample.model.Address;
import gr.aueb.mscis.sample.model.Administrator;
import gr.aueb.mscis.sample.model.User;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * The type Administrator service test.
 */
public class AdministratorServiceTest {

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
		dataHelper.prepareAdministratorData();
	}

	/**
	 * Create administrator test.
	 */
	@Test
	public void createAdministratorTest() {

		AdministratorService administratorService = new AdministratorService();

		Administrator administrator = administratorService.createAdministrator("Admin", "Adminopoulos", "megaAdmin", "1234",
				"341414", "ABGKABDD@sszb.vc", "123456", new Address(), PrivilegeLevel.FULL);

		assertEquals("Admin", administrator.getFistName());
		assertEquals("Adminopoulos", administrator.getLastName());
		assertEquals("megaAdmin", administrator.getUserName());
		assertEquals("1234", administrator.getPassword());
		assertEquals("341414", administrator.getPhoneNumber());
		assertEquals("ABGKABDD@sszb.vc", administrator.getEmail());
		assertEquals("123456", administrator.getVatNumber());
		assertNotNull(administrator.getAddress());
		assertEquals(PrivilegeLevel.FULL, administrator.getPrivilege());
		assertEquals(2, getAdmins().size());
	}

	/**
	 * Update administrator password test.
	 */
	@Test
	public void updateAdministratorPasswordTest() {
		AdministratorService administratorService = new AdministratorService();
		List<User> admin1 = em.createQuery("Select a From User a where  a.class like :userType", User.class)
				.setParameter("userType", "ADMIN").getResultList();


		Administrator administrator = administratorService.updateAdministratorPassword("newPass", (Administrator) admin1.get(0));

		assertEquals("newPass", administrator.getPassword());
		assertEquals("Bruce", administrator.getFistName());
		assertEquals("Wayne", administrator.getLastName());
		assertEquals(PrivilegeLevel.FULL, administrator.getPrivilege());
		assertEquals(1, getAdmins().size());
		assertNull(administrator.getEmail());
	}

	/**
	 * Find admin by username test.
	 */
	@Test
	public void findAdminByUsernameTest() {
		AdministratorService administratorService = new AdministratorService();

		Administrator administrator = administratorService.findAdminByUsername("username");
		assertEquals("Bruce", administrator.getFistName());
		assertEquals("Wayne", administrator.getLastName());
		assertEquals("pass", administrator.getPassword());
		assertEquals(PrivilegeLevel.FULL, administrator.getPrivilege());
		assertEquals(1, getAdmins().size());

	}

	/**
	 * Update administrator privilege test.
	 */
	@Test
	public void updateAdministratorPrivilegeTest() {
		AdministratorService administratorService = new AdministratorService();

		Administrator admin1 = new Administrator("Bruce", "Wayne", PrivilegeLevel.FULL);
		admin1.setUserName("username");
		admin1.setPassword("pass");
		admin1.setId(1);

		Administrator adm = administratorService.updateAdministratorPrivilege(PrivilegeLevel.NOTIFICATION, admin1);

		assertEquals("Bruce", adm.getFistName());
		assertEquals("Wayne", adm.getLastName());
		assertEquals("pass", adm.getPassword());
		assertEquals(PrivilegeLevel.NOTIFICATION, adm.getPrivilege());
		assertEquals(1, getAdmins().size());

	}

	/**
	 * Find all test.
	 */
	@Test
	public void findAllTest() {
		AdministratorService administratorService = new AdministratorService();

		List<Administrator> admin = administratorService.findAll();

		assertEquals(1, admin.size());
		assertEquals("Bruce", admin.get(0).getFistName());
		assertEquals("Wayne", admin.get(0).getLastName());
	}

	private List<Administrator> getAdmins() {
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String queryString = "from User user where user.class like :usertype";
		Query query = em.createQuery(queryString);
		query.setParameter("usertype", "ADMIN");
		tx.commit();
		return (List<Administrator>) query.getResultList();
	}
}

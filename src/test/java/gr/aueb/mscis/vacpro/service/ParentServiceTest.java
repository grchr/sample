package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.model.User;
import gr.aueb.mscis.vacpro.persistence.Initializer;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * The type Parent service test.
 */
public class ParentServiceTest {

	private EntityManager em;

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		em.close();
	}

	/**
	 * Set up tests.
	 */
	@Before
	public void setup() {
		// prepare database for each test
		em = JPAUtil.getCurrentEntityManager();
		Initializer dataHelper = new Initializer();
		dataHelper.prepareParentData();
	}

	/**
	 * Create parent test.
	 */
	@Test
	public void createParentTest() {
		ParentService parentService = new ParentService();
		Parent parent1 = new Parent("Kostas", "Fortounis", "6999", "v", "@", "2421");
		parent1.setUserName("theUsername");
		Parent createdParent = parentService.createParent(parent1);

		assertEquals("Kostas", createdParent.getFistName());
		assertEquals("Fortounis", createdParent.getLastName());
		assertEquals("6999", createdParent.getPhoneNumber());
		assertEquals("v", createdParent.getInsuranceNumber());
		assertEquals("@", createdParent.getEmail());
		assertEquals("2421", createdParent.getVatNumber());
		assertEquals(2, getParents().size());

	}

	/**
	 * Update parent username test.
	 */
	@Test
	public void updateParentUsernameTest() {
		ParentService parentService = new ParentService();
		List<User> parent = em.createQuery("Select a From User a where  a.class like :userType", User.class)
				.setParameter("userType", "PARENT").getResultList();

		Parent createdParent = parentService.updateParent("newFirstname", "newParent","newusername", "newpassword", "newphone", "newemail", "newvat",
				"newin", null, (Parent) parent.get(0));

		assertEquals("newusername", createdParent.getUserName());
		assertEquals("newParent", createdParent.getLastName());
		assertEquals("newFirstname", createdParent.getFistName());
		assertEquals("newphone", createdParent.getPhoneNumber());
		assertEquals("newin", createdParent.getInsuranceNumber());
		assertEquals("newemail", createdParent.getEmail());
		assertEquals("newvat", createdParent.getVatNumber());
		assertEquals(1, getParents().size());
	}

	/**
	 * Find parent by last name test.
	 */
	@Test
	public void findParentByLastNameTest() {
		ParentService parentService = new ParentService();
		Parent parent = em.find(Parent.class, 1);

		List<Parent> parents = parentService.findParentByLastName("Parent");

		assertEquals(1, parents.size());
		assertEquals("Parent", parents.get(0).getLastName());

	}

	/**
	 * Find parent by vat number test.
	 */
	@Test
	public void findParentByVatNumberTest() {
		ParentService parentService = new ParentService();
		Parent parent = em.find(Parent.class, 1);

		List<Parent> parents = parentService.findParentByVatNumber("242");

		assertEquals(1, parents.size());
		assertEquals("242", parents.get(0).getVatNumber());

	}

	/**
	 * Test find all parents.
	 */
	@Test
	public void testFindAllParents() {
		ParentService parentService = new ParentService();
		List<Parent> admin = parentService.findAll();

		assertEquals(1, admin.size());
		assertEquals("Test", admin.get(0).getFistName());
		assertEquals("Parent", admin.get(0).getLastName());
	}


	private List<Parent> getParents() {
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String queryString = "from User user where user.class like :usertype";
		Query query = em.createQuery(queryString);
		query.setParameter("usertype", "PARENT");
		tx.commit();
		return (List<Parent>) query.getResultList();
	}
}

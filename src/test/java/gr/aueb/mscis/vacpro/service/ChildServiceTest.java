package gr.aueb.mscis.vacpro.service;


import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.persistence.Initializer;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The type Child service test.
 */
public class ChildServiceTest {

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
		dataHelper.prepareChildData();
	}

	/**
	 * Find childs by parent test.
	 */
	@Test
	public void findChildsByParentTest() {
		ChildService childService = new ChildService();
		ParentService parentService = new ParentService();
		List<Parent> parent = parentService.findAll();

		List<Child> children = childService.findChildsByParent(parent.get(0));

		assertEquals(2, children.size());
		assertNotNull(children.get(0));
		assertNotNull(children.get(1));
	}

	/**
	 * Find children by surname test.
	 */
	@Test
	public void findChildrenBySurnameTest() {
		ChildService childService = new ChildService();
		List<Child> childrens = childService.findChildrenBySurname("Child");

		assertEquals(2, childrens.size());
	}

	/**
	 * Create child test.
	 */
	@Test
	public void createChildTest() {
		ChildService childService = new ChildService();


		ParentService parentService = new ParentService();
		List<Parent> parent = parentService.findAll();
		Child child = new Child("Test", "Child", new Date(1992, 12, 5));
		child.setParent(parent.get(0));

		Child child1 = childService.createChild(child);

		assertEquals("Test", child1.getName());
		assertEquals("Child", child1.getSurname());
		assertEquals(new Date(1992, 12, 5), child1.getBirthday());
		assertEquals(3, getChilds().size());
	}

	/**
	 * Find all test.
	 */
	@Test
	public void findAllTest() {
		ChildService childService = new ChildService();
		List<Child> childrens = childService.finadAll();

		assertEquals(2, childrens.size());
	}

	private List<Child> getChilds() {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String queryString = "from Child";
		Query query = em.createQuery(queryString);
		tx.commit();
		return (List<Child>) query.getResultList();
	}
}

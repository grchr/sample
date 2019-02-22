package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.Parent;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * The type Parent service.
 */
public class ParentService {

	private EntityManager em;

	/**
	 * Instantiates a new Parent service.
	 */
	public ParentService() {
		em = JPAUtil.getCurrentEntityManager();
	}

	/**
	 * Create parent parent.
	 *
	 * @param newParent the new parent
	 * @return the parent
	 */
	public Parent createParent(final Parent newParent) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(newParent);
		tx.commit();

		return newParent;
	}

	/**
	 * Update parent.
	 *
	 * @param username the username
	 * @param parent   the parent
	 * @return the parent
	 */
	public Parent updateParentUsername(final String username, final Parent parent) {
		parent.setUserName(username);

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(parent);
		tx.commit();

		return parent;
	}

	/**
	 * Find parent by last name list.
	 *
	 * @param lastName the last name
	 * @return the list
	 */
	public List<Parent> findParentByLastName(final String lastName) {
		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query query = em.createQuery("from User user where user.lastName = :last and user.class like :type");
		query.setParameter("last", lastName);
		query.setParameter("type", "PARENT");
		List<Parent> results = (List<Parent>) query.getResultList();
		tx.commit();
		return results;
	}

	/**
	 * Find parent by vat number list.
	 *
	 * @param vatNumber the vat number
	 * @return the list
	 */
	public List<Parent> findParentByVatNumber(String vatNumber) {

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query query = em.createQuery("from User user where user.vatNumber = :vat and user.class like :type");
		query.setParameter("vat", vatNumber);
		query.setParameter("type", "PARENT");
		List<Parent> results = (List<Parent>) query.getResultList();
		tx.commit();
		return results;
	}

	/**
	 * Find all list.
	 *
	 * @return the list
	 */
	public List<Parent> findAll() {
		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String queryString = "from User user  where user.class like :type";
		Query query = em.createQuery(queryString);
		query.setParameter("type", "PARENT");
		List<Parent> results = (List<Parent>) query.getResultList();
		tx.commit();

		return results;
	}
}

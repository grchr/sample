package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;

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
	 * @param firstName       the first name
	 * @param lastName        the last name
	 * @param userName        the user name
	 * @param password        the password
	 * @param phoneNumber     the phone number
	 * @param email           the email
	 * @param vatNumber       the vat number
	 * @param insuranceNumber the insurance number
	 * @param children        the children
	 * @param parent          the parent
	 * @return the parent
	 */
	public Parent updateParent(final String firstName, final String lastName, final String userName,
							   final String password, final String phoneNumber, final String email,
							   final String vatNumber, final String insuranceNumber,final List<Child> children,
							   final Parent parent) {

		if (firstName != null) {
			parent.setFistName(firstName);
		}
		if (lastName != null) {
			parent.setLastName(lastName);
		}
		if (userName != null) {
			parent.setUserName(userName);
		}
		if (password != null) {
			parent.setPassword(password);
		}
		if (phoneNumber != null) {
			parent.setPhoneNumber(phoneNumber);
		}
		if (email != null) {
			parent.setEmail(email);
		}
		if (vatNumber != null) {
			parent.setVatNumber(vatNumber);
		}
		if (insuranceNumber != null) {
			parent.setInsuranceNumber(insuranceNumber);
		}
		if (children != null) {
			parent.setChildren(children);
		}

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
	public List<Parent> findParentByVatNumber(final String vatNumber) {

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

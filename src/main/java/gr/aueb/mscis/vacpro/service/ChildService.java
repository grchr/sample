package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * The type Child service.
 */
public class ChildService {


	private EntityManager em;

	/**
	 * Instantiates a new Child service.
	 */
	public ChildService() {
		em = JPAUtil.getCurrentEntityManager();
	}


	/**
	 * Find childs by parent list.
	 *
	 * @param parent the parent
	 * @return the list
	 */
	public List<Child> findChildsByParent(Parent parent) {

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String queryString = "Select child from Child child where child.parent = :parent";
		Query query = em.createQuery(queryString);
		query.setParameter("parent", parent);
		List<Child> results = (List<Child>) query.getResultList();

		tx.commit();
		return results;
	}

	/**
	 * Find children by surname list.
	 *
	 * @param surname the surname
	 * @return the list
	 */
	public List<Child> findChildrenBySurname(String surname) {

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query query = em.createQuery("from Child where surname = :surname");
		query.setParameter("surname", surname);
		List<Child> results = (List<Child>) query.getResultList();

		tx.commit();
		return results;
	}

	/**
	 * Create child child.
	 *
	 * @param child the child
	 * @return the child
	 */
	public Child createChild(final Child child){

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(child);
		tx.commit();

		return child;
	}

	/**
	 * Finad all list.
	 *
	 * @return the list
	 */
	public List<Child> finadAll() {
		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from Child ");
		List<Child> results = query.getResultList();

		tx.commit();
		return results;
	}

}

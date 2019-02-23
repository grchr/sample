package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.Child;
import gr.aueb.mscis.sample.model.Parent;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ChildService {


	private EntityManager em;

	public ChildService() {
		em = JPAUtil.getCurrentEntityManager();
	}


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

	public Child createChild(final Child child){

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(child);
		tx.commit();

		return child;
	}

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

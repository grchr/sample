package gr.aueb.mscis.vacpro.service;


import gr.aueb.mscis.vacpro.model.Vaccination;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author taggelis
 */
public class VaccinationService {

	private EntityManager em;

	public VaccinationService() {
		em = JPAUtil.getCurrentEntityManager();
	}

	public Vaccination createVaccination(Vaccination vaccination) {

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(vaccination);
		tx.commit();

		return vaccination;
	}

	public Vaccination updateVaccination(Vaccination vaccination) {

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(vaccination);
		tx.commit();

		return vaccination;
	}

	public List<Vaccination> findAll() {
		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from Vaccination");
		List<Vaccination> results = query.getResultList();

		tx.commit();
		return results;
	}

	public List<Vaccination> findVaccinationsThatNeedNotification(Date today) {
		List<Vaccination> results = new ArrayList<>();

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query query = em.createQuery("from Vaccination where notify_date > :date").setParameter("date", today);
		query.setParameter("date", today);
		results = query.getResultList();

		tx.commit();

		return  results;
	}

}

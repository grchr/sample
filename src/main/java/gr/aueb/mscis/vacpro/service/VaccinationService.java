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
 * The type Vaccination service.
 *
 * @author taggelis
 */
public class VaccinationService {

	private EntityManager em;

	/**
	 * Instantiates a new Vaccination service.
	 */
	public VaccinationService() {
		em = JPAUtil.getCurrentEntityManager();
	}

	/**
	 * Create vaccination vaccination.
	 *
	 * @param vaccination the vaccination
	 * @return the vaccination
	 */
	public Vaccination createVaccination(final Vaccination vaccination) {

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(vaccination);
		tx.commit();

		return vaccination;
	}

	/**
	 * Update vaccination vaccination.
	 *
	 * @param vaccination the vaccination
	 * @return the vaccination
	 */
	public Vaccination updateVaccination(final Vaccination vaccination) {

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(vaccination);
		tx.commit();

		return vaccination;
	}

	/**
	 * Find all list.
	 *
	 * @return the list
	 */
	public List<Vaccination> findAll() {
		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from Vaccination");
		List<Vaccination> results = query.getResultList();

		tx.commit();
		return results;
	}

	/**
	 * Find vaccinations that need notification list.
	 *
	 * @param today the today
	 * @return the list
	 */
	public List<Vaccination> findVaccinationsThatNeedNotification(final Date today) {
		List<Vaccination> results = new ArrayList<>();

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query query = em.createQuery("from Vaccination where notify_date > :date").setParameter("date", today);
		query.setParameter("date", today);
		results = query.getResultList();

		tx.commit();

		return results;
	}

}

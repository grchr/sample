package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.Vaccination;
import gr.aueb.mscis.sample.model.Vaccine;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @author taggelis
 */
public class VaccinationService {

	private EntityManager em;

	public VaccinationService() {
		em = JPAUtil.getCurrentEntityManager();
	}

	public boolean updateChildVaccinationTimes(final int childID, final int vaccineId, final int vaccinatedTimes) {
		int results = em.createQuery("Update Vaccination set vaccinatedTimes=:times where child.id=:childId and vaccine.id=:vaccineId")
				.setParameter("times", vaccinatedTimes)
				.setParameter("childId", childID)
				.setParameter("vaccineId", vaccineId).executeUpdate();

		return results == 1;
	}

	//TODO: implement create vaccinations with reference to specific child, for all vaccines
	//TODO: implement update vaccinations for new statuses
	//TODO: find vaccinations for current day
	public Vaccination createVaccination(Vaccination vaccination) {

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(vaccination);
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

}

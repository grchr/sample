package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;

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

}

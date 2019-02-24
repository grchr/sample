package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.model.Vaccine;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccine service.
 */
public class VaccineService {

    private EntityManager em;

    /**
     * Create vaccine vaccine.
     *
     * @param vaccine the vaccine
     * @return the vaccine
     */
    public Vaccine createVaccine(final Vaccine vaccine) {

        em = JPAUtil.getCurrentEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(vaccine);

        tx.commit();

        return vaccine;
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Vaccine> findAll(){
        List<Vaccine> results = new ArrayList<>();

        em = JPAUtil.getCurrentEntityManager();
        Query query = em.createQuery("from Vaccine");
        results = (List<Vaccine>) query.getResultList();

        return results;
    }
}

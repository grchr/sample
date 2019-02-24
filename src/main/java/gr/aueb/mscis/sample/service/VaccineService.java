package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.Vaccine;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class VaccineService {

    private EntityManager em;

    public Vaccine createVaccine(Vaccine vaccine) {

        em = JPAUtil.getCurrentEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(vaccine);

        tx.commit();

        return vaccine;
    }

    public List<Vaccine> findAll(){
        List<Vaccine> results = new ArrayList<>();

        em = JPAUtil.getCurrentEntityManager();
        Query query = em.createQuery("from Vaccine");
        results = (List<Vaccine>) query.getResultList();

        return results;
    }
}

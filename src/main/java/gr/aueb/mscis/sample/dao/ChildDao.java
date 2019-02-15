package gr.aueb.mscis.sample.dao;

import gr.aueb.mscis.sample.model.Child;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ChildDao {

    private EntityManager em;

    public List<Child> findChildreByParentId(int parentId) {
        List<Child> results = new ArrayList<>();
        em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String queryString = "from " + Child.class.getName() + " where parent_id = :id";
        Query query = em.createQuery(queryString);
        query.setParameter("id", parentId);
        results = (List<Child>) query.getResultList();


        tx.commit();
        return results;
    }
}
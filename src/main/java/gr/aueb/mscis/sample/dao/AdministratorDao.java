package gr.aueb.mscis.sample.dao;

import gr.aueb.mscis.sample.model.Administrator;
import gr.aueb.mscis.sample.model.User;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDao extends UserDao {

    private EntityManager em;

    public List<Administrator> findByLastName(String lastName) {
        List<Administrator> results = new ArrayList<>();

        em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //TODO: Use this approach to correct the other DAOs
        String queryString = "from " + User.class.getName() + " where last_name = :name and type like :type";
        Query query = em.createQuery(queryString);
        query.setParameter("name", lastName);
        query.setParameter("type", "ADMIN");
        results = (List<Administrator>) query.getResultList();
        tx.commit();

        return  results;

    }

    public List<Administrator> findByUserName(String userName) {
        List<Administrator> results = new ArrayList<>();

        return  results;
    }
}

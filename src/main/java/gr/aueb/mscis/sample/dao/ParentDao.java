package gr.aueb.mscis.sample.dao;

import gr.aueb.mscis.sample.model.Parent;
import gr.aueb.mscis.sample.model.User;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Parent dao.
 */
public class ParentDao extends UserDao{

    private EntityManager em;


    public List<Parent> findByLastName(String lastName) {
        List<Parent> results = new ArrayList<>();

        em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String queryString = "from " + User.class.getName() + " where last_name = :name and type like :type";
        Query query = em.createQuery(queryString);
        query.setParameter("name", lastName);
        query.setParameter("type", "PARENT");
        results = (List<Parent>) query.getResultList();
        tx.commit();
        return results;
    }

    public List<Parent> findByUserName(String userName) {
        List<Parent> results = new ArrayList<>();

        em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String queryString = "from " + User.class.getName() + " where user_name = :user_name and type like :type";
        Query query = em.createQuery(queryString);
        query.setParameter("user_name", userName);
        query.setParameter("type", "PARENT");
        results = (List<Parent>) query.getResultList();
        tx.commit();

        return results;
    }

    public List<Parent> findAll(){
        List<Parent> results = new ArrayList<>();
        em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String queryString = "from " + User.class.getName() + " where type like :type";
        Query query = em.createQuery(queryString);
        query.setParameter("type", "PARENT");
        results = (List<Parent>) query.getResultList();

        tx.commit();

        return  results;
    }

}

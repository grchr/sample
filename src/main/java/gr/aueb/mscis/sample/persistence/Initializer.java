package gr.aueb.mscis.sample.persistence;

import gr.aueb.mscis.sample.model.MunicipalityWorker;
import gr.aueb.mscis.sample.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


/**
 * The type Initializer.
 */
public class Initializer  {


    /**
     * Remove all data from database.
     * The functionality must be executed within the bounds of a transaction
     */
    public void  eraseData(Class c) {
        EntityManager em = JPAUtil.getCurrentEntityManager();
        System.err.println("----------->" + c.getSimpleName());
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = null;

        //TODO: try to create query with prepared statement for delete
        //query = em.createNativeQuery("delete from :table").setParameter("table", "User");
        if (c.getSimpleName().equals("User")) {
            query = em.createNativeQuery("delete from User");
        } else if (c.getSimpleName().equals("MunicipalityWorker")) {
            query = em.createNativeQuery("delete from User where type like :type").setParameter("type", "MUN_W");
        }
        query.executeUpdate();

        tx.commit();
    }


    /**
     * Prepare data.
     */
    public void prepareUserData() {
        eraseData(User.class);


        User user1 = new User("GR", "CHR");
        User user2 = new User("T","Mac");

        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(user1);
        em.persist(user2);
        tx.commit();
    }

    public void prepareMunicipalityWorkerData() {
        eraseData(MunicipalityWorker.class);

        MunicipalityWorker munW1 = new MunicipalityWorker("T", "Dot", "Athens");

        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(munW1);
        tx.commit();
    }
}

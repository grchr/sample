package gr.aueb.mscis.sample.persistence;

import gr.aueb.mscis.sample.enums.PrivilegeLevel;
import gr.aueb.mscis.sample.model.Administrator;
import gr.aueb.mscis.sample.model.MunicipalityWorker;
import gr.aueb.mscis.sample.model.Parent;
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
    private void eraseData(Class clazz) {

        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Query query = null;

        if (clazz.getSimpleName().equals("User")) {
            query = em.createNativeQuery("delete from User");
        } else if (clazz.getSimpleName().equals("MunicipalityWorker")) {
            query = em.createNativeQuery("delete from User where type like :type").setParameter("type", "MUN_W");
        }
        query.executeUpdate();

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

    public void prepareParentData() {
        eraseParentData(Parent.class);

        Parent parent1 = new Parent("Test", "Parent", "sfs", "v", "@", "242");
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(parent1);
        tx.commit();
    }

    public void prepareAdministratorData() {
        eraseAdminData(Administrator.class);

        Administrator admin1 = new Administrator("Bruce", "Wayne", PrivilegeLevel.FULL);
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(admin1);
        tx.commit();

    }

    public void eraseAdminData(Class clazz) {
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Query deleteAdminQuery = null;
        deleteAdminQuery = em.createNativeQuery("delete from User where type like :type").setParameter("type", "ADMIN");
        deleteAdminQuery.executeUpdate();

        tx.commit();
    }

    public void eraseParentData(Class clazz) {

        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Query deleteChildrenQuery = null;
        Query deleteParentsQuery = null;
        deleteChildrenQuery = em.createNativeQuery("delete from Child where parent_id in (select id from User where type like :type)").setParameter("type", "PARENT");
        deleteParentsQuery = em.createNativeQuery("delete from User where type like :type").setParameter("type", "PARENT");

        deleteChildrenQuery.executeUpdate();
        deleteParentsQuery.executeUpdate();

        tx.commit();
    }
}

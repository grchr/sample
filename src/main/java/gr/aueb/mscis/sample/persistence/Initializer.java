package gr.aueb.mscis.sample.persistence;

import gr.aueb.mscis.sample.enums.PrivilegeLevel;
import gr.aueb.mscis.sample.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Initializer.
 */
public class Initializer {

	public void prepareMunicipalityWorkerData() {
		eraseUserData(MunicipalityWorker.class);

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

	public void prepareChildData() {
		eraseParentData(Parent.class);

		Parent parent1 = new Parent("Test", "Parent", "sfs", "v", "@", "242");
		List<Child> children = new ArrayList<>();
		Child child1 = new Child("Test", "Child");
		child1.setParent(parent1);
		children.add(child1);
		parent1.setChildren(children);
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


	/**
	 * Remove all data from database.
	 * The functionality must be executed within the bounds of a transaction
	 */
	private void eraseUserData(Class clazz) {

		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query query = null;

		if (clazz.isInstance(User.class)) {
			query = em.createNativeQuery("delete from User");
		} else if (clazz.isInstance(MunicipalityWorker.class)) {
			query = em.createNativeQuery("delete from User where type like :type").setParameter("type", "MUN_W");
		}
		if (query != null) {
			query.executeUpdate();
		}

		tx.commit();
	}

}

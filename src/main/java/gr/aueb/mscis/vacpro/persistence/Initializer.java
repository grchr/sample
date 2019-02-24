package gr.aueb.mscis.vacpro.persistence;


import gr.aueb.mscis.vacpro.enums.PrivilegeLevel;
import gr.aueb.mscis.vacpro.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Initializer.
 */
public class Initializer {

	/**
	 * Prepare municipality worker data.
	 */
	public void prepareMunicipalityWorkerData() {
		eraseUserData(MunicipalityWorker.class);

		MunicipalityWorker munW1 = new MunicipalityWorker("T", "Dot", "Athens");
		munW1.setEmail("email");
		munW1.setUserName("username");
		munW1.setPassword("password");
		munW1.setVatNumber("vat");

		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(munW1);
		tx.commit();
	}

	/**
	 * Prepare parent data.
	 */
	public void prepareParentData() {
		eraseParentData();

		Parent parent1 = new Parent("Test", "Parent", "sfs", "v", "@", "242");
		parent1.setUserName("username");
		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(parent1);
		tx.commit();
	}

	/**
	 * Prepare child data.
	 */
	public void prepareChildData() {
		eraseParentData();
		Parent parent1 = new Parent("Test", "Parent", "sfs", "v", "@", "242");
		parent1.setUserName("test");
		List<Child> children = new ArrayList<>();
		Child child1 = new Child("Test", "Child", new Date(2017, 3, 4));
		child1.setParent(parent1);
		children.add(child1);
		Child child2 = new Child("Test2", "Child", new Date(2017, 1, 16));
		child2.setParent(parent1);
		children.add(child2);

		parent1.setChildren(children);

		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(parent1);
		tx.commit();
	}

	/**
	 * Prepare administrator data.
	 */
	public void prepareAdministratorData() {
		eraseAdminData();

		Administrator admin1 = new Administrator("Bruce", "Wayne", PrivilegeLevel.FULL);
		admin1.setUserName("username");
		admin1.setPassword("pass");
		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(admin1);
		tx.commit();

	}

	public void prepareVaccineData(){
		eraseVaccineData(Vaccine.class);

		Vaccine vaccine1 = new Vaccine( "hepatitis",  300, "typeA",  1);
		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(vaccine1);
		tx.commit();
	}

	/**
	 * Erase admin data.
	 */
	private void eraseAdminData() {
		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query deleteAdminQuery;
		deleteAdminQuery = em.createQuery("delete from User user where user.class like :type").setParameter("type", "ADMIN");
		deleteAdminQuery.executeUpdate();

		tx.commit();
	}

	/**
	 * Erase parent data.
	 */
	private void eraseParentData() {

		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createQuery("delete from Child where parent_id in (select id from User where type like :type)").setParameter("type", "PARENT").executeUpdate();
		em.createQuery("delete from User user where user.class like :type").setParameter("type", "PARENT").executeUpdate();
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

	private void eraseVaccineData(Class clazz) {
		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query queryDeleteVaccinations = em.createQuery("delete from Vaccination where vaccine_id in (select id from Vaccine)");
		queryDeleteVaccinations.executeUpdate();
		Query query = em.createNativeQuery("delete from Vaccine");
		query.executeUpdate();

		tx.commit();
	}

}

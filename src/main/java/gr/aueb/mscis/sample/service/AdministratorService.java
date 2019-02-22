package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.enums.PrivilegeLevel;
import gr.aueb.mscis.sample.model.Address;
import gr.aueb.mscis.sample.model.Administrator;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AdministratorService {

	private EntityManager em;

	public AdministratorService() {
		em = JPAUtil.getCurrentEntityManager();
	}

	public Administrator createAdministrator(final String firstName,final String lastName,final String userName,final String password,final String phoneNumber,
											 final String email,final String vatNumber, final Address address,final PrivilegeLevel privilegeLevel) {

		em = JPAUtil.getCurrentEntityManager();
		Administrator newAdmin = new Administrator(firstName, lastName, userName, password, phoneNumber,
				email, vatNumber, address, privilegeLevel);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(newAdmin);
		tx.commit();

		return newAdmin;
	}

	public Administrator updateAdministratorPassword(final String password,final Administrator administrator) {

		administrator.setPassword(password);
		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(administrator);
		tx.commit();

		return administrator;
	}

	public Administrator updateAdministratorPrivilege(final PrivilegeLevel level,final Administrator administrator) {

		administrator.setPrivilege(level);
		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(administrator);
		tx.commit();

		return administrator;
	}

	public Administrator findAdminByUsername(String username) {
		List<Administrator> results = new ArrayList<>();

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String queryString = "from User user where user.userName= :user_name and user.class like :usertype";
		Query query = em.createQuery(queryString);
		query.setParameter("user_name", username);
		query.setParameter("usertype", "ADMIN");
		results = (List<Administrator>) query.getResultList();
		tx.commit();
		return results.get(0);
	}

	public List<Administrator> findAll(){
		List<Administrator> results = new ArrayList<>();

		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String queryString = "from User user  where user.class like :type";
		Query query = em.createQuery(queryString);
		query.setParameter("type", "ADMIN");
		results = (List<Administrator>) query.getResultList();
		tx.commit();

		return  results;
	}
}

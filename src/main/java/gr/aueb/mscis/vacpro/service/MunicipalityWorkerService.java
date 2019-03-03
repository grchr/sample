package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.helper.UserDataValidator;
import gr.aueb.mscis.vacpro.model.Address;
import gr.aueb.mscis.vacpro.model.MunicipalityWorker;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * The type Municipality worker service.
 */
public class MunicipalityWorkerService {

	/**
	 * The Em.
	 */
	private EntityManager em;

	/**
	 * Instantiates a new Municipality worker service.
	 */
	public MunicipalityWorkerService() {
		em = JPAUtil.getCurrentEntityManager();
	}

	/**
	 * Create municipality worker municipality worker.
	 *
	 * @param firstName      the first name
	 * @param lastName       the last name
	 * @param userName       the user name
	 * @param password       the password
	 * @param phoneNumber    the phone number
	 * @param email          the email
	 * @param vatNumber      the vat number
	 * @param registryOffice the registry office
	 * @param address        the address
	 * @return the municipality worker
	 */
	public MunicipalityWorker createMunicipalityWorker(final String firstName, final String lastName, final String userName,
													   final String password, final String phoneNumber, final String email,
													   final String vatNumber, final String registryOffice, final Address address) {

		em = JPAUtil.getCurrentEntityManager();
		if (UserDataValidator.isValidEmailFormat(email)) {
			System.out.println("VALID EMAIL FORMAT");
		}
		if (UserDataValidator.isValidPhoneNumber(phoneNumber)) {
			System.out.println("VALID PHONE NUMBER");
		}
		if (UserDataValidator.isValidVATNumber(vatNumber)) {
			System.out.println("VALID VAT NUMBER");
		}
		MunicipalityWorker newMunWorker = new MunicipalityWorker(firstName, lastName, userName, password,
																phoneNumber, email, address, vatNumber, registryOffice);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(newMunWorker);
		tx.commit();

		return newMunWorker;
	}

	/**
	 * Update municipality worker municipality worker.
	 *
	 * @param firstName          the first name
	 * @param lastName           the last name
	 * @param userName           the user name
	 * @param password           the password
	 * @param phoneNumber        the phone number
	 * @param email              the email
	 * @param vatNumber          the vat number
	 * @param registryOffice     the registry office
	 * @param municipalityWorker the municipality worker
	 * @return the municipality worker
	 */
	public MunicipalityWorker updateMunicipalityWorker(final String firstName, final String lastName, final String userName,
													   final String password, final String phoneNumber, final String email,
													   final String vatNumber, final String registryOffice,
													   final MunicipalityWorker municipalityWorker) {

		if (firstName != null) {
			municipalityWorker.setFirstName(firstName);
		}
		if (lastName != null) {
			municipalityWorker.setLastName(lastName);
		}
		if (userName != null) {
			municipalityWorker.setUserName(userName);
		}
		if (password != null) {
			municipalityWorker.setPassword(password);
		}
		if (phoneNumber != null) {
			municipalityWorker.setPhoneNumber(phoneNumber);
		}
		if (email != null) {
			municipalityWorker.setEmail(email);
		}
		if (vatNumber != null) {
			municipalityWorker.setVatNumber(vatNumber);
		}
		if (registryOffice != null) {
			municipalityWorker.setRegistryOffice(registryOffice);
		}
		em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(municipalityWorker);
		tx.commit();

		return municipalityWorker;
	}
}

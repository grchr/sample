package gr.aueb.mscis.sample.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The type Municipality worker.
 */
@Entity
@DiscriminatorValue("MUN_W")
public class MunicipalityWorker extends User {

	@Column(name = "reg_office")
	private String registryOffice;

	/**
	 * Instantiates a new Municipality worker.
	 */
	public MunicipalityWorker() {
		super();
	}

	/**
	 * Instantiates a new Municipality worker.
	 *
	 * @param fistName       the fist name
	 * @param lastName       the last name
	 * @param userName       the user name
	 * @param password       the password
	 * @param phoneNumber    the phone number
	 * @param email          the email
	 * @param address        the address
	 * @param vatNumber      the vat number
	 * @param registryOffice the registry office
	 */
	public MunicipalityWorker(final String fistName, final String lastName, final String userName, final String password,
							  final String phoneNumber, final String email, final Address address, final String vatNumber, final String registryOffice) {
		super(fistName, lastName, userName, password, phoneNumber, email, address, vatNumber);
		this.registryOffice = registryOffice;
	}

	/**
	 * Gets registry office.
	 *
	 * @return the registry office
	 */
	public String getRegistryOffice() {
		return registryOffice;
	}

	/**
	 * Sets registry office.
	 *
	 * @param registryOffice the registry office
	 */
	public void setRegistryOffice(final String registryOffice) {
		this.registryOffice = registryOffice;
	}

	@Override
	public String toString() {
		return "id: " + this.getId() + " name: " + this.getFistName() + " " + this.getLastName() + " office: " + this.getRegistryOffice();
	}
}

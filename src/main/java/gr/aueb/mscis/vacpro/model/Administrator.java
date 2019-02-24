package gr.aueb.mscis.vacpro.model;

import gr.aueb.mscis.vacpro.enums.PrivilegeLevel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * The type Administrator.
 */
@Entity
@DiscriminatorValue("ADMIN")
public class Administrator extends User {

	@Enumerated(EnumType.STRING)
	@Column(name = "privilege")
	private PrivilegeLevel privilege;

	/**
	 * Instantiates a new Administrator.
	 */
	public Administrator() {
		super();
	}

	/**
	 * Instantiates a new Administrator.
	 *
	 * @param fistName  the fist name
	 * @param lastName  the last name
	 * @param privilege the privilege
	 */
	public Administrator(final String fistName, final String lastName, final PrivilegeLevel privilege) {
		super(fistName, lastName);
		this.privilege = privilege;
	}

	/**
	 * Instantiates a new Administrator.
	 *
	 * @param fistName    the fist name
	 * @param lastName    the last name
	 * @param userName    the user name
	 * @param password    the password
	 * @param phoneNumber the phone number
	 * @param email       the email
	 * @param vatNumber   the vat number
	 * @param address     the address
	 * @param privilege   the privilege
	 */
	public Administrator(final String fistName, final String lastName, final String userName, final String password,
						 final String phoneNumber, final String email, final String vatNumber, final Address address,
						 final PrivilegeLevel privilege) {
		super(fistName, lastName, userName, password, phoneNumber, email, address, vatNumber);
		this.privilege = privilege;
	}

	/**
	 * Gets privilege.
	 *
	 * @return the privilege
	 */
	public PrivilegeLevel getPrivilege() {
		return privilege;
	}

	/**
	 * Sets privilege.
	 *
	 * @param privilege the privilege
	 */
	public void setPrivilege(final PrivilegeLevel privilege) {
		this.privilege = privilege;
	}

	@Override
	public String toString() {
		return "id: " + this.getId() + " name: " + this.getFistName() + " " + this.getLastName()
				+ " privilege level: " + this.getPrivilege();
	}
}

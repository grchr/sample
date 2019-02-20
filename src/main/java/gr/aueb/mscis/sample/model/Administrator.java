package gr.aueb.mscis.sample.model;

import gr.aueb.mscis.sample.enums.PrivilegeLevel;

import javax.persistence.*;

/**
 * The type Administrator.
 */
@Entity
@DiscriminatorValue("ADMIN")
public class Administrator extends User {

	@Enumerated(EnumType.STRING)
	@Column(name = "privilege")
	private PrivilegeLevel privilege;

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
	public Administrator(String fistName, String lastName, PrivilegeLevel privilege) {
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
	 * @param privilege   the privilege
	 */
	public Administrator(String fistName, String lastName, String userName, String password, String phoneNumber, String email, String vatNumber, PrivilegeLevel privilege) {
		super(fistName, lastName, userName, password, phoneNumber, email, vatNumber);
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
	public void setPrivilege(PrivilegeLevel privilege) {
		this.privilege = privilege;
	}

	@Override
	public String toString() {
		return "id: " + this.getId() + " name: " + this.getFistName() + " " + this.getLastName() + " privilege level: " + this.getPrivilege();
	}
}

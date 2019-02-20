package gr.aueb.mscis.sample.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * The type User.
 */
@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name = "type",
		discriminatorType = DiscriminatorType.STRING
)
public abstract class User implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "first_name")
	private String fistName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@Embedded
	private Address address;

	@Column(name = "VAT_number")
	private String vatNumber;

	/**
	 * Instantiates a new User.
	 */
	public User() {

	}

	/**
	 * Instantiates a new User.
	 *
	 * @param fistName    the fist name
	 * @param lastName    the last name
	 * @param userName    the user name
	 * @param password    the password
	 * @param phoneNumber the phone number
	 * @param email       the email
	 * @param address     the address
	 * @param vatNumber   the vat number
	 */
	public User(final String fistName, final String lastName, final String userName, final String password, final String phoneNumber,
				final String email, final Address address, final String vatNumber) {
		this.fistName = fistName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.vatNumber = vatNumber;
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets fist name.
	 *
	 * @return the fist name
	 */
	public String getFistName() {
		return fistName;
	}

	/**
	 * Sets fist name.
	 *
	 * @param fistName the fist name
	 */
	public void setFistName(final String fistName) {
		this.fistName = fistName;
	}

	/**
	 * Gets last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets last name.
	 *
	 * @param lastName the last name
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets user name.
	 *
	 * @param userName the user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets password.
	 *
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets phone number.
	 *
	 * @param phoneNumber the phone number
	 */
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets email.
	 *
	 * @param email the email
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Gets vat number.
	 *
	 * @return the vat number
	 */
	public String getVatNumber() {
		return vatNumber;
	}

	/**
	 * Sets vat number.
	 *
	 * @param vatNumber the vat number
	 */
	public void setVatNumber(final String vatNumber) {
		this.vatNumber = vatNumber;
	}

	/**
	 * Gets address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets address.
	 *
	 * @param address the address
	 */
	public void setAddress(final Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "{\"User\":{"
				+ "\"id\":\"" + id + "\""
				+ ",\"fistName\":" + fistName + "\""
				+ ",\"lastName\":" + lastName + "\""
				+ ",\"userName\":" + userName + "\""
				+ ",\"password\":" + password + "\""
				+ ",\"phoneNumber\":" + phoneNumber + "\""
				+ ",\"email\":" + email + "\""
				+ ",\"address\":" + address
				+ ",\"vatNumber\":" + vatNumber + "\""
				+ "}}";
	}
}

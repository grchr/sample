package gr.aueb.mscis.vacpro.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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
@SequenceGenerator(name="user_seq", initialValue = 1, allocationSize = 1)
public abstract class User implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private int id;

	@Column(name = "first_name")
	private String firstName;

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
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	protected User(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Instantiates a new User.
	 *
	 * @param firstName    the first name
	 * @param lastName    the last name
	 * @param phoneNumber the phone number
	 * @param email       the email
	 * @param vatNumber   the vat number
	 */
	protected User(final String firstName, final String lastName, final String phoneNumber, final String email, final String vatNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.vatNumber = vatNumber;
	}


	/**
	 * Instantiates a new User.
	 *
	 * @param firstName    the first name
	 * @param lastName    the last name
	 * @param userName    the user name
	 * @param password    the password
	 * @param phoneNumber the phone number
	 * @param email       the email
	 * @param address     the address
	 * @param vatNumber   the vat number
	 */
	public User(final String firstName, final String lastName, final String userName, final String password, final String phoneNumber,
				final String email, final Address address, final String vatNumber) {
		this.firstName = firstName;
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
	 * Gets first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name.
	 *
	 * @param firstName the first name
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
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
	public void setUserName(final String userName) {
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
	public void setPassword(final String password) {
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
	public boolean equals(final Object o) {
		if (this == o){
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return getId() == user.getId()
				&& Objects.equals(getFirstName(), user.getFirstName())
				&& Objects.equals(getLastName(), user.getLastName())
				&& Objects.equals(getUserName(), user.getUserName());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getId(), getFirstName(), getLastName(), getUserName());
	}

	@Override
	public String toString() {
		return "{\"User\":{"
				+ "\"id\":\"" + id + "\""
				+ ",\"firstName\":" + firstName + "\""
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

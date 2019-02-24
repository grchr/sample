package gr.aueb.mscis.vacpro.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Parent.
 */
@Entity
@DiscriminatorValue("PARENT")
public class Parent extends User {

	@Column(name = "insurance_number")
	private String insuranceNumber;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Child> children;

	/**
	 * Instantiates a new Parent.
	 */
	public Parent() {
		super();
	}

	/**
	 * Instantiates a new Parent.
	 *
	 * @param name            the name
	 * @param lastName        the last name
	 * @param phoneNumber     the phone number
	 * @param insuranceNumber the insurance number
	 * @param email           the email
	 * @param vatNumber       the vat number
	 */
	public Parent(final String name, final String lastName, final String phoneNumber, final String insuranceNumber,
				  final String email, final String vatNumber) {
		super(name, lastName, phoneNumber, email, vatNumber);
		this.insuranceNumber = insuranceNumber;
	}

	/**
	 * /**
	 * Instantiates a new Parent.
	 *
	 * @param fistName        the fist name
	 * @param lastName        the last name
	 * @param userName        the user name
	 * @param password        the password
	 * @param phoneNumber     the phone number
	 * @param email           the email
	 * @param address         the address
	 * @param vatNumber       the vat number
	 * @param insuranceNumber the insurance number
	 * @param children        the children
	 */
	public Parent(final String fistName, final String lastName, final String userName, final String password,
				  final String phoneNumber, final String email, final Address address, final String vatNumber,
				  final String insuranceNumber, final List<Child> children) {
		super(fistName, lastName, userName, password, phoneNumber, email, address, vatNumber);
		this.insuranceNumber = insuranceNumber;
		this.children = children;
	}

	/**
	 * Gets insurance number.
	 *
	 * @return the insurance number
	 */
	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	/**
	 * Sets insurance number.
	 *
	 * @param insuranceNumber the insurance number
	 */
	public void setInsuranceNumber(final String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	/**
	 * Gets children.
	 *
	 * @return the children
	 */
	public List<Child> getChildren() {
		if (children == null) {
			children = new ArrayList<>();
		}
		return children;
	}

	/**
	 * `
	 * Sets children.
	 *
	 * @param children the children
	 */
	public void setChildren(final List<Child> children) {
		this.children = children;
	}
}

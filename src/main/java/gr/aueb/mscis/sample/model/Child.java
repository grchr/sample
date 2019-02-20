package gr.aueb.mscis.sample.model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * The type Child.
 */
@Entity
@Table(name = "Child")
public class Child implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "age")
	private Date age;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	private Parent parent;

	/**
	 * Instantiates a new Child.
	 */
	public Child() {
	}

	/**
	 * Instantiates a new Child.
	 *
	 * @param name    the name
	 * @param surname the surname
	 * @param age     the age
	 * @param parent  the parent
	 */
	public Child(final String name, final String surname, final Date age, final Parent parent) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.parent = parent;
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
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets surname.
	 *
	 * @param surname the surname
	 */
	public void setSurname(final String surname) {
		this.surname = surname;
	}

	/**
	 * Gets age.
	 *
	 * @return the age
	 */
	public Date getAge() {
		return age;
	}

	/**
	 * Sets age.
	 *
	 * @param age the age
	 */
	public void setAge(final Date age) {
		this.age = age;
	}

	/**
	 * Gets parent.
	 *
	 * @return the parent
	 */
	public Parent getParent() {
		return parent;
	}

	/**
	 * Sets parent.
	 *
	 * @param parent the parent
	 */
	public void setParent(final Parent parent) {
		this.parent = parent;
	}


	@Override
	public String toString() {
		return "{\"Child\":{"
				+ "\"id\":\"" + id + "\""
				+ ",\"name\":" + name + "\""
				+ ",\"surname\":" + surname + "\""
				+ ",\"age\":" + age
				+ ",\"parent\":" + parent
				+ "}}";
	}
}

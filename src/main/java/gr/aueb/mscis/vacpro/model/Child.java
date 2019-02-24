package gr.aueb.mscis.vacpro.model;


import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

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
	private Date birthday;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = false)
	private Parent parent;

	/**
	 * Instantiates a new Child.
	 */
	public Child() {
	}

	/**
	 * Instantiates a new Child.
	 *
	 * @param name     the name
	 * @param surname  the surname
	 * @param birthday the age
	 */
	public Child(final String name, final String surname, final Date birthday) {
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}

	/**
	 * Instantiates a new Child.
	 *
	 * @param name     the name
	 * @param surname  the surname
	 * @param birthday the age
	 * @param parent   the parent
	 */
	public Child(final String name, final String surname, final Date birthday, final Parent parent) {
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
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
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets age.
	 *
	 * @param birthday the birthday
	 */
	public void setBirthday(final Date birthday) {
		this.birthday = birthday;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Child child = (Child) o;
		return getId() == child.getId() &&
				Objects.equals(getName(), child.getName()) &&
				Objects.equals(getSurname(), child.getSurname()) &&
				Objects.equals(getParent(), child.getParent());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getId(), getName(), getSurname(), getParent());
	}

	@Override
	public String toString() {
		return "{\"Child\":{"
				+ "\"id\":\"" + id + "\""
				+ ",\"name\":" + name + "\""
				+ ",\"surname\":" + surname + "\""
				+ ",\"birthday\":" + birthday
				+ ",\"parent\":" + parent
				+ "}}";
	}
}

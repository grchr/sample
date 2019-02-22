package gr.aueb.mscis.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

/**
 * The type Vaccination.
 *
 * @author taggelis
 */
@Entity
@Table(name="vaccination")
public class Vaccination {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "child_id", referencedColumnName = "id")
	private Child child;

	@OneToOne
	@JoinColumn(name="vaccine_id", referencedColumnName = "id")
	private Vaccine vaccine;

	@Column(name="notify_date")
	private Date notifyDate;

	@Column(name="vaccinatedTimes")
	private int vaccinatedTimes;


	/**
	 * Instantiates a new Vaccination.
	 */
	public Vaccination() {
	}

	/**
	 * Instantiates a new Vaccination.
	 *
	 * @param child           the child
	 * @param vaccine         the vaccine
	 * @param notifyDate      the notify date
	 * @param vaccinatedTimes the vaccinated times
	 */
	public Vaccination(final Child child, final Vaccine vaccine, final Date notifyDate, final int vaccinatedTimes) {
		this.child = child;
		this.vaccine = vaccine;
		this.notifyDate = notifyDate;
		this.vaccinatedTimes = vaccinatedTimes;
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
	 * Gets child.
	 *
	 * @return the child
	 */
	public Child getChild() {
		return child;
	}

	/**
	 * Sets child.
	 *
	 * @param child the child
	 */
	public void setChild(final Child child) {
		this.child = child;
	}

	/**
	 * Gets vaccine.
	 *
	 * @return the vaccine
	 */
	public Vaccine getVaccine() {
		return vaccine;
	}

	/**
	 * Sets vaccine.
	 *
	 * @param vaccine the vaccine
	 */
	public void setVaccine(final Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	/**
	 * Gets notify date.
	 *
	 * @return the notify date
	 */
	public Date getNotifyDate() {
		return notifyDate;
	}

	/**
	 * Sets notify date.
	 *
	 * @param notifyDate the notify date
	 */
	public void setNotifyDate(final Date notifyDate) {
		this.notifyDate = notifyDate;
	}

	/**
	 * Gets vaccinated times.
	 *
	 * @return the vaccinated times
	 */
	public int getVaccinatedTimes() {
		return vaccinatedTimes;
	}

	/**
	 * Sets vaccinated times.
	 *
	 * @param vaccinatedTimes the vaccinated times
	 */
	public void setVaccinatedTimes(final int vaccinatedTimes) {
		this.vaccinatedTimes = vaccinatedTimes;
	}


	@Override
	public String toString() {
		return "{\"Vaccination\":{"
				+ "\"id\":\"" + id + "\""
				+ ",\"child\":" + child
				+ ",\"vaccine\":" + vaccine
				+ ",\"notifyDate\":" + notifyDate
				+ ",\"vaccinatedTimes\":" + vaccinatedTimes + "\""
				+ "}}";
	}
}
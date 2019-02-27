package gr.aueb.mscis.vacpro.model;


import gr.aueb.mscis.vacpro.enums.VaccinationStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Vaccination.
 *
 * @author taggelis
 */
@Entity
@Table(name = "vaccination")
@SequenceGenerator(name="vaccination_seq", initialValue = 1, allocationSize = 1)
public class Vaccination {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vaccination_seq")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "child_id", referencedColumnName = "id")
	private Child child;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vaccine_id", referencedColumnName = "id")
	private Vaccine vaccine;

	@Column(name = "notify_date")
	private Date notifyDate;

	@Column(name = "status")
	private VaccinationStatus status;

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
	 * @param status          the status
	 */
	public Vaccination(final Child child, final Vaccine vaccine, final Date notifyDate, final VaccinationStatus status) {
		this.child = child;
		this.vaccine = vaccine;
		this.notifyDate = notifyDate;
		this.status = status;
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
	 * Gets status.
	 *
	 * @return the status
	 */
	public VaccinationStatus getStatus() {
		return status;
	}

	/**
	 * Sets status.
	 *
	 * @param status the status
	 */
	public void setStatus(final VaccinationStatus status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "{\"Vaccination\":{"
				+ "\"id\":\"" + id + "\""
				+ ",\"child\":" + child
				+ ",\"vaccine\":" + vaccine
				+ ",\"notifyDate\":" + notifyDate
				+ ",\"status\":" + status + "\""
				+ "}}";
	}
}

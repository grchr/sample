package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.enums.VaccinationStatus;

import java.util.Date;

/**
 * The type Vaccination info.
 *
 * @author taggelis
 */
public class VaccinationInfo {

	private Date vaccinationDate;
	private VaccinationStatus status;

	/**
	 * Instantiates a new Vaccination info.
	 */
	public VaccinationInfo() {
	}

	/**
	 * Instantiates a new Vaccination info.
	 *
	 * @param vaccinationDate the vaccination date
	 * @param status          the status
	 */
	public VaccinationInfo(final Date vaccinationDate, final VaccinationStatus status) {
		this.vaccinationDate = vaccinationDate;
		this.status = status;
	}

	/**
	 * Gets vaccination date.
	 *
	 * @return the vaccination date
	 */
	public Date getVaccinationDate() {
		return vaccinationDate;
	}

	/**
	 * Sets vaccination date.
	 *
	 * @param vaccinationDate the vaccination date
	 */
	public void setVaccinationDate(final Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
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
		return "{\"VaccinationInfo\":{"
				+ "\"vaccinationDate\":\"" + vaccinationDate
				+ ",\"status\":" + status + "\""
				+ "}}";
	}
}

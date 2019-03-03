package gr.aueb.mscis.vacpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The type Vaccine.
 *
 * @author taggelis
 */
@Entity
@Table(name = "vaccine")
@SequenceGenerator(name = "vaccine_seq", initialValue = 1, allocationSize = 1)
public class Vaccine {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vaccine_seq")
	private int id;

	@Column(name = "disease")
	private String disease;

	@Column(name = "vaccination_Age")
	private int vaccinationAge;

	@Column(name = "vaccination_Type")
	private String vaccinationType;

	@Column(name = "number_of_dose")
	private int numberOfDose;

	/**
	 * Instantiates a new Vaccine.
	 */
	public Vaccine() {
	}

	/**
	 * Instantiates a new Vaccine.
	 *
	 * @param disease         the disease
	 * @param vaccinationAge  the vaccination age
	 * @param vaccinationType the vaccination type
	 * @param numberOfDose    the number of dose
	 */
	public Vaccine(final String disease, final int vaccinationAge, final String vaccinationType, final int numberOfDose) {
		this.disease = disease;
		this.vaccinationAge = vaccinationAge;
		this.vaccinationType = vaccinationType;
		this.numberOfDose = numberOfDose;
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
	 * Gets disease.
	 *
	 * @return the disease
	 */
	public String getDisease() {
		return disease;
	}

	/**
	 * Sets disease.
	 *
	 * @param disease the disease
	 */
	public void setDisease(final String disease) {
		this.disease = disease;
	}

	/**
	 * Gets vaccination age.
	 *
	 * @return the vaccination age
	 */
	public int getVaccinationAge() {
		return vaccinationAge;
	}

	/**
	 * Sets vaccination age.
	 *
	 * @param vaccinationAge the vaccination age
	 */
	public void setVaccinationAge(final int vaccinationAge) {
		this.vaccinationAge = vaccinationAge;
	}

	/**
	 * Gets vaccination type.
	 *
	 * @return the vaccination type
	 */
	public String getVaccinationType() {
		return vaccinationType;
	}

	/**
	 * Sets vaccination type.
	 *
	 * @param vaccinationType the vaccination type
	 */
	public void setVaccinationType(final String vaccinationType) {
		this.vaccinationType = vaccinationType;
	}

	/**
	 * Gets number of dose.
	 *
	 * @return the number of dose
	 */
	public int getNumberOfDose() {
		return numberOfDose;
	}

	/**
	 * Sets number of dose.
	 *
	 * @param numberOfDose the number of dose
	 */
	public void setNumberOfDose(final int numberOfDose) {
		this.numberOfDose = numberOfDose;
	}


	@Override
	public String toString() {
		return "{\"Vaccine\":{"
				+ "\"id\":\"" + id + "\""
				+ ",\"disease\":" + disease + "\""
				+ ",\"vaccinationAge\":" + vaccinationAge + "\""
				+ ",\"vaccinationType\":" + vaccinationType + "\""
				+ ",\"numberOfDose\":" + numberOfDose + "\""
				+ "}}";
	}
}

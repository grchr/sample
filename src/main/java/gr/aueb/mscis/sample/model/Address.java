package gr.aueb.mscis.sample.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The type Address.
 *
 * @author taggelis
 */
@Embeddable
public class Address {

	@Column(name = "street")
	private String street;

	@Column(name = "number")
	private String number;

	@Column(name = "city")
	private String city;

	@Column(name = "zipcode")
	private int zipcode;

	@Column(name = "country")
	private String country = "Ελλάδα";

	/**
	 * Instantiates a new Address.
	 */
	public Address() {
	}

	/**
	 * Gets street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets street.
	 *
	 * @param street the street
	 */
	public void setStreet(final String street) {
		this.street = street;
	}

	/**
	 * Gets number.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets number.
	 *
	 * @param number the number
	 */
	public void setNumber(final String number) {
		this.number = number;
	}

	/**
	 * Gets city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets city.
	 *
	 * @param city the city
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	/**
	 * Gets zipcode.
	 *
	 * @return the zipcode
	 */
	public int getZipcode() {
		return zipcode;
	}

	/**
	 * Sets zipcode.
	 *
	 * @param zipcode the zipcode
	 */
	public void setZipcode(final int zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Gets country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets country.
	 *
	 * @param country the country
	 */
	public void setCountry(final String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "{\"Address\":{"
				+ "\"street\":\"" + street + "\""
				+ ",\"number\":" + number + "\""
				+ ",\"city\":" + city + "\""
				+ ",\"zipcode\":" + zipcode + "\""
				+ ",\"country\":" + country + "\""
				+ "}}";
	}
}

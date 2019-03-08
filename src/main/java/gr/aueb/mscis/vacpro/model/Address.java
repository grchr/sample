package gr.aueb.mscis.vacpro.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * The type Address.
 *
 * @author taggelis
 */
@Embeddable
public class Address implements Serializable {

	@Column(name = "street")
	private String street;

	@Column(name = "number")
	private String number;

	@Column(name = "city")
	private String city;

	@Column(name = "zipcode")
	private Integer zipcode;

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

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address address = (Address) o;
		return getZipcode() == address.getZipcode()
				&& Objects.equals(getStreet(), address.getStreet())
				&& Objects.equals(getNumber(), address.getNumber())
				&& Objects.equals(getCity(), address.getCity())
				&& Objects.equals(getCountry(), address.getCountry());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getStreet(), getNumber(), getCity(), getZipcode(), getCountry());
	}
}

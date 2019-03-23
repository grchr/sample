package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Address;

/**
 * The type Municipality worker info.
 */
public class MunicipalityWorkerInfo {

    private Integer id;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String phoneNumber;

    private String email;

    private Address address;

    private String vatNumber;

    private String registryOffice;

    /**
     * Instantiates a new Municipality worker info.
     */
    public MunicipalityWorkerInfo(){

    }

    /**
     * Instantiates a new Municipality worker info.
     *
     * @param id             the id
     * @param firstName      the first name
     * @param lastName       the last name
     * @param userName       the user name
     * @param password       the password
     * @param phoneNumber    the phone number
     * @param email          the email
     * @param address        the address
     * @param vatNumber      the vat number
     * @param registryOffice the registry office
     */
    public MunicipalityWorkerInfo(final Integer id, final String firstName, final String lastName, final String userName, final String password,
                                  final String phoneNumber, final String email, final Address address,
                                  final String vatNumber, final String registryOffice) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.vatNumber = vatNumber;
        this.registryOffice = registryOffice;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final Integer id) {
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
     * Gets registry office.
     *
     * @return the registry office
     */
    public String getRegistryOffice() {
        return registryOffice;
    }

    /**
     * Sets registry office.
     *
     * @param registryOffice the registry office
     */
    public void setRegistryOffice(final String registryOffice) {
        this.registryOffice = registryOffice;
    }
}

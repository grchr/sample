package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.enums.PrivilegeLevel;
import gr.aueb.mscis.vacpro.model.Address;

public class AdministratorInfo {

    private Integer id;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String phoneNumber;

    private String email;

    private Address address;

    private String vatNumber;

    private PrivilegeLevel privilege;

    public AdministratorInfo(){

    }

    public AdministratorInfo(Integer id, String firstName, String lastName, String userName, String password, String phoneNumber, String email, Address address, String vatNumber, PrivilegeLevel privilege) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.vatNumber = vatNumber;
        this.privilege = privilege;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public PrivilegeLevel getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeLevel privilege) {
        this.privilege = privilege;
    }
}

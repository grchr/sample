package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Address;

import java.util.List;

public class ParentInfo {

    private Integer id;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String phoneNumber;

    private String email;

    private Address address;

    private String vatNumber;

    private String insuranceNumber;

    private List<ChildrenInfo> children;

    public ParentInfo() {}

    public ParentInfo(Integer id, String firstName, String lastName, String userName, String password, String phoneNumber, String email, Address address, String vatNumber, String insuranceNumber, List<ChildrenInfo> children) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.vatNumber = vatNumber;
        this.insuranceNumber = insuranceNumber;
        this.children = children;
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

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public List<ChildrenInfo> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenInfo> children) {
        this.children = children;
    }
}

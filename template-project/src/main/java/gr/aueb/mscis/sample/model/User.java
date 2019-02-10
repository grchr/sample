package gr.aueb.mscis.sample.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "type",
        discriminatorType = DiscriminatorType.STRING
)

public class User implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="first_name")
    private String fistName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="VAT_number")
    private String vatNumber;

    public User(){

    }

    public User(String firstName, String lastName) {
        this.fistName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, String phoneNumber, String email, String vatNumber) {
        this.fistName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vatNumber = vatNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                '}';
    }
}

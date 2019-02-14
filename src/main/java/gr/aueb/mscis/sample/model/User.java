package gr.aueb.mscis.sample.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.io.Serializable;

//TODO: turn user into abstract and remove usertest and userservicetest

/**
 * The type User.
 */
@Entity
@Table(name="User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "type",
        discriminatorType = DiscriminatorType.STRING
)
public class User implements Serializable {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name= "first_name")
    private String fistName;

    @Column(name= "last_name")
    private String lastName;

    @Column(name= "phone_number")
    private String phoneNumber;

    @Column(name= "email")
    private String email;

    @Column(name= "VAT_number")
    private String vatNumber;

    /**
     * Instantiates a new User.
     */
    public User(){

    }

    /**
     * Instantiates a new User.
     *
     * @param fistName the fist name
     * @param lastName the last name
     */
    public User(final String fistName, final String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }

    /**
     * Instantiates a new User.
     *
     * @param fistName    the fist name
     * @param lastName    the last name
     * @param phoneNumber the phone number
     * @param email       the email
     * @param vatNumber   the vat number
     */
    public User(final String fistName, final String lastName, final String phoneNumber, final String email, final String vatNumber) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vatNumber = vatNumber;
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
     * Gets fist name.
     *
     * @return the fist name
     */
   public String getFistName() {
        return fistName;
    }

    /**
     * Sets fist name.
     *
     * @param fistName the fist name
     */
    public void setFistName(final String fistName) {
        this.fistName = fistName;
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
}

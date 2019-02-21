package gr.aueb.mscis.sample.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Parent.
 */
@Entity
@DiscriminatorValue("PARENT")
public class Parent extends User{

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Child> children;

    /**
     * Instantiates a new Parent.
     */
    public Parent(){
        super();
    }

    /**
     * Instantiates a new Parent.
     *
     * @param name            the name
     * @param lastName        the last name
     * @param phoneNumber     the phone number
     * @param insuranceNumber the insurance number
     * @param email           the email
     * @param vatNumber       the vat number
     */
    public Parent(String name, String lastName, String phoneNumber, String insuranceNumber, String email
            , String vatNumber) {
        super(name, lastName, phoneNumber, email, vatNumber);
        this.insuranceNumber = insuranceNumber;
    }

    public Parent(String name, String lastName, String userName, String password, String phoneNumber, String insuranceNumber, String email
            , String vatNumber) {
        super(name, lastName, userName, password, phoneNumber, email, vatNumber);
        this.insuranceNumber = insuranceNumber;
    }

    /**
     * Gets insurance number.
     *
     * @return the insurance number
     */
    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    /**
     * Sets insurance number.
     *
     * @param insuranceNumber the insurance number
     */
    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    /**
     * Gets children.
     *
     * @return the children
     */
    public List<Child> getChildren() {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    /**
     * Sets children.
     *
     * @param children the children
     */
    public void setChildren(List<Child> children) {
        this.children = children;
    }
}

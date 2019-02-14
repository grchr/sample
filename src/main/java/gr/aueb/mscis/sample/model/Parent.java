package gr.aueb.mscis.sample.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Parent")
public class Parent extends User{

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Child> children;

    public Parent(){
        super();
    }

    public Parent(String name, String lastName, String phoneNumber, String insuranceNumber, String email
            , String vatNumber) {
        super(name, lastName, phoneNumber, email, vatNumber);
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public List<Child> getChildren() {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}

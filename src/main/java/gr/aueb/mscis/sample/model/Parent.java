package gr.aueb.mscis.sample.model;


import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("PARENT")
public class Parent extends User{

    @Column(name = "insurance_number")
    private String insuranceNumber;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "child_id")
    private List<Child> child;

}

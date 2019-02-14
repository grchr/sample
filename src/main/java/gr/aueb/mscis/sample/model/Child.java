package gr.aueb.mscis.sample.model;


import javax.persistence.*;

@Entity
@Table(name="Child")
public class Child {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

}

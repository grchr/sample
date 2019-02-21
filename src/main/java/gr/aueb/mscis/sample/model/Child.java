package gr.aueb.mscis.sample.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Child.
 */
@Entity
@Table(name="Child")
public class Child implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="parent_id", referencedColumnName = "id", nullable = false)
    private Parent parent;

    /**
     * Instantiates a new Child.
     */
    public Child(){
    }

    /**
     * Instantiates a new Child.
     *
     * @param name    the name
     * @param surname the surname
     */
    public Child(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Instantiates a new Child.
     *
     * @param name    the name
     * @param surname the surname
     * @param parent  the parent
     */
    public Child(String name, String surname, Parent parent) {
        this.name = name;
        this.surname = surname;
        this.parent = parent;
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
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets parent.
     *
     * @return the parent
     */
    public Parent getParent() {
        return parent;
    }

    /**
     * Sets parent.
     *
     * @param parent the parent
     */
    public void setParent(Parent parent) {
        this.parent = parent;
    }
}

package gr.aueb.mscis.sample.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="User")
public class User implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="first_name")
    private String fistName;

    @Column(name="last_name")
    private String lastName;

    public User(){

    }

    public User(String firstName, String lastName) {
        this.fistName = firstName;
        this.lastName = lastName;
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
}

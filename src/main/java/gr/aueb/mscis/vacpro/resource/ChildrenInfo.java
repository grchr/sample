package gr.aueb.mscis.vacpro.resource;

import java.util.Date;

public class ChildrenInfo {

    private Integer id;

    private String name;

    private String surname;

    private Date birthday;

    private ParentInfo parent;

    public ChildrenInfo(){}

    public ChildrenInfo(Integer id, String name, String surname, Date birthday, ParentInfo parent) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ParentInfo getParent() {
        return parent;
    }

    public void setParent(ParentInfo parent) {
        this.parent = parent;
    }
}

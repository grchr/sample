package gr.aueb.mscis.vacpro.resource;

import java.util.Date;

/**
 * The type Children info.
 */
public class ChildrenInfo {

    private Integer id;

    private String name;

    private String surname;

    private Date birthday;

    private ParentInfo parent;

    /**
     * Instantiates a new Children info.
     */
    public ChildrenInfo(){}

    /**
     * Instantiates a new Children info.
     *
     * @param id       the id
     * @param name     the name
     * @param surname  the surname
     * @param birthday the birthday
     * @param parent   the parent
     */
    public ChildrenInfo(final Integer id, final  String name, final String surname, final Date birthday, final ParentInfo parent) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.parent = parent;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final Integer id) {
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
    public void setName(final String name) {
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
    public void setSurname(final String surname) {
        this.surname = surname;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets parent.
     *
     * @return the parent
     */
    public ParentInfo getParent() {
        return parent;
    }

    /**
     * Sets parent.
     *
     * @param parent the parent
     */
    public void setParent(final ParentInfo parent) {
        this.parent = parent;
    }
}

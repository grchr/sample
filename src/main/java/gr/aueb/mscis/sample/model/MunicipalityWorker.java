package gr.aueb.mscis.sample.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The type Municipality worker.
 */
@Entity
@DiscriminatorValue("MUN_W")
public class MunicipalityWorker extends User {

    @Column(name="reg_office")
    private String registryOffice;

    /**
     * Instantiates a new Municipality worker.
     */
    public MunicipalityWorker(){
        super();
    }

    /**
     * Instantiates a new Municipality worker.
     *
     * @param firstNamne     the first namne
     * @param lastName       the last name
     * @param registryOffice the registry office
     */
    public MunicipalityWorker( String firstNamne, String lastName, String registryOffice) {
        super(firstNamne, lastName);
        this.registryOffice = registryOffice;
    }

    public MunicipalityWorker(String firstName, String lastName, String userName, String password, String phoneNumber, String email, String vatNumber, String registryOffice) {
        super(firstName, lastName, userName, password, phoneNumber, email, vatNumber);
        this.registryOffice = registryOffice;
    }

    /**
     * Gets registry office.
     *
     * @return the registry office
     */
    public String getRegistryOffice() {
        return registryOffice;
    }

    /**
     * Sets registry office.
     *
     * @param registryOffice the registry office
     */
    public void setRegistryOffice(final String registryOffice) {
        this.registryOffice = registryOffice;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + " name: " + this.getFistName() + " " + this.getLastName() + " office: " + this.getRegistryOffice();
    }
}

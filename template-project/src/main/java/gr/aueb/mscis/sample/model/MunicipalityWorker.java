package gr.aueb.mscis.sample.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MUN_W")
public class MunicipalityWorker extends User {

    @Column(name="reg_office")
    String registryOffice;

    public MunicipalityWorker(){

    }

    public MunicipalityWorker(String firstNamne, String lastName, String registryOffice) {
        super(firstNamne, lastName);
        this.registryOffice = registryOffice;
    }

    public String getRegistryOffice() {
        return registryOffice;
    }

    public void setRegistryOffice(String registryOffice) {
        this.registryOffice = registryOffice;
    }
}

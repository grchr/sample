package gr.aueb.mscis.sample.controllers;

import gr.aueb.mscis.sample.enums.PrivilegeLevel;
import gr.aueb.mscis.sample.model.Administrator;

import javax.persistence.EntityManager;

public class UserController {

    private EntityManager em;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private String vatNumber;
    private String insuraneNumber;
    private String registryOffice;
    private PrivilegeLevel privilegeLevel;

    public void signUpUser(String firstName, String lastName, String userName, String password, String phoneNumber, String email, String vatNumber,
                           String insuranceNumber, String registryOffice, PrivilegeLevel privilegeLevel, boolean isAdmin, boolean isParent, boolean isMunWorker){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vatNumber = vatNumber;
        this.insuraneNumber = insuranceNumber;
        this.registryOffice = registryOffice;
        this.privilegeLevel = privilegeLevel;
        int admin = isAdmin ? 1 : 0;
        int parent = isParent ? 1 : 0;
        int munWorker = isMunWorker ? 1 : 0;
        if ((admin+parent+munWorker) > 1 || (admin+parent+munWorker) == 0) {
            System.err.println("A user can be only of one type: parent, administrator or municipality worker");
        } else {
            if (isAdmin) {
                signUpAdmin();
            }
            if (isMunWorker){
                signUpMunWorker();
            }
            if (isParent) {
                signUpParent();
            }
        }

    }

    public void signUpAdmin(){
        Administrator admin = new Administrator(firstName, lastName, userName, password, )
    }

    public void signUpParent(){

    }

    public void signUpMunWorker(){

    }
}

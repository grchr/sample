package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.User;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserService {

    EntityManager em;

    public UserService() {
        em = JPAUtil.getCurrentEntityManager();
    }

    public User createUser(String firstName, String lastName){

        if (firstName == null) {
            //TODO: create custom exception
        }
        if (lastName == null) {
            //TODO: create custom exception
        }

        User newUser = new User(firstName, lastName);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newUser);
        tx.commit();

        return newUser;

    }

    public User createUser(String firstName, String lastName, String phoneNumber, String email, String vatNumber) {

        User newUser = new User(firstName, lastName, phoneNumber, email, vatNumber);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newUser);
        tx.commit();

        return newUser;
    }
}

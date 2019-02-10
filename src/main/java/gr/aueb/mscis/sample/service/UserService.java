package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.User;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * The type User service.
 */
public class UserService {

    /**
     * The Em.
     */
    private EntityManager em;

    /**
     * Instantiates a new User service.
     */
    public UserService() {
        em = JPAUtil.getCurrentEntityManager();
    }

    /**
     * Create user user.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @return the user
     */
    public User createUser(final String firstName, final String lastName){

//        if (firstName == null) {
//        }
//        if (lastName == null) {
//        }

        User newUser = new User(firstName, lastName);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newUser);
        tx.commit();

        return newUser;
    }

    /**
     * Create user user.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param phoneNumber the phone number
     * @param email       the email
     * @param vatNumber   the vat number
     * @return the user
     */
    public User createUser(final String firstName, final String lastName, final String phoneNumber, final String email
            ,final String vatNumber) {

        User newUser = new User(firstName, lastName, phoneNumber, email, vatNumber);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newUser);
        tx.commit();

        return newUser;
    }
}

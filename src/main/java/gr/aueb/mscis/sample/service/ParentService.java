package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.Child;
import gr.aueb.mscis.sample.model.Parent;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * The type Parent service.
 */
public class ParentService{

    private EntityManager em;

    /**
     * Instantiates a new Parent service.
     */
    public ParentService(){
        em = JPAUtil.getCurrentEntityManager();
    }

    /**
     * Create parent parent.
     *
     * @param name            the name
     * @param lastName        the last name
     * @param phoneNumber     the phone number
     * @param email           the email
     * @param vatNumber       the vat number
     * @param insuranceNumber the insurance number
     * @param children        the children
     * @return the parent
     */
    public Parent createParent(final String name, final String lastName, final String userName, final String password, final String phoneNumber , final String email
            , final String vatNumber, final String insuranceNumber, List<Child> children) {
        Parent newParent = new Parent(name, lastName, userName, password, phoneNumber, email, vatNumber, insuranceNumber);
        if (children != null) {
            newParent.setChildren(children);
            for (Child child : children) {
                child.setParent(newParent);
            }
        }
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newParent);
        tx.commit();

        return newParent;
    }

    public Parent updateParent(final String firstName, final String lastName, final String userName, final String password, final String phoneNumber , final String email
            , final String vatNumber, final String insuranceNumber, List<Child> children, Parent parent) {

        if (firstName != null) {
            parent.setFistName(firstName);
        }
        if (lastName != null) {
            parent.setLastName(lastName);
        }
        if (userName != null) {
            parent.setUserName(userName);
        }
        if (password != null) {
            parent.setPassword(password);
        }
        if (phoneNumber != null) {
            parent.setPhoneNumber(phoneNumber);
        }
        if (email != null) {
            parent.setEmail(email);
        }
        if (vatNumber != null) {
            parent.setVatNumber(vatNumber);
        }
        if (children != null) {
            parent.setChildren(children);
        }

        em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(parent);
        tx.commit();

        return parent;
    }

}

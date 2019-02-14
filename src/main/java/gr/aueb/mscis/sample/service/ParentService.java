package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.Child;
import gr.aueb.mscis.sample.model.Parent;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ParentService{

    private EntityManager em;

    public ParentService(){
        em = JPAUtil.getCurrentEntityManager();
    }

    public Parent createParent(final String name, final String lastName, final String phoneNumber , final String email
            , final String vatNumber, final String insuranceNumber, List<Child> children) {
        Parent newParent = new Parent(name,lastName, phoneNumber, email, vatNumber, insuranceNumber);
        if (children!=null) {
            newParent.setChildren(children);
        }
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newParent);
        tx.commit();

        return newParent;
    }

}

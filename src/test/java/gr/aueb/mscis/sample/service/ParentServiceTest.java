package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.Administrator;
import gr.aueb.mscis.sample.model.Child;
import gr.aueb.mscis.sample.model.Parent;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

public class ParentServiceTest {

    private EntityManager em;

    @After
    public void tearDown(){
        em.close();
    }

    @Before
    public void setup(){
        // prepare database for each test
        em = JPAUtil.getCurrentEntityManager();
        Initializer dataHelper = new Initializer();
        //dataHelper.prepareUserData();
    }

    @Test
    public void testPersistAValidParentService() {

        ParentService parentService = new ParentService();
        Parent parent = parentService.createParent("Dimitris", "Diamantidis", "3D", "password",
                "69", "123", "pao@bc.com", "1234", null);
        Child child1 = new Child("Vasilis", "Spanoulis");
        child1.setParent(parent);
        parent.getChildren().add(child1);
        System.out.println(child1.getParent());
        System.out.println(parent.getId());

        em = JPAUtil.getCurrentEntityManager();

        Parent foundParent = em.find(Parent.class, parent.getId());
        System.out.println("Number of children: " + foundParent.getChildren().size() + " children's name: " +
                foundParent.getChildren().get(0).getName() + " " + foundParent.getChildren().get(0).getSurname() + " name: " + foundParent.getFistName() + " " + foundParent.getLastName());

        Parent updatedParent = parentService.updateParent("Mike", "Batiste", "MB", null, "6262", null, null,
                "421315", null, foundParent);
        Parent tryToFindPreviousParent = parentService.findParentByUsername("3D");
        Assert.assertNull(tryToFindPreviousParent);
        Parent actualNewParent = parentService.findParentByUsername("MB");
        System.out.println(actualNewParent);
        System.out.println(actualNewParent.getChildren().size());


    }
}

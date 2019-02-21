package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.model.Child;
import gr.aueb.mscis.sample.model.Parent;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class ChildServiceTest {

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
        dataHelper.prepareChildData();
    }

    @Test
    public void testChildService(){
        em = JPAUtil.getCurrentEntityManager();
        ParentService parentService = new ParentService();
        ChildService childService = new ChildService();
        List<Parent> parents = parentService.findAll();
        List<Child> children = childService.findAll();
        Assert.assertEquals(1, children.size());
    }

}

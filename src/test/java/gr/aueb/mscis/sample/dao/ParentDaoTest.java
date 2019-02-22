package gr.aueb.mscis.sample.dao;

import gr.aueb.mscis.sample.model.Parent;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import gr.aueb.mscis.sample.service.ParentService;
import org.junit.After;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class ParentDaoTest {

    private EntityManager em;

    @After
    public void tearDown(){
        em.close();
    }

    @Test
    public void testParentDao() {
        em = JPAUtil.getCurrentEntityManager();
        ParentService parentService = new ParentService();
        Parent newparent = parentService.createParent("Djibril", "Cisse", "DC", "password",
                "6990", "adf@b", "4212", "523523", null);
        ParentDao pdao = new ParentDao();
        List<Parent> parents = pdao.findByLastName("Cisse");
        System.out.println(parents.get(0).getFistName());
    }
}

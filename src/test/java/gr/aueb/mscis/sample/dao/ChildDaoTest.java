package gr.aueb.mscis.sample.dao;

import gr.aueb.mscis.sample.model.Child;
import gr.aueb.mscis.sample.model.Parent;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import gr.aueb.mscis.sample.service.ParentService;
import org.junit.After;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ChildDaoTest {

    private EntityManager em;

    @After
    public void tearDown(){
        em.close();
    }

    @Test
    public void testChildDao() {
        em = JPAUtil.getCurrentEntityManager();
        ParentService parentService = new ParentService();
        List<Child> children = new ArrayList<>();
        children.add(new Child("Mario", "Galinovic"));
        Parent newparent = parentService.createParent("Djibril", "Cisse", "6990", "adf@b", "4212", "523523", children);
        ChildDao childDao = new ChildDao();
        List<Child> foundChildren = childDao.findChildreByParentId(newparent.getId());
        System.out.println(foundChildren.get(0).getName());

    }
}

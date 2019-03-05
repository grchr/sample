package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.persistence.Initializer;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import java.util.List;

public class UsersResourceTest extends JerseyTest {

    private EntityManager em;

    @Override
    protected Application configure(){
        return new ResourceConfig(UserResource.class);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        em.close();
    }

    /**
     * Set up tests.
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        // prepare database for each test
        em = JPAUtil.getCurrentEntityManager();
        Initializer dataHelper = new Initializer();
        dataHelper.prepareParentData();
    }

    @Test
    public void testFindAllParentsResource() {
        Invocation.Builder builder = target("users/parents").request();
        List<Parent> parents = builder.get(new GenericType<List<Parent>>() {});
        System.out.println(parents.size());

    }

}

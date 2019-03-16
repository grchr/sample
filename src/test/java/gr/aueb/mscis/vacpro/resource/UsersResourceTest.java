package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.persistence.Initializer;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import gr.aueb.mscis.vacpro.service.ParentService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UsersResourceTest extends JerseyTest {

    private EntityManager em;

    @Override
    protected Application configure(){
        forceSet(TestProperties.CONTAINER_PORT, "0");
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
        List<ParentInfo> parents = builder.get(new GenericType<List<ParentInfo>>() {});

        assertEquals(1, parents.size());
        assertEquals(200, builder.get().getStatus());

    }

    @Test
    public void testSignInSuccessfullyParent(){
        Invocation.Builder builder = target("users/parent/username/pswd").request();
        System.out.println(builder.get().getEntity().toString());
        List<ParentInfo> parent = builder.get(new GenericType<List<ParentInfo>>() {});
        assertEquals(1, parent.size());
        System.out.println(parent.get(0).getFirstName() + " " + parent.get(0).getLastName() + " username: " + parent.get(0).getUserName());

        assertEquals(200, builder.get().getStatus());
    }

    @Test
    public void testSignUpParent(){
        ParentInfo parentInfo = new ParentInfo();
        parentInfo.setVatNumber("aNewOneVat");
        parentInfo.setUserName("spanoylisOMpampasSas");
        parentInfo.setPassword("gianakopoulos");

        Response response = target("users/parent/create").request().post(Entity.entity(parentInfo, MediaType.APPLICATION_JSON));

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        ParentService service = new ParentService();
        assertEquals(1,service.findParentByVatNumber("aNewOneVat").size());
        System.out.println("---Test completed---");
    }



}
package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.model.User;
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
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.List;

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

        Assert.assertEquals(1, parents.size());
        Assert.assertEquals(200, builder.get().getStatus());

    }

    @Test
    public void testSignInSuccessfullyParent(){
        Invocation.Builder builder = target("users/PARENT/username/pswd").request();
        System.out.println(builder.get().getEntity().toString());
        List<ParentInfo> parent = builder.get(new GenericType<List<ParentInfo>>() {});
        Assert.assertEquals(1, parent.size());
        System.out.println(parent.get(0).getFirstName() + " " + parent.get(0).getLastName() + " username: " + parent.get(0).getUserName());

        Assert.assertEquals(200, builder.get().getStatus());
    }

//    @Test
//    public void testSignUpParent(){
//
//        String newParent = "{\"firstName\":\"Jim\", lastName\":\"Gordon\", userName\":\"JG\", \"password\":\"gcpd\"}";
//        Response response = target("users/signUp").request().post(Entity.entity(newParent, MediaType.APPLICATION_JSON));
//        System.out.println("---Test completed---");
//    }



}

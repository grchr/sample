package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.enums.VaccinationStatus;
import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.Vaccination;
import gr.aueb.mscis.vacpro.model.Vaccine;
import gr.aueb.mscis.vacpro.persistence.Initializer;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import gr.aueb.mscis.vacpro.service.ChildService;
import gr.aueb.mscis.vacpro.service.VaccinationService;
import gr.aueb.mscis.vacpro.service.VaccineService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.After;
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

public class VaccinationResourceTest extends JerseyTest{

    private EntityManager em;

    @Override
    protected Application configure() {
        forceSet(TestProperties.CONTAINER_PORT, "0");
        return new ResourceConfig(VaccinationResource.class);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        if (em.isOpen()) {
            em.close();
        }
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
        dataHelper.prepareVaccineData();
        dataHelper.prepareChildData();
    }

    @Test
    public void testSendReport(){
        Invocation.Builder builder = target("vaccination/vaccination/report").request();
        Response response = builder.get(new GenericType<Response>() {
        });

        assertEquals(200, response.getStatus());
    }

    @Test
    public void testSendNotifications(){
        Invocation.Builder builder = target("vaccination/vaccination/notification").request();
        Response response = builder.get(new GenericType<Response>() {
        });

        assertEquals(200, response.getStatus());
    }

    @Test
    public void testCreateVaccination(){

        ChildService childService = new ChildService();
        Child child = childService.finadAll().get(0);
        VaccineService vaccineService = new VaccineService();
        Vaccine vaccine = vaccineService.findAll().get(0);
        VaccinationInfo vaccinationInfo = new VaccinationInfo();
        vaccinationInfo.setStatus(VaccinationStatus.REGISTERED);

        Response response = target("vaccination/vaccination/" + child.getId() +"/" + vaccine.getId()).request().post(Entity.entity(vaccinationInfo, MediaType.APPLICATION_JSON));

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testUpdateMonthlyVaccination(){

        testCreateVaccination();
        VaccinationService vaccinationService = new VaccinationService();
        Vaccination vaccination = vaccinationService.findAll().get(0);
        VaccinationInfo vaccinationInfo = new VaccinationInfo();
        vaccinationInfo.setVaccinationDate(vaccination.getNotifyDate());
        vaccinationInfo.setStatus(VaccinationStatus.NOTIFIED);

        Response response = target("vaccination/vaccination/" + vaccination.getId()).request().put(Entity.entity(vaccinationInfo, MediaType.APPLICATION_JSON));

        assertEquals(200, response.getStatus());

    }
}

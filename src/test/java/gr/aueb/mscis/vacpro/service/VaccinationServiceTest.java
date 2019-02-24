package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.enums.VaccinationStatus;
import gr.aueb.mscis.vacpro.helper.DateConversion;
import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.model.Vaccination;
import gr.aueb.mscis.vacpro.model.Vaccine;
import gr.aueb.mscis.vacpro.persistence.Initializer;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class VaccinationServiceTest {

    private EntityManager em;

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        em.close();
    }

    /**
     * Sets .
     */
    @Before
    public void setup() {
        // prepare database for each test
        em = JPAUtil.getCurrentEntityManager();
        Initializer dataHelper = new Initializer();
        dataHelper.prepareVaccineData();
    }

    @Test
    public void testCreateVaccination(){
        Parent parent1 = new Parent("Nick", "Calathes", "6999", "4141", "trakis@pao.bc", "241221");
        List<Child> children = new ArrayList<>();
        //Year is set as 118. This is added to 1900 and returns the correct year. TODO: fix by using different date/time type (maybe joda)
        Child child1 = new Child("nando", "de colo", new Date(118, 1, 2));
        Child child2 = new Child("sergio", "llull", new Date(118, 12, 5));
        child1.setParent(parent1);
        child2.setParent(parent1);
        children.add(child1);
        children.add(child2);
        parent1.setChildren(children);
        ParentService parentService = new ParentService();
        parentService.createParent(parent1);
        ChildService childService = new ChildService();
        Child storedChild = childService.findChildrenBySurname("de colo").get(0);
        System.out.println(storedChild);
        VaccineService vaccineService = new VaccineService();
        vaccineService.createVaccine(new Vaccine("hepatitis", 400, "typeA", 2));
        List<Vaccine> vaccines = vaccineService.findAll();
        System.out.println(vaccines.size());
        VaccinationService vaccinationService = new VaccinationService();
        for (Child child : children) {
            for (Vaccine vac : vaccines) {
                Vaccination vaccination = new Vaccination(child, vac, DateConversion.calculateNotificationDate(child1.getBirthday(), vac.getVaccinationAge()), VaccinationStatus.REGISTERED);
                vaccinationService.createVaccination(vaccination);
            }
        }
        List<Vaccination> vaccinations = vaccinationService.findAll();
        Assert.assertEquals(4, vaccinations.size());

    }

    @Test
    public void testUpdateVaccination(){
        Parent parent1 = new Parent("Nick", "Calathes", "6999", "4141", "trakis@pao.bc", "241221");
        List<Child> children = new ArrayList<>();
        //Year is set as 118. This is added to 1900 and returns the correct year. TODO: fix by using different date/time type (maybe joda)
        Child child1 = new Child("nando", "de colo", new Date(118, 1, 2));
        Child child2 = new Child("sergio", "llull", new Date(118, 12, 5));
        child1.setParent(parent1);
        child2.setParent(parent1);
        children.add(child1);
        children.add(child2);
        parent1.setChildren(children);
        ParentService parentService = new ParentService();
        parentService.createParent(parent1);
        ChildService childService = new ChildService();
        Child storedChild = childService.findChildrenBySurname("de colo").get(0);
        System.out.println(storedChild);
        VaccineService vaccineService = new VaccineService();
        vaccineService.createVaccine(new Vaccine("hepatitis", 400, "typeA", 2));
        List<Vaccine> vaccines = vaccineService.findAll();
        System.out.println(vaccines.size());
        VaccinationService vaccinationService = new VaccinationService();
        for (Child child : children) {
            for (Vaccine vac : vaccines) {
                Vaccination vaccination = new Vaccination(child, vac, DateConversion.calculateNotificationDate(child1.getBirthday(), vac.getVaccinationAge()), VaccinationStatus.REGISTERED);
                vaccinationService.createVaccination(vaccination);
            }
        }
        List<Vaccination> vaccinations = vaccinationService.findAll();
        for(Vaccination vacs : vaccinations) {
            vacs.setStatus(VaccinationStatus.NOTIFIED);
            vaccinationService.updateVaccination(vacs);
        }
        vaccinations = vaccinationService.findAll();
        Assert.assertEquals(VaccinationStatus.NOTIFIED, vaccinations.get(0).getStatus());
    }

    @Test
    public void testGetVaccinationsForToday(){
        Parent parent1 = new Parent("Nick", "Calathes", "6999", "4141", "trakis@pao.bc", "241221");
        List<Child> children = new ArrayList<>();
        //Year is set as 118. This is added to 1900 and returns the correct year. TODO: fix by using different date/time type (maybe joda)
        Child child1 = new Child("nando", "de colo", new Date(119, 1, 21));
        Child child2 = new Child("sergio", "llull", new Date(119, 1, 21));
        child1.setParent(parent1);
        child2.setParent(parent1);
        children.add(child1);
        children.add(child2);
        parent1.setChildren(children);
        ParentService parentService = new ParentService();
        parentService.createParent(parent1);
        ChildService childService = new ChildService();
        Child storedChild = childService.findChildrenBySurname("de colo").get(0);
        System.out.println(storedChild);
        VaccineService vaccineService = new VaccineService();
        vaccineService.createVaccine(new Vaccine("hepatitis", 3, "typeA", 2));
        List<Vaccine> vaccines = vaccineService.findAll();
        System.out.println(vaccines.size());
        VaccinationService vaccinationService = new VaccinationService();
        for (Child child : children) {
            for (Vaccine vac : vaccines) {
                Date notificationDate = DateConversion.calculateNotificationDate(child1.getBirthday(), vac.getVaccinationAge());
                Vaccination vaccination = new Vaccination(child, vac, notificationDate, VaccinationStatus.REGISTERED);
                vaccinationService.createVaccination(vaccination);
            }
        }
        Date today = new Date(119, 1, 24);

        System.out.println("Check to send notification for day : " + today);
        List<Vaccination> vaccinations = vaccinationService.findVaccinationsThatNeedNotification(today);
        Assert.assertEquals(2, vaccinations.size());

    }
}

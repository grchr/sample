package gr.aueb.mscis.model;

import gr.aueb.mscis.vacpro.model.Address;
import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.model.User;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testUserModel() {
        //User is abstract. Test Parent,MunicipalityWorker and Administrator instead.
        User parent = new Parent();
        ((Parent) parent).setInsuranceNumber("562136516");
        parent.setEmail("ranger@texas.com");
        parent.setFirstName("Chuck");
        parent.setLastName("Norris");
        parent.setPassword("chucNorrisExistedBeforeTheBingBang");
        parent.setUserName("chuckieCheese");
        parent.setPhoneNumber("6969123");
        parent.setVatNumber("562352");
        Address address = new Address();
        address.setCity("Dallas");
        address.setCountry("USA");
        address.setStreet("Pain Street");
        address.setZipcode(45691);
        parent.setAddress(address);

        Assert.assertEquals("562136516", ((Parent) parent).getInsuranceNumber());
        Assert.assertEquals("ranger@texas.com", parent.getEmail());
        Assert.assertEquals("Chuck", parent.getFirstName());
        Assert.assertEquals("Norris", parent.getLastName());
        Assert.assertEquals("chucNorrisExistedBeforeTheBingBang", parent.getPassword());
        Assert.assertEquals("chuckieCheese", parent.getUserName());
        Assert.assertEquals("6969123", parent.getPhoneNumber());

        User parent2 = new Parent();
        ((Parent) parent2).setInsuranceNumber("562136516");
        parent2.setEmail("ranger@texas.com");
        parent2.setFirstName("Chuck");
        parent2.setLastName("Norris");
        parent2.setUserName("chuckieCheese");

        Assert.assertEquals(parent, parent2);
    }
}

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
        parent.setFistName("Chuck");
        parent.setLastName("Norris");
        parent.setPassword("chucNorrisExistedBeforeTheBingBang");
        parent.setUserName("chuckieCheese");
        parent.setPhoneNumber("6969123");
        parent.setVatNumber("562352");
        Address address = new Address();
        address.setCity("Dallas");
        address.setCountry("USA");
        address.setZipcode(45691);
        parent.setAddress(address);

        Assert.assertEquals("562136516", ((Parent) parent).getInsuranceNumber());
        Assert.assertEquals("ranger@texas.com", parent.getEmail());
        Assert.assertEquals("Chuck", parent.getFistName());
        Assert.assertEquals("Norris", parent.getLastName());
        Assert.assertEquals("chucNorrisExistedBeforeTheBingBang", parent.getPassword());
        Assert.assertEquals("chuckieCheese", parent.getUserName());
        Assert.assertEquals("6969123", parent.getPhoneNumber());
        Assert.assertEquals(address, parent.getAddress());
    }
}

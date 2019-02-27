package gr.aueb.mscis.model;

import gr.aueb.mscis.vacpro.model.Address;
import org.junit.Assert;
import org.junit.Test;

public class AddressTest {

    @Test
    public void testAddress() {

        Address address = new Address();
        address.setCity("Dallas");
        address.setCountry("USA");
        address.setStreet("Pain Street");
        address.setNumber("2");
        address.setZipcode(45691);

        Assert.assertEquals("Dallas", address.getCity());
        Assert.assertEquals("USA", address.getCountry());
        Assert.assertEquals("Pain Street", address.getStreet());
        Assert.assertEquals("2", address.getNumber());
        Assert.assertEquals(45691, address.getZipcode());

        Address address2 = new Address();
        address2.setCity("Dallas");
        address2.setCountry("USA");
        address2.setStreet("Pain Street");
        address2.setNumber("2");
        address2.setZipcode(45691);

        Assert.assertEquals(address2, address);
        Assert.assertEquals(address.hashCode(), address.hashCode());


    }
}

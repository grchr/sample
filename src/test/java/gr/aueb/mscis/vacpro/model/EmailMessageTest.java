package gr.aueb.mscis.vacpro.model;

import org.junit.Assert;
import org.junit.Test;

public class EmailMessageTest {

    @Test
    public void testEmailMessage() {

        EmailMessage newEmail = new EmailMessage("Test", "AnotherTest", "New vaccination", "This is a test message");
        newEmail.setFrom("VacPro");
        newEmail.setTo("you");
        newEmail.setSubject("Vaccines are good");
        newEmail.setBody("Vaccinate your kids");

        Assert.assertEquals("VacPro", newEmail.getFrom());
        Assert.assertEquals("you", newEmail.getTo());
        Assert.assertEquals("Vaccines are good", newEmail.getSubject());
        Assert.assertEquals("Vaccinate your kids", newEmail.getBody());
    }
}

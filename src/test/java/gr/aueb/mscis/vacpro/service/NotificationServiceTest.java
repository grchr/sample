package gr.aueb.mscis.vacpro.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author taggelis
 */
public class NotificationServiceTest {

	private EmailProviderStub provider;
	private VaccinationService vaccinationService;


	/**
	 * Sets .
	 */
	@Before
	public void setup() {
		provider = new EmailProviderStub();
		vaccinationService = new VaccinationServiceStub();
	}

	@Test
	public void sendDailyVaccinationNotification() {
		NotificationService notificationService = new NotificationService(provider,vaccinationService);
		int emailSend = notificationService.sendDailyVaccinationNotification();

		assertEquals(1,emailSend);
	}


}

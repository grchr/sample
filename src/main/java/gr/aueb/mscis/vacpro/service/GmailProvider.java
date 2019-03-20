package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.model.EmailMessage;

/**
 * @author taggelis
 */
public class GmailProvider implements EmailProvider {

	@Override
	public void sendEmail(final EmailMessage message) {
		System.out.println("we send email");
	}
}

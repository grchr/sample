package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.model.EmailMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Email provider stub.
 *
 * @author taggelis
 */
public class EmailProviderStub implements EmailProvider {

	/**
	 * The All messages.
	 */
	List<EmailMessage> allMessages = new ArrayList<EmailMessage>();


	/**
	 * Gets all emails.
	 *
	 * @return the all emails
	 */
	public List<EmailMessage> getAllEmails() {
		return allMessages;
	}

	public void sendEmail(EmailMessage message) {
		allMessages.add(message);
	}
}

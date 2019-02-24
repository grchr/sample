package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.model.EmailMessage;

/**
 * The interface Email provider.
 *
 * @author taggelis
 */
public interface EmailProvider {

	/**
	 * Send email.
	 *
	 * @param message the message
	 */
	void sendEmail(EmailMessage message);
}

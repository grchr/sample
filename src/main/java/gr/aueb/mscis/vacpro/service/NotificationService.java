package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.enums.VaccinationStatus;
import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.EmailMessage;
import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.model.Vaccination;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Notification service.
 *
 * @author taggelis
 */
public class NotificationService {
	private static final String VACPRO_EMAIL = "myemail@vacpro.com";
	private static final String SUBJECT = "Είναι ώρα γα εμβόλιο!";
	private EmailProvider provider;
	private VaccinationService vacService;

	/**
	 * Instantiates a new Notification service.
	 *
	 * @param provider   the provider
	 * @param vacService the vac service
	 */
	public NotificationService(final EmailProvider provider, final VaccinationService vacService) {
		this.provider = provider;
		this.vacService = vacService;
	}

	/**
	 * Send daily vaccination notification.
	 *
	 * @return the int
	 */
	public int sendDailyVaccinationNotification() {

		List<Vaccination> vaccinations = vacService.findVaccinationsThatNeedNotification(new Date());

		Map<Parent, List<Child>> map = new HashMap<>();
		for (Vaccination vac : vaccinations) {

			List<Child> childList = map.get(vac.getChild().getParent());
			if (childList == null) {
				childList = new ArrayList<>();
				childList.add(vac.getChild());
			} else {
				childList.add(vac.getChild());
			}
			map.put(vac.getChild().getParent(), childList);
			vac.setStatus(VaccinationStatus.NOTIFIED);
			vacService.updateVaccination(vac);
		}
		for (Parent parent : map.keySet()) {
			EmailMessage email = new EmailMessage(VACPRO_EMAIL, parent.getEmail(), SUBJECT, createMessage(parent, map.get(parent)));
			provider.sendEmail(email);
		}
		return map.keySet().size();
	}

	private String createMessage(final Parent parent, final List<Child> childList) {
		StringBuilder message = new StringBuilder("Καλησπέρα κ.,");
		message.append(parent.getFirstName());
		message.append(". Είναι ώρα να πάτε για εμβόλιο τον (τους):");
		for (Child child : childList) {
			message.append(" ").append(child.getName());
		}
		message.append("Ευχαριστούμε πολύ!");
		return message.toString();
	}
}

package gr.aueb.mscis.vacpro.helper;

/**
 * The type User data validator.
 */
public final class UserDataValidator {

	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

	private UserDataValidator() {

	}

	/**
	 * Is valid email format boolean.
	 *
	 * @param email the email
	 * @return the boolean
	 */
	public static boolean isValidEmailFormat(final String email) {

		return email.matches(EMAIL_REGEX);

	}

	/**
	 * Is valid phone number boolean.
	 *
	 * @param phoneNumber the phone number
	 * @return the boolean
	 */
	public static boolean isValidPhoneNumber(final String phoneNumber) {

		return phoneNumber.matches("[0-9]{10}");
	}


	/**
	 * Is valid vat number boolean.
	 *
	 * @param vatNumber the vat number
	 * @return the boolean
	 */
	public static boolean isValidVATNumber(final String vatNumber) {

		return vatNumber.matches("[0-9]{9}");
	}


}

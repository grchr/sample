package gr.aueb.mscis.vacpro.helper;

import java.util.regex.Pattern;

public class UserDataValidator {

	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

	private static Pattern pattern;

	public static boolean isValidEmailFormat(String email) {

		return email.matches(EMAIL_REGEX);

	}

	public static boolean isValidPhoneNumber(String phoneNumber) {

		return phoneNumber.matches("[0-9]{10}");
	}

	public static boolean isValidInsuranceNumber(String insuranceNumber) {

		return insuranceNumber.matches("[0-9]{9}");
	}

	public static boolean isValidVATNumber(String vatNumber) {

		return vatNumber.matches("[0-9]{9}");
	}


}

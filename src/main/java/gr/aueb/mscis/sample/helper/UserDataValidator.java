package gr.aueb.mscis.sample.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataValidator {

    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    private static Pattern pattern;

    public static boolean isValidEmailFormat(String email) {

        return email.matches(EMAIL_REGEX);

    }

    public static boolean isValidPhoneNumber(String phoneNumber) {

        if (!phoneNumber.matches("[0-9]{10}")) {
            return false;
        }
        return true;
    }

    public static boolean isValidInsuranceNumber(String insuranceNumber) {

        if (!insuranceNumber.matches("[0-9]{9}")) {
            return false;
        }

        return true;
    }

    public static boolean isValidVATNumber(String vatNumber) {

        if (!vatNumber.matches("[0-9]{9}")) {
            return false;
        }

        return true;
    }


}

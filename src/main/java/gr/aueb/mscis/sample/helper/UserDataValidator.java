package gr.aueb.mscis.sample.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataValidator {

    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    private static Pattern pattern;

    public static boolean isValidEmailFormat(String email) {

        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        matcher = pattern.matcher(email);
        return matcher.matches();

    }

}

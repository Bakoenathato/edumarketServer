package za.ac.cput.util;

import java.util.regex.Pattern;

public class Helper {

    //  validate that the string is not null
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty())
            return true;
        return false;
    }

    // (user validation) validate phone number
    public static boolean validatePhone(String phoneNumber){
        String regex = "(\\+?27|0)(\\d{9})";
        if (phoneNumber.matches(regex)) {
            return false;
        }
        return true;
    }

    // (user validation) validate email address
    public static boolean validateEmail(String emailAddress) {
        final String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        final Pattern compile = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        if (compile.matcher(emailAddress).matches()) {
            return false;
        }
        return true;
    }


}

package tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static boolean isEmailValid(String email) {
        String validEmail = "^(?![.])[[a-z]+(?:\\.[a-z]+)*]{1,64}(?<!\\.)@[a-z]+(?:\\.[a-z]{2,10})+$";
        Pattern pattern = Pattern.compile(validEmail);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

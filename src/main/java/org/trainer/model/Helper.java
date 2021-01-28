package org.trainer.model;

import java.util.regex.Pattern;

public class Helper {

    private static final Pattern pattern = Pattern.compile("-?[0-9]{0,10}");

    /**
     * Checks if the users input is in the correct format pattern
     *
     * @param userInput the answer from the User
     * @return boolean
     */
    public static boolean checkInputPattern(String userInput) {
        if (userInput.isEmpty()) {
            return false;
        } else {
            return pattern.matcher(userInput).matches();
        }
    }
}

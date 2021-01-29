package org.trainer.model;

import java.util.regex.Pattern;

/**
 * Only static access allowed
 */
public final class Helper {

    private static final Pattern pattern = Pattern.compile("-?[0-9]{0,10}");

    //prevents class from being instantiated
    private Helper() {
    }

    /**
     * Checks if the users input is in the correct format pattern
     *
     * @param userInput the answer from the User
     * @return boolean true if user input matches pattern
     */
    public static boolean checkInputPattern(String userInput) {
        if (userInput.isEmpty()) {
            return false;
        } else {
            return pattern.matcher(userInput).matches();
        }
    }
}

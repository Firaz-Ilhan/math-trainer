package org.trainer.model2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class Helper {

    private static final Pattern pattern = Pattern.compile("-?[0-9]{0,10}");

    public static boolean checkInputPattern(String userInput) {
        if (userInput.isEmpty()) {
            return false;
        } else {
            return pattern.matcher(userInput).matches();
        }
    }
}

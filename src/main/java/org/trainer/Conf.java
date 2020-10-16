package org.trainer;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Conf {
	private static final String BUNDLE_NAME = "org.trainer.config";

	private static final ResourceBundle RESOURCE_BUNDLE =
			ResourceBundle.getBundle(BUNDLE_NAME);

	private Conf() {}

	public static String get(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
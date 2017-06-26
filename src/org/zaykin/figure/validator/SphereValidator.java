package org.zaykin.figure.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by a on 26.06.2017.
 */
public class SphereValidator {

    private static final int SPHERE_ELEMENT_COUNT = 4;
    private static final int RADIUS_ELEMENT_NUMBER = 3;

    private static final Logger LOGGER = LogManager.getLogger(SphereValidator.class.getName());

    public static boolean isValid(String[] parameters) {

        boolean result = true;

        if (parameters.length != SPHERE_ELEMENT_COUNT) {
            LOGGER.log(Level.WARN, String.format("Wrong number of parameters. Expected: 4; got: %d",parameters.length));
            result = false;
        }

        try {
            for (String parameter : parameters) {
                Float.parseFloat(parameter);
            }

            if (Float.parseFloat(parameters[RADIUS_ELEMENT_NUMBER]) <= 0) {
                LOGGER.log(Level.WARN, String.format("Radius cannot be equal or less than 0; got: %s", parameters[RADIUS_ELEMENT_NUMBER]));
                result = false;
            }

        }
        catch (NumberFormatException e) {
            LOGGER.log(Level.WARN, "Parameters for sphere are not float numbers");
            result = false;
        }

        return result;

    }
}

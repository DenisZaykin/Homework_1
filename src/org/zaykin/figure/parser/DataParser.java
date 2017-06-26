package org.zaykin.figure.parser;

import org.zaykin.figure.exception.ParametersFormatException;

/**
 * Created by DHM on 6/4/2017.
 */
public class DataParser {

    public static String[] parseLine(String line, String delimiter, int lineNumber) throws ParametersFormatException{

        if (lineNumber < 1) {
            throw new ParametersFormatException(String.format("Line number cannot be less than 1; got: %d", lineNumber));
        }

        if (delimiter == null || "".equals(delimiter)) {
            throw new ParametersFormatException(String.format("Line %d: delimiter is not set", lineNumber));
        }

        return line.split(delimiter);

    }

}

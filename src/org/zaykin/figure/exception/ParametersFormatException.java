package org.zaykin.figure.exception;

/**
 * Created by DHM on 6/4/2017.
 */
public class ParametersFormatException extends Exception{

    public ParametersFormatException() {
        super();
    }
    public ParametersFormatException(String message) {
        super(message);
    }
    public ParametersFormatException(String message, Throwable cause) {
        super(message, cause);
    }
    public ParametersFormatException(Throwable cause) {
        super(cause);
    }

}

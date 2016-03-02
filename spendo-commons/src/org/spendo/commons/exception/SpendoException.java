package org.spendo.commons.exception;

public class SpendoException extends Exception {
	
    public SpendoException(String message) {
        super(message);
    }
    
    public SpendoException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpendoException(Throwable cause) {
        super(cause);
    }


}

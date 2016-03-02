package org.spendo.persistence;

import org.spendo.commons.exception.SpendoException;

public class SpPersistenceException extends SpendoException {

	public SpPersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public SpPersistenceException(String message) {
		super(message);
	}

	public SpPersistenceException(Throwable cause) {
		super(cause);
	}

}

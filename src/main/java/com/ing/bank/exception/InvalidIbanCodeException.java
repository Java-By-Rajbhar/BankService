package com.ing.bank.exception;

/**
 * @author Laxman
 *
 */
public class InvalidIbanCodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidIbanCodeException(String message) {
		super(message);
	}

}

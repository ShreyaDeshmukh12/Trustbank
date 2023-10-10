package com.cg.homeloan.exception;

public class InvalidMortgageException {

	private int statusCode;
	private String errorMessage;

	public InvalidMortgageException(int statusCode, String ErrorMessage) {
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;

	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;

	}

}

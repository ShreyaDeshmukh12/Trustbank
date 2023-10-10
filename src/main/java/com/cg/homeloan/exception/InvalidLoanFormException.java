package com.cg.homeloan.exception;

public class InvalidLoanFormException extends Exception{
	
	private int statusCode;
    private String errorMessage;

    public InvalidLoanFormException(int statusCode, String errorMessage) {
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
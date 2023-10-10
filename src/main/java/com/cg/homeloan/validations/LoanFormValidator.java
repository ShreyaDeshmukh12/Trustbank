package com.cg.homeloan.validations;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.cg.homeloan.entity.LoanForm;
import com.cg.homeloan.exception.InvalidLoanFormException;

public class LoanFormValidator {

	private List<String> states;

	public LoanFormValidator() {
		// Create a list of all valid states and cities in India.
		states = Arrays.asList("Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa",
				"Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala",
				"Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
				"Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand",
				"West Bengal");
		
	}

	public class EmptyFieldException extends Exception {
		public EmptyFieldException(String fieldName) {
			super("The field '" + fieldName + "' is empty.");
		}
	}

	public Map<String, String> validate(LoanForm loanForm) throws EmptyFieldException {

		Map<String, String> errors = new HashMap<>();

		// Validate the isCustomer field.
		if (!loanForm.getIsCustomer().equalsIgnoreCase("yes") && !loanForm.getIsCustomer().equalsIgnoreCase("no")) {
			errors.put("isCustomer", "isCustomer field is Invalid.");
		}

		// Validate the fName field.
		if (loanForm.getFirstName().isEmpty()) {
			errors.put("firstName", "The first name field is empty.");
		} else if (loanForm.getFirstName().length() > 15) {
			errors.put("firstName", "The first name field must be less than 15 alphabets.");
		} else if (!loanForm.getFirstName().matches("[a-zA-Z]+")) {
			errors.put("firstName", "The first name field must contain only alphabets.");
		}

		// Validate the lName field.
		if (loanForm.getLastName().isEmpty()) {
			errors.put("lastName", "The last name field is empty.");
		} else if (loanForm.getLastName().length() > 15) {
			errors.put("lastName", "The last name field must be less than 15 characters.");
		} else if (!loanForm.getLastName().matches("[a-zA-Z]+")) {
			errors.put("lastName", "The last name field must contain only alphabets.");
		}

		// Validate the mName field.
		if (loanForm.getMiddleName().isEmpty()) {
			errors.put("middleName", "middleName field is empty.");
		} else if (loanForm.getMiddleName().length() > 15) {
			errors.put("middleName", "middleName field should be less than 15 alphabets.");
		} else if (!loanForm.getMiddleName().matches("^[a-zA-Z]+$")) {
			errors.put("middleName", "middleName field should contain only alphabets.");
		}

		// Validate the dob field.
		if (loanForm.getDob() == null) {
			errors.put("dob", "dob field is empty.");
		} else if (loanForm.getDob().isAfter(LocalDate.now())) {
			errors.put("dob", "Date of birth cannot be in the future.");
		} else if (Period.between(loanForm.getDob(), LocalDate.now()).getYears() < 18) {
			errors.put("dob", "User must be at least 18 years old to apply for a loan.");
		}

		// Validate the email field.
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (loanForm.getEmail().isEmpty()) {
			errors.put("email", "email field is empty.");
		} else if (!loanForm.getEmail().matches(emailRegex)) {
			errors.put("email", "email field is invalid.");
		}

		// Validate the SSN ID field.
		if (loanForm.getSsnId() == 0) {
			errors.put("ssnId", "ssnId cannot be zero or empty.");
		} else if (loanForm.getSsnId() < 0 || loanForm.getSsnId() > 999999999) {
			errors.put("ssnId", "ssnId field is invalid.");
		}

		// Validate the phoneNum field.
		String phoneNumRegex = "^\\d{10}$";
		if (loanForm.getPhoneNum().isEmpty()) {
			errors.put("phoneNum", "phoneNum field is empty.");
		} else if (!loanForm.getPhoneNum().matches(phoneNumRegex)) {
			errors.put("phoneNum", "phoneNum field is invalid.");
		}

		// Validate the address field.
		if (loanForm.getAddress().isEmpty()) {
			errors.put("address", "address field is empty.");
		} else if (loanForm.getAddress().length() > 50) {
			errors.put("address", "address field should be less than 50 characters.");
		}

		// Validate the zip code field.
		if (loanForm.getZip() == 0) {
			errors.put("zip", "zip cannot be zero or empty.");
		} else if (loanForm.getZip() < 0 || loanForm.getZip() > 999999) {
			errors.put("zip", "zip field is invalid.");
		}

		// Validate the state field.
		if (loanForm.getState().isEmpty()) {
			errors.put("state", "state field is empty.");
		} else if (!loanForm.getState().matches("^[a-zA-Z]+$")) {
			errors.put("state", "state name should contain only alphabets.");
		} else if (!states.contains(loanForm.getState())) {
			errors.put("state", "state is invalid.");
		}

		// Validate the city field.
		if (loanForm.getCity().isEmpty()) {
			errors.put("city", "city field is empty.");
		} else if (!loanForm.getCity().matches("^[a-zA-Z]+$")) {
			errors.put("city", "city name should contain only alphabets.");
		}

		return errors;
	}

}
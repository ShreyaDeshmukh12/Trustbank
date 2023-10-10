package com.cg.homeloan.validations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.homeloan.entity.Mortgage;

public class MortgageValidator {
	private List<String> inSource;
	private List<Integer> famMembers;

	public MortgageValidator() {

		// inSource
		inSource = Arrays.asList(" Buisness, Private, Public, Government, ");
		famMembers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}

	public Map<String, String> validate(Mortgage mortgage) {

		Map<String, String> errors = new HashMap<>();

		// Validate the fsName field.

		if (mortgage.getFstName().isEmpty()) {
			errors.put("fstName", "The fst name field is empty.");
		} else if (mortgage.getFstName().length() > 12) {
			errors.put("fstName", "The fst name field must be less than 12 alphabets.");
		} else if (!mortgage.getFstName().matches("[a-zA-Z]+")) {
			errors.put("fstName", "The fst name field must contain only alphabets.");
		}
		// Validate the lsName field.
		if (mortgage.getLstName().isEmpty()) {
			errors.put("lstName", "The lst name field is empty.");
		} else if (mortgage.getLstName().length() > 15) {
			errors.put("lstName", "The lst name field must be less than 15 characters.");
		} else if (!mortgage.getLstName().matches("[a-zA-Z]+")) {
			errors.put("lstName", "The lst name field must contain only alphabets.");
		}

		// Validate the email field.
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (mortgage.getEmailId().isEmpty()) {
			errors.put("eMail", "eMail field is empty.");
		} else if (!mortgage.getEmailId().matches(emailRegex)) {
			errors.put("emailId", "emailId field is invalid.");
		}

		// Validate the phone field.
		String phoneNumRegex = "^\\d{10}$";
		if (mortgage.getPhone().isEmpty()) {
			errors.put("phone", "phone field is empty.");
		} else if (!mortgage.getPhone().matches(phoneNumRegex)) {
			errors.put("phone", "phone field is invalid.");
		}

		// Validate the Children field.
		if (!mortgage.getChildren().equalsIgnoreCase("yes") && !mortgage.getChildren().equalsIgnoreCase("no")) {
			errors.put("children", "children field is Invalid.");
		}

		// Validate the Luxury field.
		if (!mortgage.getLuxury().equalsIgnoreCase("yes") && !mortgage.getLuxury().equalsIgnoreCase("no")) {
			errors.put("luxury", "luxury field is Invalid.");
		}
		// Validate the monthlyIn field.
		if (mortgage.getMonthlyIn() == 0) {
			errors.put("monthlyIn", "monthlyIn cannot be zero or empty.");
		} else if (mortgage.getMonthlyIn() < 10000 || mortgage.getMonthlyIn() > 20000000) {
			errors.put("MonthlyIn", "MonthlyIn field is invalid.");
		}

		// Validate the monthlyLia field.
		if (mortgage.getMonthlyLia() == 0) {
			errors.put("monthlyLia", "monthlyLia cannot be zero or empty.");
		} else if (mortgage.getMonthlyLia() < 10000 || mortgage.getMonthlyLia() > 20000000) {
			errors.put("monthlyLia", "monthlyLia field is invalid.");
		}

		// Validate the zipCode field.
		if (mortgage.getZipCode() == 0) {
			errors.put("zipCode", "zipCode cannot be zero or empty.");
		} else if (mortgage.getZipCode() < 99999 || mortgage.getZipCode() > 999999) {
			errors.put("zipCode", "zipCode field is invalid.");
		}

		return errors;

	}

}

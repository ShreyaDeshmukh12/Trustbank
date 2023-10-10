package com.cg.homeloan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HomeLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Home price cannot be null.")
	@DecimalMin(value = "1.0", message = "Home price must be a positive number.")
	private Double homePrice;

	@NotNull(message = "Zip code cannot be null.")
	@Pattern(regexp = "^\\d{6}$", message = "Zip code must be a valid 6-digit code.")
	private String zipCode;

	@NotNull(message = "Down payment cannot be null.")
	@DecimalMin(value = "0.0", message = "Down payment must be a non-negative number.")
	private Double downPayment;

	@NotNull(message = "Down payment percent cannot be null.")
	@DecimalMin(value = "0.0", message = "Down payment percent must be a non-negative number.")
	@DecimalMax(value = "100.0", message = "Down payment percent must be less than or equal to 100.0.")
	private Double downPaymentPercent;

	@NotNull(message = "Loan amount cannot be null.")
	@DecimalMin(value = "1.0", message = "Loan amount must be a positive number.")
	private Double loanAmount;

	@NotNull(message = "HOA fees rate cannot be null.")
	@DecimalMin(value = "0.0", message = "HOA fees rate must be a non-negative number.")
	private Double hoaFeesRate;

	@NotNull(message = "Other taxes rate cannot be null.")
	@DecimalMin(value = "0.0", message = "Other taxes rate must be a non-negative number.")
	private Double otherTaxesRate;

	@NotNull(message = "Property tax rate cannot be null.")
	@DecimalMin(value = "0.0", message = "Property tax rate must be a non-negative number.")
	@NotNull(message = "Homeowner insurance rate cannot be null.")
	@DecimalMin(value = "0.0", message = "Homeowner insurance rate must be a non-negative number.")
	private Double homeownerInsuranceRate;

	@NotNull(message = "Principal interest cannot be null.")
	@DecimalMin(value = "1.0", message = "Principal interest must be a positive number.")
	private Double principalInterest;

	@NotNull(message = "HOA fees cannot be null.")
	@DecimalMin(value = "0.0", message = "HOA fees must be a non-negative number.")
	@NotNull(message = "Other taxes cannot be null.")
	@DecimalMin(value = "0.0", message = "Other taxes must be a non-negative number.")
	private Double otherTaxes;

	@NotNull(message = "Property tax cannot be null.")
	@DecimalMin(value = "0.0", message = "Property tax must be a non-negative number.")
	private Double propertyTax;

	@NotNull(message = "Homeowner insurance cannot be null.")
	@DecimalMin(value = "0.0", message = "Homeowner insurance must be a non-negative number.")
	private Double homeownerInsurance;

	@NotNull(message = "Monthly payment cannot be null.")
	@DecimalMin(value = "1.0", message = "Monthly payment must be a positive number.")
	private Double monthlyPayment;

	@NotNull(message = "Property tax rate cannot be null.")
	@DecimalMin(value = "0.0", message = "Property tax rate must be a non-negative number.")
	private Double propertyTaxRate;

	@NotNull(message = "HOA fees cannot be null.")
	@DecimalMin(value = "0.0", message = "HOA fees must be a non-negative number.")
	private Double hoaFees;

	// Constructors, getters, and setters omitted for brevity.

}
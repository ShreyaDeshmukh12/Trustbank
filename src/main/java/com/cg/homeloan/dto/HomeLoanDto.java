package com.cg.homeloan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HomeLoanDto {

	public HomeLoanDto(Double principalInterestValue, Double otherTaxesValue, Double propertyTaxValue,
			Double homeownerInsuranceValue, Double monthlyPaymentValue, Double propertyTaxRateValue,
			Double hoaFeesValue) {
		// TODO Auto-generated constructor stub
	}

	private Double principalInterest;
	private Double hoaFees;
	private Double otherTaxes;
	private Double propertyTax;
	private Double homeownerInsurance;
	private Double monthlyPayment;

}
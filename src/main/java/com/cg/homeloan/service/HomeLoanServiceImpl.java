package com.cg.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entity.HomeLoan;
import com.cg.homeloan.repository.HomeLoanRepository;

@Service
public class HomeLoanServiceImpl implements HomeLoanService {
	@Autowired
	private HomeLoanRepository homeLoanDao;

	@Override
	public HomeLoan calculateHomeLoan(HomeLoan homeLoan) {
		HomeLoan homeLoanDto = new HomeLoan();
		homeLoan.setHomePrice(homeLoan.getHomePrice());
		homeLoan.setZipCode(homeLoan.getZipCode());
		homeLoan.setDownPayment(homeLoan.getDownPayment());

		homeLoan.setDownPaymentPercent(homeLoan.getDownPaymentPercent());
		homeLoan.setLoanAmount(homeLoan.getHomePrice() - homeLoan.getDownPayment());
		homeLoan.setHoaFeesRate(0.01);
		homeLoan.setOtherTaxesRate(0.005);
		homeLoan.setPropertyTaxRate(0.01);
		homeLoan.setHomeownerInsuranceRate(0.005);
		// Calculate the principal interest.
		homeLoan.setPrincipalInterest(homeLoan.getLoanAmount() * (1 + homeLoan.getHoaFeesRate()
				+ homeLoan.getOtherTaxesRate() + homeLoan.getPropertyTaxRate() + homeLoan.getHomeownerInsuranceRate()));

		// Calculate the HOA fees.
		homeLoan.setHoaFees(homeLoan.getPrincipalInterest() * homeLoan.getHoaFeesRate());

		// Calculate the other taxes.
		homeLoan.setOtherTaxes(homeLoan.getPrincipalInterest() * homeLoan.getOtherTaxesRate());

		// Calculate the property tax.
		homeLoan.setPropertyTax(homeLoan.getPrincipalInterest() * homeLoan.getPropertyTaxRate());

		// Calculate the homeowner insurance.
		homeLoan.setHomeownerInsurance(homeLoan.getPrincipalInterest() * homeLoan.getHomeownerInsuranceRate());

		// Calculate the monthly payment.
		homeLoan.setMonthlyPayment((homeLoan.getPrincipalInterest() + homeLoan.getHoaFees() + homeLoan.getOtherTaxes()
				+ homeLoan.getPropertyTax() + homeLoan.getHomeownerInsurance()) / 12);

		return homeLoan;
	}

	@Override
	public HomeLoan saveHomeLoan(HomeLoan homeLoan) {

		// Save the home loan object to the database.
		HomeLoan savedHomeLoan = homeLoanDao.save(homeLoan);

		// Return the saved home loan object.
		return savedHomeLoan;
	}

}
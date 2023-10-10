package com.cg.homeloan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.homeloan.entity.LoanForm;

@Service
public interface ILoanFormService {

	public LoanForm addLoanForm(LoanForm loanForm) throws Exception;

	public LoanForm getLoanFormById(int id);

	public List<LoanForm> getAllLoanForms();

	public LoanForm updateLoanFormById(int id);

	public void deleteLoanFormById(int id);

}
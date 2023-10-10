package com.cg.homeloan.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entity.LoanForm;
import com.cg.homeloan.repository.ILoanFormRepository;
import com.cg.homeloan.validations.LoanFormValidator;

@Service
public class LoanFormServiceImpl implements ILoanFormService {

	@Autowired
	ILoanFormRepository loanFormRepository;

	@Override
	public LoanForm addLoanForm(LoanForm loanForm) throws Exception {

		// Validate the loan form.
		LoanFormValidator loanFormValidator = new LoanFormValidator();
		Map<String, String> errors = loanFormValidator.validate(loanForm);

		if (!errors.isEmpty()) {
			// The loan form is not valid.
			// Show the error messages to the user.
			for (String fieldName : errors.keySet()) {
				System.err.println(errors.get(fieldName));
			}

			return null;
		}

		// Save the loan form.
		return loanFormRepository.save(loanForm);
	}

	@Override
	public List<LoanForm> getAllLoanForms() {
		return loanFormRepository.findAll();
	}

	@Override
	public LoanForm getLoanFormById(int id) {
		return loanFormRepository.getReferenceById(id);
	}

	@Override
	public LoanForm updateLoanFormById(int id) {
		return loanFormRepository.getReferenceById(id);
	}

	@Override
	public void deleteLoanFormById(int id) {
		loanFormRepository.deleteById(id);
	}

}
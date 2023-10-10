package com.cg.homeloan.util;

import org.springframework.stereotype.Component;

import com.cg.homeloan.dto.LoanFormDTO;
import com.cg.homeloan.dto.LoanFormResponseDTO;
import com.cg.homeloan.entity.LoanForm;

@Component
public class LoanFormDTOConverter {

	public LoanFormResponseDTO convertTo(LoanForm loanForm) {
		LoanFormResponseDTO dto = new LoanFormResponseDTO();
		dto.setId(loanForm.getId());
		dto.setIsCustomer(loanForm.getIsCustomer());
		dto.setFirstName(loanForm.getFirstName());
		dto.setLastName(loanForm.getLastName());
		dto.setMiddleName(loanForm.getMiddleName());
		dto.setDob(loanForm.getDob());
		dto.setEmail(loanForm.getEmail());
		dto.setSsnId(loanForm.getSsnId());
		dto.setPhoneNum(loanForm.getPhoneNum());
		dto.setAddress(loanForm.getAddress());
		dto.setZip(loanForm.getZip());
		dto.setState(loanForm.getState());
		dto.setCity(loanForm.getCity());

		dto.setMsg("Loan Form Submitted");
		return dto;
	}

	public LoanFormDTO getLoanFormDTO(LoanForm loanForm) {

		return new LoanFormDTO(loanForm.getId(), loanForm.getIsCustomer(), loanForm.getFirstName(),
				loanForm.getLastName(), loanForm.getMiddleName(), loanForm.getDob(), loanForm.getEmail(),
				loanForm.getSsnId(), loanForm.getPhoneNum(), loanForm.getAddress(), loanForm.getZip(),
				loanForm.getState(), loanForm.getCity());
	}

}
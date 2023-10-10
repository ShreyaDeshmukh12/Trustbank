package com.cg.homeloan.util;

import org.springframework.stereotype.Component;

import com.cg.homeloan.dto.MortgageDTO;
import com.cg.homeloan.dto.MortgageResponseDTO;
import com.cg.homeloan.entity.Mortgage;

@Component
public class MortgageDTOConverter {
	
	public MortgageResponseDTO convertTo (Mortgage mortgage) {
		MortgageResponseDTO dto = new MortgageResponseDTO();
		dto.setMortId(mortgage.getMortId());
		dto.setFstName(mortgage.getFstName());
		dto.setLstName(mortgage.getLstName());
		dto.setEmailId(mortgage.getEmailId());
		dto.setPhone(mortgage.getPhone());
		dto.setFamMembers(mortgage.getFamMembers());
		dto.setChildren(mortgage.getChildren());
		dto.setLuxury(mortgage.getLuxury());
		dto.setInSource(mortgage.getInSource());
		dto.setMonthlyIn(mortgage.getMonthlyIn());
		dto.setMonthlyLia(mortgage.getMonthlyLia());
		dto.setZipCode(mortgage.getZipCode());
		
		dto.setMsg("Mortgage Form Submitted");
		return dto;
	}
	
	public MortgageDTO getMortgageDTO(Mortgage mortgage) {
		
		return new MortgageDTO(mortgage.getMortId(), mortgage.getFstName(), mortgage.getLstName(), mortgage.getEmailId(),
				mortgage.getPhone(), mortgage.getFamMembers(), mortgage.getChildren(), mortgage.getLuxury(),
				mortgage.getInSource(), mortgage.getMonthlyIn(),mortgage.getMonthlyLia(),mortgage.getZipCode());
	}

}

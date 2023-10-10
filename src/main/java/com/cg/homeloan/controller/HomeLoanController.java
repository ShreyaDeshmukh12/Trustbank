package com.cg.homeloan.controller;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.dto.HomeLoanDto;
import com.cg.homeloan.entity.HomeLoan;
import com.cg.homeloan.repository.HomeLoanRepository;
import com.cg.homeloan.service.HomeLoanService;

@RestController
@CrossOrigin(origins= {"http://localhost:4200", "http://localhost:2003"}, allowedHeaders="*")

public class HomeLoanController {

	@Autowired
	private HomeLoanService homeLoanService;

	@Autowired
	private HomeLoanRepository homeLoanDao;

	@Autowired
	public HomeLoanController(HomeLoanService homeLoanService) {
		this.homeLoanService = homeLoanService;
		this.homeLoanDao = homeLoanDao;
	}

	@PostMapping("/saveAndCalculate")
	public ResponseEntity<HomeLoanDto> saveAndCalculate1(@RequestBody HomeLoan homeLoan) {
		// Calculate the HomeLoan using the service
		HomeLoan calculatedHomeLoan = homeLoanService.calculateHomeLoan(homeLoan);

		// Convert HomeLoan to HomeLoanResponseDTO
		HomeLoanDto responseDTO = convertToResponseDTO(calculatedHomeLoan);

		// Save the calculated HomeLoan
		HomeLoan savedHomeLoan = homeLoanDao.save(calculatedHomeLoan);

		// Return the HomeLoanResponseDTO
		return ResponseEntity.ok(responseDTO);
	}

// Define a method to convert HomeLoan to HomeLoanResponseDTO
	private HomeLoanDto convertToResponseDTO(HomeLoan homeLoan) {
	    HomeLoanDto responseDTO = new HomeLoanDto();
	    
	    // Create a decimal format with two decimal places
	    DecimalFormat decimalFormat = new DecimalFormat("#.##");
	    
	    // Format decimal values with two decimal places
	    responseDTO.setPrincipalInterest(Double.parseDouble(decimalFormat.format(homeLoan.getPrincipalInterest())));
	    responseDTO.setOtherTaxes(Double.parseDouble(decimalFormat.format(homeLoan.getOtherTaxes())));
	    responseDTO.setPropertyTax(Double.parseDouble(decimalFormat.format(homeLoan.getPropertyTax())));
	    responseDTO.setHomeownerInsurance(Double.parseDouble(decimalFormat.format(homeLoan.getHomeownerInsurance())));
	    responseDTO.setMonthlyPayment(Double.parseDouble(decimalFormat.format(homeLoan.getMonthlyPayment())));
	    responseDTO.setPropertyTax(Double.parseDouble(decimalFormat.format(homeLoan.getPropertyTaxRate())));
	    responseDTO.setHoaFees(Double.parseDouble(decimalFormat.format(homeLoan.getHoaFees())));

	    return responseDTO;
	}







}
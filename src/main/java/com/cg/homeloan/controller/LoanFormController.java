package com.cg.homeloan.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.dto.LoanFormDTO;
import com.cg.homeloan.dto.LoanFormResponseDTO;
import com.cg.homeloan.entity.LoanForm;
import com.cg.homeloan.service.ILoanFormService;
import com.cg.homeloan.util.LoanFormDTOConverter;

@RestController
@RequestMapping("/loan")
@CrossOrigin(origins = { "http://localhost:4200", "htttp://localhost:9090" }, allowedHeaders = "*")
public class LoanFormController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ILoanFormService loanFormService;
	@Autowired
	private LoanFormDTOConverter loanFormDTOConvertor;

	public LoanFormController() {
		logger.info("---------- LoanForm Controller Called ----------");
		logger.warn("---------- LoanForm Controller Called ----------");
		System.err.println("--------------------------------------- Welcome to Loan Form -------------------------------------");
	}

	@PostMapping("/apply")
	public ResponseEntity<LoanForm> addLoanForm(@RequestBody LoanForm loanForm) throws Exception {
		return new ResponseEntity<LoanForm>(loanFormService.addLoanForm(loanForm), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<LoanFormDTO>> getAllLoanForms() {
		List<LoanForm> allLoanForms = loanFormService.getAllLoanForms();
		List<LoanFormDTO> allLoanFormDTO = new ArrayList<>();
		for (LoanForm loanForm : allLoanForms) {
			allLoanFormDTO.add(loanFormDTOConvertor.getLoanFormDTO(loanForm));
		}
		return new ResponseEntity<List<LoanFormDTO>>(allLoanFormDTO, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<LoanFormDTO> getLoanFormById(@PathVariable int id) {
		LoanForm savedLoanForm = loanFormService.getLoanFormById(id);
		LoanFormDTO dto = loanFormDTOConvertor.getLoanFormDTO(savedLoanForm);
		return new ResponseEntity<LoanFormDTO>(dto, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public String updateLoanForm(@PathVariable int id) {
		LoanForm updateLoanForm = loanFormService.getLoanFormById(id);
		return updateLoanForm.toString();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteLoanFormById(@PathVariable int id) {
		loanFormService.deleteLoanFormById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
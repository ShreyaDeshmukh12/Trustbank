package com.cg.homeloan.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.RestartScope;
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

import com.cg.homeloan.dto.MortgageDTO;
import com.cg.homeloan.entity.Mortgage;
import com.cg.homeloan.service.IMortgageService;
import com.cg.homeloan.util.MortgageDTOConverter;


@RestController
@RequestMapping("/mortgage")
@CrossOrigin(origins ="http://localhost:5432")

public class MortgageController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	
	private IMortgageService mortgageService;
	@Autowired
	
	private MortgageDTOConverter mortgageDTOConverter; 
	
	public MortgageController() {
		logger.info("---------- Mortgage Form Controller Called ----------");
		logger.warn("---------- Mortgage Form Controller Called ----------");
		System.err.println("--------------------------------------- Welcome to Mortgage Form -------------------------------------");
		}
	
	@PostMapping("/apply")
	public ResponseEntity<Mortgage> addMortgage(@RequestBody Mortgage mortgage) throws Exception {
	return new ResponseEntity<Mortgage>(mortgageService.addMortgage(mortgage), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<MortgageDTO>> getAllMortgage() {
		List<Mortgage> allMortgage = mortgageService.getAllMortgage();
		List<MortgageDTO> allMortgageDTO = new ArrayList<>();
		for (Mortgage mortgage : allMortgage) {
			allMortgageDTO.add(mortgageDTOConverter.getMortgageDTO(mortgage));
			}
		return new ResponseEntity<List<MortgageDTO>>(allMortgageDTO, HttpStatus.OK);
		}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<MortgageDTO> getMortgageById(@PathVariable int id) {
		Mortgage savedMortgage = mortgageService.getMortgageById(id);
		MortgageDTO dto = mortgageDTOConverter.getMortgageDTO(savedMortgage);
		return new ResponseEntity<MortgageDTO>(dto, HttpStatus.OK);
		}
	
	
	@PutMapping("/update/{id}")
	public String updateMortgage(@PathVariable int id) {
		Mortgage updateMortgage = mortgageService.getMortgageById(id);
		return updateMortgage.toString();
		}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMortgageById(@PathVariable int id) {
		mortgageService.deleteMortgageById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}


	


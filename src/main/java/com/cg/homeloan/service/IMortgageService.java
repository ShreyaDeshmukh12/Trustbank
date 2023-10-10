package com.cg.homeloan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.homeloan.entity.Mortgage;

@Service
public interface IMortgageService {
	
	public Mortgage addMortgage(Mortgage mortgage) throws Exception;

	public Mortgage getMortgageById(int mortId);

	public List<Mortgage> getAllMortgage();

	public Mortgage updateMortgageById(int mortId);

	public void deleteMortgageById(int mortId);


}

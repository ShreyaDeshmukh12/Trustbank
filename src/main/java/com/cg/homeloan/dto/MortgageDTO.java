package com.cg.homeloan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class MortgageDTO {

	private int mortId;
	private String fstName;
	private String lstName;
	private String emailId;
	private String phone;
	private int famMembers;
	private String children;
	private String luxury;
	private String inSource;
	private int monthlyIn;
	private int monthlyLia;
	private int zipCode;
		

}

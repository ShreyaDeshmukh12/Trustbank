package com.cg.homeloan.dto;

import lombok.Data;

@Data

public class MortgageResponseDTO {
	
		private String msg;
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

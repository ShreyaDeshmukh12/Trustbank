package com.cg.homeloan.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Entity
@NoArgsConstructor
public class Mortgage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Personal Details
	private int mortId;
	private String fstName;
	private String lstName;
	private String emailId;
	private String phone;
	private int famMembers;
	private String children;
	private String luxury;
	// Employment Details
	private String inSource;
	private int monthlyIn;  
	private int monthlyLia;
	private int zipCode;
	
	public Mortgage(int mortId, String fstName, String lstName, String emailId, String phone, int famMembers,
			String children, String luxury, String inSource, int monthlyIn, int monthlyLia, int zipCode) {
		super();
		this.mortId = mortId;
		this.fstName = fstName;
		this.lstName = lstName;
		this.emailId = emailId;
		this.phone = phone;
		this.famMembers = famMembers;
		this.children = children;
		this.luxury = luxury;
		this.inSource = inSource;
		this.monthlyIn = monthlyIn;
		this.monthlyLia = monthlyLia;
		this.zipCode = zipCode;
	}
}
package com.cg.homeloan.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class LoanForm {
	// Personal Information
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String isCustomer;
	private String firstName;
	private String lastName;
	private String middleName;
	private LocalDate dob;
	private String email;
	private long ssnId;
	private String phoneNum;
	private String address;
	private int zip;
	private String state;
	private String city;

	public LoanForm(int id, String isCustomer, String firstName, String lastName, String middleName, LocalDate dob,
			String email, long ssnId, String phoneNum, String address, int zip, String state, String city) {
		super();
		this.id = id;
		this.isCustomer = isCustomer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.dob = dob;
		this.email = email;
		this.ssnId = ssnId;
		this.phoneNum = phoneNum;
		this.address = address;
		this.zip = zip;
		this.state = state;
		this.city = city;
	}

}
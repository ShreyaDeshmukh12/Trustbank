package com.cg.homeloan.dto;

import java.time.LocalDate;

import lombok.Data;


@Data
public class LoanFormResponseDTO {

	private String msg;
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

}
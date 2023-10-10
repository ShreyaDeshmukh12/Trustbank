package com.cg.homeloan.service;

import com.cg.homeloan.entity.HomeLoan;

public interface HomeLoanService {

	HomeLoan calculateHomeLoan(HomeLoan homeLoan);

	HomeLoan saveHomeLoan(HomeLoan homeLoan);

}
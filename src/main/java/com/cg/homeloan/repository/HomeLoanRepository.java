package com.cg.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entity.HomeLoan;

public interface HomeLoanRepository extends JpaRepository<HomeLoan, Long> {

}
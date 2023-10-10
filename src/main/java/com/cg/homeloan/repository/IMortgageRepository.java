package com.cg.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entity.Mortgage;

public interface IMortgageRepository extends JpaRepository<Mortgage, Integer> {


}

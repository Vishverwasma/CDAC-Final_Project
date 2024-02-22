package com.cdac_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac_project.model.Distributor;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

	public Distributor findByEmail(String distributorEmail);
}

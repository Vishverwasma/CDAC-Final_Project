package com.cdac_project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac_project.project.model.Distributor;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

	public Distributor findByEmail(String distributorEmail);
}

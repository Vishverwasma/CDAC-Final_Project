package com.cdac_project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdac_project.project.model.Pharmacist;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
    Pharmacist findByEmail(String Email);
}


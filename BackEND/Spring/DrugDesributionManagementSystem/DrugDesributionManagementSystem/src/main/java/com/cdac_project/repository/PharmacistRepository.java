package com.cdac_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cdac_project.model.Pharmacist;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Integer> {
    Pharmacist findByEmail(String Email);
}


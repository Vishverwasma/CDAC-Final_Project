package com.cdac_project.project.repository;

import com.cdac_project.project.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByPharmacistid(int pharmacistId);
}

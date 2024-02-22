package com.cdac_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdac_project.model.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByPharmacistid(int pharmacistId);
    
//    @Query("SELECT a FROM Address a WHERE a.pharmacistId = :pharmacistId") // Make sure the property name matches the entity class
//	 List<Address> findByPharmacistid(@Param("pharmacistId") int pharmacistId);
}

package com.cdac_project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdac_project.project.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	@Query("SELECT c FROM Cart c WHERE c.pharmacist.id= :pharmacistId")
	public Cart findByPharmacistId(@Param("pharmacistId")int pharmacistId);
	
}

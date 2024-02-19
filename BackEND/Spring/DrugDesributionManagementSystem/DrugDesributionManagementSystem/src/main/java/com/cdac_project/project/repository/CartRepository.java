package com.cdac_project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac_project.project.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	
}

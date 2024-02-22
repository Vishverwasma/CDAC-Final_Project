package com.cdac_project.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdac_project.model.*;

@Repository
public interface OrderMedicineRepository {
	 List<OrderMedicine> findByOrder(Order order);
	    
	    List<OrderMedicine> findByMedicine(Medicine medicine);
	    
	    List<OrderMedicine> findByOrderAndMedicine(Order order, Medicine medicine);
}

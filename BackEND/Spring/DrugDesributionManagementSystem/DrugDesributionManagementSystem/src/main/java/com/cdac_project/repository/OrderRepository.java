package com.cdac_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdac_project.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByPharmacistId(int pharmacistId);
    
    @Query("SELECT o FROM Order o WHERE o.pharmacistId = :pharmacistID")
    public List<Order> getPharmacistOrders(@Param("pharmacistID") int id);
}
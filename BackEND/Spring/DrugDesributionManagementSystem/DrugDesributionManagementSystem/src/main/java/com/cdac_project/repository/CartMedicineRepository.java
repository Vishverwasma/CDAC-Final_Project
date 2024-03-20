package com.cdac_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdac_project.model.Cart;
import com.cdac_project.model.CartMedicine;
import com.cdac_project.model.Medicine;

@Repository
public interface CartMedicineRepository extends JpaRepository<CartMedicine, Integer>{

	//CartMedicine isCartMedicineExist(Cart cart, Medicine medicine, int id);
	
	boolean existsByCartAndMedicineAndId(Cart cart, Medicine medicine, int id);
	 
	// In CartMedicineRepository.java
	@Query("SELECT cm FROM cart_medicine cm " +
	        "WHERE cm.cart.id = :cartId " +
	        "AND cm.medicine.id = :medicineId " +
	        "AND cm.pharmacistId = :pharmacistId " +
	        "AND cm.quantity = :quantity")
	CartMedicine isCartMedicineExist(@Param("cartId") Cart cart,
	                                  @Param("medicineId") Medicine medicine,
	                                  @Param("pharmacistId") int pharmacistId,
	                                  @Param("quantity") int quantity);


    CartMedicine findByCartAndMedicineAndPharmacistId(Cart cart, Medicine medicine, int pharmacistId);

	List<CartMedicine> findByPharmacistId(int pharmacistId);
	
}

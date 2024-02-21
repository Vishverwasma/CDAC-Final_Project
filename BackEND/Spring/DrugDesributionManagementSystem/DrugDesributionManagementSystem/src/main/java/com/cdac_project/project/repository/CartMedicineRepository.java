package com.cdac_project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdac_project.project.model.Cart;
import com.cdac_project.project.model.CartMedicine;
import com.cdac_project.project.model.Medicine;

@Repository
public interface CartMedicineRepository extends JpaRepository<CartMedicine, Integer>{

	//CartMedicine isCartMedicineExist(Cart cart, Medicine medicine, int id);
	
	boolean existsByCartAndMedicineAndId(Cart cart, Medicine medicine, int id);
	 
//	 @Query("SELECT cm FROM cart_medicine cm WHERE cm.cart_id = :cartId AND cm.medicine_id = :medicineId AND cm.pharmacist_id = :pharmacistId AND cm.quantity = :quantity\\r\\n")
//	    CartMedicine isCartMedicineExist(@Param("cart") Cart cart, @Param("pid") int pid, @Param("medicine") Medicine medicine, @Param("quantity") int quantity);

	
	@Query("SELECT cm FROM cart_medicine cm \r\n"
			+ "WHERE cm.cart.id = :cartId \r\n"
			+ "AND cm.medicine.id = :medicineId \r\n"
			+ "AND cm.pharmacistId = :pharmacistId \r\n"
			+ "AND cm.quantity = :quantity\r\n"
			+ "")
	CartMedicine isCartMedicineExist(@Param("cartId") Cart cartId, @Param("medicineId") Medicine medicineId, @Param("pharmacistId") int pharmacistId, @Param("quantity") int quantity);

    CartMedicine findByCartAndMedicineAndPharmacistId(Cart cart, Medicine medicine, int pharmacistId);
	
}

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
	
//	@Query("SELECT ci FROM CartMedicine ci WHERE ci.cart_id = :cart AND ci.medicine_id = :medicine AND ci.pharmacist_id = :pharmacistId AND ci.quantity = :quantity")
//	public CartMedicine isCartMedicineExist(@Param("cart") Cart cart, @Param("medicine")Medicine medicine,@Param("pharmacistId")int pharmacistId,@Param("quantity")int quantity);
	
	CartMedicine isCartMedicineExist(Cart cart, Medicine medicine, int pharmacistId);

	
}

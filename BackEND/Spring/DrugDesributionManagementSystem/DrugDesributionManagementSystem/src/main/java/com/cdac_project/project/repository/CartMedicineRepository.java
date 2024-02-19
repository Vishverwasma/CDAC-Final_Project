package com.cdac_project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdac_project.project.model.Cart;
import com.cdac_project.project.model.CartMedicine;
import com.cdac_project.project.model.Medicine;

public interface CartMedicineRepository extends JpaRepository<CartMedicine, Long>{

	//CartMedicine isCartMedicineExist(Cart cart, Medicine medicine, Long id);
	
	boolean existsByCartAndMedicineAndId(Cart cart, Medicine medicine, Long id);
	
	@Query("SELECT ci FROM CartMedicine ci WHERE ci.cart = :cart AND ci.medicine = :medicine AND ci.cart.pharmacistId = :pharmacistId")
	public CartMedicine isCartMedicineExist(@Param("cart") Cart cart, @Param("medicine")Medicine medicine,@Param("pharmacistId")Long pharmacistId);

}

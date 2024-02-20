package com.cdac_project.project.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdac_project.project.model.Medicine;
import com.cdac_project.project.model.MedicineCategory;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer>{


	@Query("SELECT m FROM Medicine m " +
		       "WHERE (:Medicine_Name IS NULL OR m.name = :Medicine_Name) " +
		       "AND (:Category_id IS NULL OR m.categoryId = :Category_id) " +
		       "AND (:Medicine_Quantity IS NULL OR m.quantity <= :Medicine_Quantity) " +
		       "AND (:Manufacture_Date IS NULL OR m.manufactureDate = :Manufacture_Date) " +
		       "AND (:Unit_Price IS NULL OR m.unitPrice = :Unit_Price)")
		public List<Medicine> filterMedicines(
		        @Param("Medicine_Name") String Medicine_Name,
		        @Param("Category_id") Integer Category_id,
		        @Param("Medicine_Quantity") int Medicine_Quantity,
		        @Param("Manufacture_Date") LocalDate Manufacture_Date,
		        @Param("Unit_Price") int Unit_Price);

	public List<Medicine> findByCategoryId(int category_id);

	
}

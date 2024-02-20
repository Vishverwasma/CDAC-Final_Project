package com.cdac_project.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdac_project.project.model.MedicineCategory;

public interface MedicineCategoryRepository extends JpaRepository<MedicineCategory, Integer>{

   	 public  MedicineCategory findByCategoryid(int categoryId);
	 
//	 @Query("Select c from medicine_db c Where c.Category_id=:Category_id")
//	 public MedicineCategory findById
//	 (@Param("Category_id") int Category_id);
}

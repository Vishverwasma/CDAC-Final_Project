package com.cdac_project.model;

import javax.persistence.*;

@Entity
@Table(name="medicine_category")
public class MedicineCategory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_id")
    private int categoryid;

    @Column(name = "Category_Name")
    private String name;

    @Column(name = "Medicine_Quantity")
    private int MedicineQuantity;
    
    
    
	public MedicineCategory(int categoryid) {
		super();
		categoryid = categoryid;
	}

	public int getMedicineQuantity() {
		return MedicineQuantity;
	}

	public void setMedicineQuantity(int medicineQuantity) {
		MedicineQuantity = medicineQuantity;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MedicineCategory(int categoryid, String name , int MedicineQuantity) {
		super();
		this.categoryid = categoryid;
		this.name = name;
		this.MedicineQuantity = MedicineQuantity;
	}

	public MedicineCategory() {
		super();
	}

    
}

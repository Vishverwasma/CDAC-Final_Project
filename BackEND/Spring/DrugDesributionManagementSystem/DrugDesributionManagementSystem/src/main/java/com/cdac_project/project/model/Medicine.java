package com.cdac_project.project.model;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "medicine_db", uniqueConstraints = @UniqueConstraint(columnNames = "Medicine_Name"))
public class Medicine {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Medicine_id")
    private int id;

    @Column(name = "Medicine_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Category_id")
    private MedicineCategory categoryId;
    
    @Column(name = "Medicine_Quantity")
    private int quantity;

    @Column(name = "Manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "Unit_Price")
    private int unitPrice;
    
    @ManyToOne
    private Order order;

	public Medicine() {
		super();
	}

	

	public Medicine(int id, String name, MedicineCategory categoryId, int quantity, LocalDate manufactureDate,
			int unitPrice) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.quantity = quantity;
		this.manufactureDate = manufactureDate;
		this.unitPrice = unitPrice;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public MedicineCategory getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(MedicineCategory categoryId) {
		this.categoryId = categoryId;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public LocalDate getManufactureDate() {
		return manufactureDate;
	}



	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}



	public int getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	
	
}

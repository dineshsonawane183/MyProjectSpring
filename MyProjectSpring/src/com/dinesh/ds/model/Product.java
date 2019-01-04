package com.dinesh.ds.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "product_sp")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String brand;
	private String code;
	private String description;
	private double unitPrice;
	private int quantity;
	private boolean active;
	
	
	@Transient
	private MultipartFile file;
	
	

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Product(String name, String brand, String code, String description, double unitPrice, int quantity,
			boolean active) {
		super();
		this.name = name;
		this.brand = brand;
		this.code = code;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.active = active;
	}

	public Product(String name, String brand, String description, double unitPrice, int quantity, boolean active) {
		super();
		Random r = new Random();
		this.name = name;
		this.brand = brand;
		this.code = "PRD" + r.nextInt();
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.active = active;
	}

	@Override
	public String toString() {
		return "Prdouct [id=" + id + ", name=" + name + ", brand=" + brand + ", code=" + code + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active + "]";
	}

	public Product() {
		Random r = new Random();
		this.code = "PRD" + r.nextInt();
	}

	public Product(Integer id, String name, String brand, String code, String description, double unitPrice,
			int quantity, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.code = code;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.active = active;
	}

	public Product(Integer id, String name, String brand, String description, double unitPrice, int quantity,
			boolean active) {
		super();
		Random r = new Random();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.code = "PRD" + r.nextInt();
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.active = active;
	}
}

package com.dinesh.ds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_sp")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String contact;
	private String imageUrl;
	

	
	
	public Customer(String name, String address, String contact, String imageUrl) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.imageUrl = imageUrl;
	}


	public Customer(int id, String name, String address, String contact, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.imageUrl = imageUrl;
	}


	public Customer(String name, String address, String contact) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
	}


	public Customer() {
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Override
	public String toString() {
		return "customer [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + "]";
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	

}

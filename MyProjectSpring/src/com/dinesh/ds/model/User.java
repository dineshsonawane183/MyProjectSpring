package com.dinesh.ds.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_sp", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Enumerated(EnumType.STRING)
	private UserType user;

	private String username;
	private String password;

	@OneToOne(mappedBy = "user",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private Cart cart;
	
	
	private boolean enabled = true;

	public int getId() {
		return id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public User() {
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public UserType getUser() {
		return user;
	}

	public void setUser(UserType user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", user=" + user + ", username=" + username + ", password="
				+ password + ", enabled=" + enabled + "]";
	}

	public User(int id, String name, UserType user, String username, String password, boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String name, UserType user, String username, String password, boolean enabled) {
		super();
		this.name = name;
		this.user = user;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

}

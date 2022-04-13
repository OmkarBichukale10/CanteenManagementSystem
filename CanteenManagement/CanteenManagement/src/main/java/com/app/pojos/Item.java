package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code", length = 20, nullable = false)
	private Integer code;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "cat_id")
	private Category cat_id;
	
	@ManyToMany(mappedBy = "item")
	private Set<Order> order = new HashSet<Order>();

	public Item() {
		super();
		System.out.println("Item's Default Const");
	}

	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	

	public Item(Integer code, String name, double price, Category cat_id, Set<Order> order) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.cat_id = cat_id;
		this.order = order;
	}

	public Item(String name, double price, Category cat_id, Set<Order> order) {
		super();
		this.name = name;
		this.price = price;
		this.cat_id = cat_id;
		this.order = order;
	}

	@Override
	public String toString() {
		return "Item [code=" + code + ", name=" + name + ", price=" + price + ", cat_id=" + "]";
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public Category getCat_id() {
		return cat_id;
	}

	public void setCat_id(Category cat_id) {
		this.cat_id = cat_id;
	}
	
	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	

}

package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "piya")
public class Order {
	private Integer orderId;
	private Integer quantity;
	private Set<Item> item = new HashSet<Item>();

	private Set<Transaction> transaction = new HashSet<Transaction>();
	public Order() {
		super();
	}
	
	public Order(Integer orderId, Integer quantity, Set<Item> item, Set<Transaction> transaction) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.item = item;
		this.transaction = transaction;
	}

	public Order(Integer quantity, Set<Item> item, Set<Transaction> transaction) {
		super();
		this.quantity = quantity;
		this.item = item;
		this.transaction = transaction;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Column(length = 5, nullable = false)
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@ManyToMany(mappedBy = "order")
	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transactionId) {
		this.transaction = transactionId;
	}
	@ManyToMany
	@JoinTable(schema = "piya", name = "order_dish", joinColumns = @JoinColumn(name = "order_Id"), inverseJoinColumns = @JoinColumn(name = "item_Id"))
	
	public Set<Item> getItem() {
		return item;
	}
	public void setItem(Set<Item> item) {
		this.item = item;
	}



		

}

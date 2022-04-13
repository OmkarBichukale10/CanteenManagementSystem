package com.app.pojos;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "Transactions")
public class Transaction {
	private Integer transactionId;
	private Account account;
	private List<Order> order = new ArrayList<Order>();
	private float totalBill;

	public Transaction() {
		super();
		System.out.println("inside transaction def constructor");
	}

	
	public Transaction(Integer transactionId, Account account, List<Order> order, float totalBill) {
		super();
		this.transactionId = transactionId;
		this.account = account;
		this.order = order;
		this.totalBill = totalBill;
	}


	public Transaction(Integer transactionId, List<Order> order, float totalBill) {
		super();
		this.transactionId = transactionId;
		this.order = order;
		this.totalBill = totalBill;
	}


	public Transaction(Account account, List<Order> order, float totalBill) {
		super();
		this.account = account;
		this.order = order;
		this.totalBill = totalBill;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "order_transaction", joinColumns = @JoinColumn(name = "transaction_Id"), inverseJoinColumns = @JoinColumn(name = "order_Id"))
	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Column(nullable = true)
	public float getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}


	
}

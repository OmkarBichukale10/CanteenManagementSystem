package com.app.pojos;

public class Cartdetails
{
	private int qty;
	private String name;
	private double price;
	private double total;
	public int getQty() {
		return qty;
	}
	public Cartdetails() 
	{
		super();
		System.out.println("Cartitems default");
	}
	
	public Cartdetails(int qty, String name, double price, double total) {
		super();
		this.qty = qty;
		this.name = name;
		this.price = price;
		this.total = total;
	}
	public Cartdetails(int qty, String name, double price) {
		super();
		this.qty = qty;
		this.name = name;
		this.price = price;
	}
	public void setQty(int qty) {
		this.qty = qty;
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	

}

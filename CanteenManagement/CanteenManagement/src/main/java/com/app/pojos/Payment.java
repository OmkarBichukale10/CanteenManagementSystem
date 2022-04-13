package com.app.pojos;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String name;
	private double totalBill;
	private String type;
	private String date;
	
	
	public Payment() {
		
	}
	
	
	public Payment(String name, double totalBill, String type, String date) {
		super();
		this.name = name;
		this.totalBill = totalBill;
		this.type = type;
		this.date = date;
	}
	
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", name=" + name + ", totalBill=" + totalBill + ", type=" + type + ", Date="
				+ date + "]";
	}
	
	
}

package com.app.dao;

import java.util.List;

import com.app.pojos.Payment;

public interface IPayment {
	String addNewPayment(Payment p);
	public List<Payment> getAllPayment();

}

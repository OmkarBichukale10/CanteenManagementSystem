package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Account;
import com.app.pojos.Payment;

@Repository
@Transactional
public class PaymentImpl implements IPayment{
	@Autowired
	private SessionFactory sf; 
	
	
	@Override
	public String addNewPayment(Payment p) {
		sf.getCurrentSession().persist(p);//v --persistent
		return "Vendor registered successfully : ID "+p.getName();
	}


	@Override
	public List<Payment> getAllPayment() {
		String jpql = "select p from Payment p";
		return sf.getCurrentSession().createQuery(jpql, Payment.class).getResultList();
	}
	
	

}

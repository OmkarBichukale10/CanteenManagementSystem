package com.app.dao;

import java.util.List;

import com.app.pojos.Feedback;
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
public class FeedbackImpl implements IFeedback {
	
	@Autowired
	private SessionFactory sf; 
	

	@Override
	public String addNewFeedback(Feedback f) {
		sf.getCurrentSession().persist(f);//v --persistent
		return "Vendor registered successfully : ID "+f.getName();
	}

	@Override
	public List<Feedback> getAllFeedback() {
		String jpql = "select f from Feedback f";
		return sf.getCurrentSession().createQuery(jpql, Feedback.class).getResultList();
	}

}

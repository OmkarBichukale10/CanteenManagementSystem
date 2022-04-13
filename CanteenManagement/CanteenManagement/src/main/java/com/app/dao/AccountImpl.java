package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Account;

@Repository
@Transactional
public class AccountImpl implements IAccountDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Account auntheticateUser(String username, String password) {
		String jpql = "select a from Account a where a.userName = :userName and a.password=:password";
		return sf.getCurrentSession().createQuery(jpql, Account.class).setParameter("userName", username).setParameter("password", password)
				.getSingleResult();
		
	}

	@Override
	public String addNewAccount(Account a) {
		sf.getCurrentSession().persist(a);//v --persistent
		return "Vendor registered successfully : ID "+a.getUserId();
	}
}

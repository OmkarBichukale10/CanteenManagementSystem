package com.app.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.pojos.Category;
import com.app.pojos.Item;



@Repository
@Transactional
public class CategoryImpl implements ICategory{

	@Autowired
	private SessionFactory sf;

	@Override
	public List<String> getAllCategory() {
		
		String jpql = "select c.cat_name from Category c";
		return sf.getCurrentSession().createQuery(jpql, String.class).getResultList();
	}

	@Override
	public List<Item> ItemCategory(String cat_name) {
		String jpql="select e from Item e where e.cat_id.cat_name=:dm";	
		return sf.getCurrentSession().createQuery(jpql,Item.class).setParameter("dm",cat_name).getResultList();
		
	}

	@Override
	public Item getDish(int code) {
		return sf.getCurrentSession().get(Item.class, code);
	}

	
}

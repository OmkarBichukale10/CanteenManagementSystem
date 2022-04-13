package com.app.dao;

import java.util.List;


import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Account;
import com.app.pojos.Category;
import com.app.pojos.Item;

@Repository
@Transactional
public class AdminImpl implements IAdminDao {
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
	public String deleteItemDetails(int code) {
		Session hs=sf.getCurrentSession();
		Item e= hs.get(Item.class,code);
		if(e!=null) {
			hs.delete(e);
			return "Item deleted with id"+e.getCode();
		}
			return "Item deletion failed : invalid Item id";
	}

	@Override
	public String addItem(Item i,String catname) {
        
		Category c=sf.getCurrentSession().createQuery("select q from Category q where q.cat_name=:cat", Category.class).setParameter("cat",catname).getSingleResult();
		sf.getCurrentSession().persist(i);
		i.setCat_id(c);
		c.getItems().add(i);
		return " Item Added  successfully : ID "+i.getCode();
	}

	/*@Override
	public void updateitems(int code, String name, double price, int cat_id) 
	{
		System.out.println("inside dao layer for updating the data");
		try {
			Item i = sf.getCurrentSession().get(Item.class, code);
			Category c=sf.getCurrentSession().get(Category.class, cat_id);
			System.out.println(i);
			i.setName(name);
			i.setPrice(price);
			i.setCat_id(c);
			sf.getCurrentSession().update(i);
			System.out.println("data has been updated");
			} 
			catch (RuntimeException e) {
			System.out.println("data has not updated");
			System.out.println(e);
		}
	}*/

	@Override
	public Item fetchInfo(int code) 
	{
		System.out.println("fetching data for update");
		Item v=sf.getCurrentSession().get(Item.class, code);
		return v;	}

	@Override
	public void updateitems(int code, String name, double price)
	{
		System.out.println("inside dao layer for updating the data");
		try {
			Item i = sf.getCurrentSession().get(Item.class, code);
			//Category c=sf.getCurrentSession().get(Category.class, cat_id);
			System.out.println(i);
			i.setName(name);
			i.setPrice(price);
			//i.setCat_id(c);
			sf.getCurrentSession().update(i);
			System.out.println("data has been updated");
			} 
			catch (RuntimeException e) {
			System.out.println("data has not updated");
			System.out.println(e);
		}
	}

	@Override
	public List<Account> getuserdetails() {
		String jpql = "select c from Account c";
		return sf.getCurrentSession().createQuery(jpql, Account.class).getResultList();
	}

	@Override
	public String deleteUser(long userId) {
		Session hs = sf.getCurrentSession();
		Account v = hs.get(Account.class, userId);
		if (v != null) {
			hs.delete(v);
			return "User deleted  " + v.getUserId();
		}
		return "User deletion failed : Invalid Vendor ID";

	}

}

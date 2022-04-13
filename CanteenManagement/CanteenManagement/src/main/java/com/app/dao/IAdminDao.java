package com.app.dao;

import java.util.List;

import com.app.pojos.Account;
import com.app.pojos.Item;

public interface IAdminDao {
	List<String> getAllCategory();
	List<Item> ItemCategory(String cat_name);	
	public String deleteItemDetails(int code);
	//String deleteFlatowner(int code);
	public String addItem(Item i,String catname);
	public void updateitems(int code,String name,double price);
	//public void updateitems(int code,String name,double price,int cat_id);
	public Item fetchInfo(int code);
	public List<Account> getuserdetails();
	String deleteUser(long userId);

}

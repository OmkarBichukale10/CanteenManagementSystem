package com.app.dao;

import java.util.List;


import com.app.pojos.Item;
import com.app.pojos.Transaction;

public interface ITransactionDao {
	

	Transaction getTransaction(int id);

	boolean saveTransaction(Transaction t);

	public List<Item> getOrderedItems(int t);
}

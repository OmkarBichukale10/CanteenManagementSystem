package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Item;
import com.app.pojos.Transaction;

@Transactional
@Repository
public class TransactionDaoImpl implements ITransactionDao {

	@Autowired
	SessionFactory sf;


	@Override
	public Transaction getTransaction(int id) {

		return sf.getCurrentSession().get(Transaction.class, id);
	}

	@Override
	public boolean saveTransaction(Transaction t) {
		try {
			sf.getCurrentSession().update(t);
			System.out.println("Transaction is saved");
			return true;
		} catch (Exception e) {
			System.out.println("Transaction saving failed");
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Item> getOrderedItems(int t) {
		List<Object[]> list = new ArrayList<>();
		List<Item> dishList = new ArrayList<Item>();
		try {
			System.out.println(
					"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

			list = sf.getCurrentSession().createSQLQuery(
					"select dishid,dishname,dishprice from dishes d, order_transaction ot,order_dish od where d.dishid=od.dish_id and ot.order_id = od.order_id and ot.transaction_id =:Id")
					.setParameter("Id", t).getResultList();
			System.out.println(list);
			for (Object[] row : list) {
				System.out.println("Inside for loop");
				Item d = new Item();
				d.setCode(Integer.parseInt(row[0].toString()));
				d.setName(row[1].toString());
				d.setPrice(Double.parseDouble(row[2].toString()));
				dishList.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(
					"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Exception in getOrderedDishes()^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		}
		return dishList;
	}

	
}

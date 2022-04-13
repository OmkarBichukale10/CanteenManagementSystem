package com.app.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.*;
import com.app.pojos.Cart;
import com.app.pojos.Item;
import com.app.pojos.Order;
import com.app.pojos.Transaction;


@Controller
@RequestMapping("/order")
public class OrderController {
	List<Item> list;
	@Autowired
	ICategory catDao;

	//@Autowired
	//ITransaction transactionDao;

	@Autowired
	IAccountDao accountDao;

	@Autowired
	IOrder orderDao;

	@Autowired
	ITransactionDao transactionDao;
	
	@Autowired
	IAdminDao adminDao;
	
	@GetMapping("/add")
	public String addToCart(@RequestParam int[] code, HttpSession hs) {
		System.out.println(
				"**********************************************Start of Add to cart method*********************************");
		Cart tcart = (Cart) hs.getAttribute("totalcart");
		Cart cart = (Cart) hs.getAttribute("cart");
		for (int x : code) {
			System.out.println("Value of Dish " + x);
			cart.getList().add(x);
		}

		tcart.getList().addAll(cart.getList());
		System.out.println(cart);
		hs.setAttribute("totalcart", tcart);
		hs.setAttribute("cart", cart);
		System.out.println(
				"**********************************************End of add to cart Method*********************************");
		return "redirect:/category/details";
	}
	
	@GetMapping("/show")
	public String showCart(HttpSession hs, Model map) throws SQLException {
		System.out.println(
				"**********************************************start of Show cart Method*********************************");
		List<Item> list = new ArrayList<>();
	Transaction tr = (Transaction) hs.getAttribute("transaction");
		Cart cart = (Cart) hs.getAttribute("cart");
		for (int x : cart.getList()) {
			System.out.println("Value of Item " + x);
			list.add(catDao.getDish(x));
		}
		System.out.println(cart);
		//hs.setAttribute("bill", orderDao.showTotal(tr.getTransactionId()));
		map.addAttribute("cartList", list);
		System.out.println(
				"**********************************************Start of Show menu Method*********************************");
		return "/menu/showcart";
	}
	/*@PostMapping("/show")
	public String PlaceOrder(HttpSession hs, Model map, @RequestParam int[] qty) throws SQLException {
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
		Transaction tr = (Transaction) hs.getAttribute("transaction");
		//System.out.println("Session scope wala tr" + tr);
		Cart cart = (Cart) hs.getAttribute("cart");
		Order o = new Order();
		System.out.println(qty);
		int q = 0;
		for (int x : cart.getList()) {
			System.out.println("Value of Dish " + x);
			Item d = catDao.getDish(x);
			o.getItem().add(d);
				//	o.getDish().add(d);
			// this.bill += d.getDishPrice();
			o.setQuantity(qty[q]);
			q++;
		}
		// System.out.println("Bill is " + bill);

		System.out.println("Order is " + o);
		o.getTransaction().add(tr);
		System.out.println("Order is " + o);
		o.getTransaction().add(tr);
		System.out.println(o);
		System.out.println(tr);
		if (orderDao.saveOrder(o)) {
			System.out.println("Inside Save order true branch");
			map.addAttribute("msg", "Your order is under process");
		} else {
			System.out.println("Inside Save order false branch");
			map.addAttribute("msg", "Your order failed");
		}
		tr.getOrder().add(o);
		transactionDao.saveTransaction(tr);
		System.out.println(tr);
		System.out.println(cart);
		map.addAttribute("cartList", list);
		hs.setAttribute("cart", new Cart());
		//tr.setTotalBill(orderDao.showTotal(tr.getTransactionId()));
		hs.setAttribute("transaction", tr);

		//System.out.println(map.getAttribute("bill"));
		hs.setAttribute("cartList", list);
		System.out.println(
				"**********************************************End of place order*********************************");
		return "redirect:/order/showbill";

	}*/
	@GetMapping("/showbill")
	public String GetPlaceOrderNextPage(HttpSession hs, Model map)
	{
		List<Object> list = new ArrayList<Object>();
		System.out.println("In Order controller Show bill cha GET method..........");
		//List<CartItems> c=new ArrayList<CartItems>();
		return "/order/showbill";
	}
	@PostMapping("/showbill")
	public String PlaceOrderNextPage(HttpSession hs, Model map)
	{
		List<Object> list = new ArrayList<Object>();
		System.out.println("In Order controller Show bill cha POST method..........");
		//List<CartItems> c=new ArrayList<CartItems>();
		return "/order/payment";
	}



}

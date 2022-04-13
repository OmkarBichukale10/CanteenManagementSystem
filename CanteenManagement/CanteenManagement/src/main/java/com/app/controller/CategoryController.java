package com.app.controller;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IAccountDao;
import com.app.dao.IAdminDao;
import com.app.dao.ICategory;
import com.app.dao.IFeedback;
import com.app.dao.IOrder;
import com.app.dao.IPayment;
import com.app.dao.ITransactionDao;
import com.app.dao.MailImplHtml;
import com.app.pojos.Account;
import com.app.pojos.Cart;
import com.app.pojos.Cartdetails;
import com.app.pojos.Feedback;
import com.app.pojos.Item;
import com.app.pojos.Payment;
import com.app.pojos.Transaction;

@Controller
@RequestMapping("/category")
public class CategoryController 
{
	
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
	@Autowired
	private ICategory dao;
	
	@Autowired
	private IPayment pay;
	
	
	@Autowired
	private IFeedback feed;
	List<Item> list;
	String message;
	String toEmail;

	public CategoryController() 
	{
		System.out.println("in constructor of" + getClass().getName());
	}
	

	@GetMapping("/list")
	public String showList(Model map) 
	{
		System.out.println("in show list");
		map.addAttribute("cat_name", dao.getAllCategory());
		
		return "/category/list";
	}
	@PostMapping("/list")
	public String showDepartment(Model map,@RequestParam String cat_name,HttpSession hs)
	{
		System.out.println("-------------------in category list--------------------");
		//map.addAttribute("emp_list",dao.EmployeeDepartment(dept_name));
		//System.out.println(dao.EmployeeDepartment(dept_name));
		hs.setAttribute("cat_name", cat_name);
		map.addAttribute("item_list",dao.ItemCategory(cat_name));
		return "/category/details";
	}
	
	@GetMapping("/details")
	public String showdeatils(Model map,HttpSession hs) 
	{
		System.out.println("in show details chya page madhe");
		//map.addAttribute("cat_name", dao.getAllCategory());
		map.addAttribute("item_list",dao.ItemCategory((String) hs.getAttribute("cat_name")));
		return "/category/details";
	}	
	
	@PostMapping("/details")
	public String showdeatilsin(Model map,HttpSession hs) 
	{
		System.out.println("in show details chya page madhe");
		//map.addAttribute("cat_name", dao.getAllCategory());
		map.addAttribute("item_list",dao.ItemCategory((String) hs.getAttribute("cat_name")));
		return "/category/details";
	}
	@GetMapping("/add")
	public String addToCart(@RequestParam int[] products, HttpSession hs) {
		System.out.println(
				"**********************************************Start of Add to cart method*********************************");
	Cart tcart = (Cart) hs.getAttribute("totalcart");
		Cart cart = (Cart) hs.getAttribute("cart");
		for (int x : products) {
			//cart.getList().add(x);
			System.out.println("Value of Dish " + x);
			cart.getList().add(x);
			System.out.println("Value of Dish add method nantar " + x);
		}

		System.out.println("Line no :106" );
		tcart.getList().addAll(cart.getList());
		System.out.println(cart);
		System.out.println("Line no :109" );
		hs.setAttribute("totalcart", tcart);
		hs.setAttribute("cart", cart);
		System.out.println(
				"**********************************************End of add to cart Method*********************************");
		//map.addAttribute("item_list",dao.ItemCategory((String) hs.getAttribute("cat_name")));
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
	@PostMapping("/show")
	public String PlaceOrder(HttpSession hs, Model map, @RequestParam int[] qty,
			@RequestParam String[] name,@RequestParam double[] price) throws SQLException
	{
		List<Object> list = new ArrayList<Object>();
		System.out.println("In Show method of category controller cha method");
		//List<CartItems> c=new ArrayList<CartItems>();
		int totalbill=0;
			int size=name.length;
			for(int i=0;i<size;i++)
			{
				Cartdetails cd= new Cartdetails();
				cd.setName(name[i]);
				cd.setPrice(price[i]);
				cd.setQty(qty[i]);
				cd.setTotal(price[i]*qty[i]);
				list.add(cd);
				totalbill=(int) (totalbill+(qty[i]*price[i]));
			}	
		System.out.println(totalbill);
		hs.setAttribute("totalBill", totalbill);
		Account a=(Account) hs.getAttribute("user_dtls");
		System.out.println(a.getUserName());
		System.out.println(a.getUserId());
		
		long uid=a.getUserId();
		LocalDate date=LocalDate.now();
		System.out.println(date);
		hs.setAttribute("date", date);
		hs.setAttribute("uid", uid);
		hs.setAttribute("unamesb", a.getUserName());
		hs.setAttribute("name", a.getName());
		
		map.addAttribute("cartdetails", list);
		int length=name.length;
		String mesg="";
		for(int i=0;i<length;i++) {
			mesg=mesg+name[i]+" = "+qty[i]+" Qty.   ";
		}
		System.out.println(mesg);
		//===============================================================================================================
		toEmail= a.getUserName();
		 
        // message contains HTML markups
		message = "<h1>WE'VE RECEIVED YOUR ORDER!</h1>";
		message += "<h4>Hey</h4>"+"<h4>"+a.getName()+"</h4>";
        message += "<h5>Thank You For Your Order</h5>";
        message += "<h5>Order Details</h5>";
        message += "<table ><thead><tr><th>Item</th><th></th><th>Quantity</th><th></th><th></th><th>Price</th></tr></thead><tbody>";
 
        for(int i=0;i<length;i++) {
					
					message +="<tr><td>"+ name[i] +"</td><td></td>";
					message +="<td>"+qty[i]+"</td><td></td><td></td>";
					message +="<td>"+price[i]+"</td></tr>";
										
		}
		message +="<tr><th >Grand Total</th><th>"+totalbill+"</th></tr></tfoot></table>";
		
     
		//
		
//		for (Object object  : name) {
//			System.out.println(object);
//		}
//		System.out.println(name);
//		System.out.println(qty.toString());
			return "/order/showbill";
	}

	@GetMapping("/billpage")
	public String PlaceOrderNextPage(HttpSession hs, Model map)
	{
		//List<Object> list = new ArrayList<Object>();
		Account a=(Account) hs.getAttribute("user_dtls");
		String uname=a.getUserName();
		hs.setAttribute("uname", uname);
		System.out.println(uname);
		System.out.println("In Category controller Show bill cha  get method..........(/billpage GET Category)");
		//List<CartItems> c=new ArrayList<CartItems>();
		return "/order/billpage";
	}
	
	@PostMapping("/billpage")
	public String PlaceOrderNextPageIn()
	{
		System.out.println("In Category controller Show bill cha post method..........(/billpage POST Category)");
		//List<CartItems> c=new ArrayList<CartItems>();
		return "/order/payment";
	}

	@GetMapping("/back")
	public String backpage(Model map,HttpSession hs) 
	{
		System.out.println(
				"**********************************************Start of Add to cart method*********************************");
		System.out.println("Line no :106" );
	//	tcart.getList().addAll(cart.getList());
		//System.out.println(cart);
		System.out.println("Line no :109" );
		//hs.setAttribute("totalcart", tcart);
		//hs.setAttribute("cart", cart);
		System.out.println(
				"**********************************************End of add to cart Method*********************************");
		map.addAttribute("item_list",dao.ItemCategory((String) hs.getAttribute("cat_name")));
		return "redirect:/category/list";
	}
	
	@GetMapping("/payment")
	public String paymentPage()
	{
		System.out.println("in payment GET method Category controller");
		return "/order/payment";
	}
	
	
	
	
	/* =============================================================== */
	
	@GetMapping("/card")
	public String cardpayment()
	{
		System.out.println("in card payment GET method Category controller");
		return "/order/card";
	}
	
	@PostMapping("/card")
	public String cardpayment(@Valid Payment p,HttpSession hs, Model map,@RequestParam String name,@RequestParam String type,@RequestParam String totalBill,@RequestParam String date)
	{
		System.out.println("in card payment POST method Category controller");
		System.out.println(name);
		System.out.println(totalBill);
		System.out.println(type);
		System.out.println(date);
		System.out.println("1");
		pay.addNewPayment(p);
		String subject = "Order Confirm";
		message+="<h3>Payment Mode : "+p.getType()+"</h3>";
		message +="<h1 color=green>Thank you visit again</h1>";
		try {
        	MailImplHtml.sendHtmlEmail(toEmail, subject, message);
           // mailer.sendHtmlEmail(host, port, mailFrom, password, mailTo,subject, message);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
		return "redirect:/category/feedback";
	}
	
	
	
	@GetMapping("/cash")
	public String cashPayment()
	{
		System.out.println("in  cash payment GET method Category controller");
		return "/order/cash";
	}
	
	@PostMapping("/cash")
	public String cashPayment(@Valid Payment p,HttpSession hs, Model map,@RequestParam String name,@RequestParam String type,@RequestParam String totalBill,@RequestParam String date)
	{
		System.out.println(name);
		System.out.println(totalBill);
		System.out.println(type);
		System.out.println(date);
		System.out.println("1");
		pay.addNewPayment(p);
		String subject = "Order Confirm";
		message+="<h3>Payment Mode : "+p.getType()+"</h3>";
		message +="<h1 color=green>Thank you visit again</h1>";
		
		try {
        	MailImplHtml.sendHtmlEmail(toEmail, subject, message);
           // mailer.sendHtmlEmail(host, port, mailFrom, password, mailTo,subject, message);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
		return "redirect:/category/feedback";
	}

	@GetMapping("/feedback")
	public String feedback(Feedback f)
	{
		System.out.println("in  feedback GET method Category controller");
		return "/order/feedback";
	}
	
	@PostMapping("/feedback")
	public String feedback(@Valid Feedback f,HttpSession hs, Model map)
	{
		System.out.println("in  feedback POST method Category controller");
		feed.addNewFeedback(f);
		return "/order/billpage";
	}
	
}
 
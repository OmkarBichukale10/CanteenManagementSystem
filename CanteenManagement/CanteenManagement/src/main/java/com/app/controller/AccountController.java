package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IAccountDao;
import com.app.pojos.Account;
import com.app.pojos.Cart;
import com.app.dao.MailImpl;
import com.app.dao.MailImplHtml;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired // auto wiring by type
	private IAccountDao dao;

	public AccountController() {
		System.out.println("in user controller constr");
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/account/login";
	}
	
	@PostMapping("/login") // @RequestMapping + method=post
	public String processLoginForm(@RequestParam String userName,
			@RequestParam String password, Model map,
			RedirectAttributes flashMap, HttpSession hs) {
		System.out.println("in process login form");
		// invoke dao's method for auth.
		try {
			Account v = dao.auntheticateUser(userName, password);
			// valid login
			hs.setAttribute("user_dtls", v);// till logout
			hs.setAttribute("cart", new Cart());
			hs.setAttribute("totalcart", new Cart());
			flashMap.addFlashAttribute("mesg", "Login Successful zala");// till next request
		 
			if(v.getRole().equals("admin"))
				return "redirect:/admin/home";
			return "redirect:/category/list";
		} catch (RuntimeException e) {
			System.out.println("err in controller" + e);
			map.addAttribute("mesg", "Invalid Login");
			// invalid login
			
			
			 
			
			return "/account/login";
		}

	}
	
	@GetMapping("/register")
	public String showRegForm(Account v) {
		
		System.out.println("in show reg form");
		
		return "/account/register";

	}

	// request handling method to process reg form
	@PostMapping("/register")
	public String processRegForm(@Valid Account a, BindingResult result,  RedirectAttributes flashMap) {
		
		System.out.println("in process reg form" + a);// transient
		//chk for p.l errors
		
		if(result.hasErrors())
		{
			System.out.println("P.L errs "+result);
			//in case of P.L errors --forward clnt to reg form
			return "/account/register";
		}
		
		flashMap.addFlashAttribute("mesg", dao.addNewAccount(a));
		String to=a.getUserName();
		String mesg="Hi "+a.getName()+", Congratulations! your account on the Canteen Management System has been created successfully."
		+"Login Details: Email: "+a.getUserName()+" Password : "+a.getConfirmPassword();
		MailImpl.sendEmail(mesg,"Welcome : CMS",to,"shrinath.giri720@gmail.com");
		return "/account/success";
	}
	
	@GetMapping("/logout1")
	public String userLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) {
		System.out.println("In User's logout-----------");
		//map.addAttribute("flatowner_dtls",hs.getAttribute("flatowner_dtls"));
		//resp.setHeader("refresh", "5;url="+request.getContextPath());
		//hs.invalidate();
		return "redirect:/account/login";
	}

}

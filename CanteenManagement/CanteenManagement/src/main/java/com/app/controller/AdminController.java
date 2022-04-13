	package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IAdminDao;
import com.app.dao.IFeedback;
import com.app.dao.IPayment;
import com.app.pojos.Item;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminDao dao;
	
	@Autowired
	private IPayment pay;
	
	@Autowired
	private IFeedback feed;
	
	public AdminController() {
		System.out.println("in admin controller constr");
	}
	
	@GetMapping("/home")
	public String showLoginForm() {
		System.out.println("in show home form");
		return "/admin/home";
	}
	
	@GetMapping("/editItems")
	public String showItems(Model map) {
		System.out.println("in show items form");
		map.addAttribute("cat_name", dao.getAllCategory());
		return "/admin/editItems";
	}
	
	@GetMapping("/editUsers")
	public String showUsers(Model map,HttpSession hs) {
		System.out.println("in show user form");
		map.addAttribute("usersss", dao.getuserdetails());
		return "/admin/editUsers";
	}
	
	@PostMapping("/editItems")
	public String showAllItems(Model map,@RequestParam String cat_name,HttpSession hs)
	{
		System.out.println("in show all items form");
		hs.setAttribute("categoryname", cat_name);
		map.addAttribute("categoryname", cat_name);
		map.addAttribute("item_list",dao.ItemCategory(cat_name));
		return "/admin/itemdetails";
	}
	
	/*@GetMapping("/delete")
	public String deleteItem(@RequestParam String Code,@RequestParam String cat_name, RedirectAttributes flashMap,HttpSession hs,Model map) {
		System.out.println("in del Employee " + Code);
		hs.setAttribute("mesg", dao.deleteItemDetails(Code));
		//flashMap.addFlashAttribute("mesg", dao.deleteItemDetails(Code));
		//map.addAttribute("item_list", dao.ItemCategory(cat_name));
		return "/admin/itemdetails";
	}*/
	
	@GetMapping("/additem")
	public String addItem(Item i,Model map) 
	{
		System.out.println("in add item form");
		//map.addAttribute("newItem", new Item());
		return "/admin/additem";
	}
	
	@PostMapping("/additem")
	public String processRegForm(@Valid Item i, BindingResult result,  RedirectAttributes flashMap,Model map,HttpSession hs) {
		
		
		System.out.println("in process reg form " + i);// transient
		if(result.hasErrors())
		{
			System.out.println("P.L errs "+result);
			//in case of P.L errors --forward clnt to reg form
			return "/admin/additem";
		}
		String catname=(String)hs.getAttribute("categoryname");
		flashMap.addFlashAttribute("mesg", dao.addItem(i,catname));
		map.addAttribute("item_list", dao.ItemCategory((String) hs.getAttribute("categoryname")));
		return "/admin/itemdetails";
	}
	
	@GetMapping("/itemdetails")
	public String itemdetailsbyget(Model map,@RequestParam int code, RedirectAttributes flashMap) {
		String cat_name=(String) map.getAttribute("categoryname");
		System.out.println("in add item form");
		//map.addAttribute("categoryname", cat_name);
		map.addAttribute("item_list",dao.ItemCategory(cat_name));
		return "/admin/itemdetails";
	}
	
	@GetMapping("/itemdtls")
	public String itemdetails(Model map,RedirectAttributes flashMap) {
		String cat_name=(String) map.getAttribute("categoryname");
		System.out.println("in add item form");
		//map.addAttribute("categoryname", cat_name);
		map.addAttribute("item_list",dao.ItemCategory(cat_name));
		return "/admin/itemdetails";
	}
	
	@GetMapping("/deletepage")
	public String deleteVendor(@RequestParam long userId, RedirectAttributes flashMap,Model map) {
		System.out.println("in del vendor " + userId);
		flashMap.addFlashAttribute("mesg", dao.deleteUser(userId));
		map.addAttribute("usersss", dao.getuserdetails());
		// redirect clnt to vendor list page
		return "/admin/editUsers";
	}
	
	@GetMapping("/logout1")
	public String userLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) {
		System.out.println("In User's logout-----------");
		//map.addAttribute("flatowner_dtls",hs.getAttribute("flatowner_dtls"));
		//resp.setHeader("refresh", "5;url="+request.getContextPath());
		//hs.invalidate();
		return "redirect:/account/login";
	}
	
	
	@GetMapping("/showPayment")
	public String showPayment(Model map,HttpSession hs) {
		System.out.println("in show user form");
		map.addAttribute("payss", pay.getAllPayment());
		return "/admin/showPayment";
	}
	
	@GetMapping("/feedback")
	public String feedback(Model map,HttpSession hs) {
		System.out.println("in show user form");
		map.addAttribute("feedss", feed.getAllFeedback());
		return "/admin/feedback";
	}
	
}

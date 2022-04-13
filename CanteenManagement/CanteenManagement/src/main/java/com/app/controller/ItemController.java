package com.app.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IAdminDao;
import com.app.pojos.Item;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private IAdminDao dao;

	@GetMapping("/itemdetails")
	public String itemdetails(Model map, RedirectAttributes flashMap,HttpSession hs) {
		//String cat_name = hs.getAttribute("categoryname");
		System.out.println("in item details chya page madhe");
		// map.addAttribute("categoryname", cat_name);
		((RedirectAttributes) map).addAttribute("item_list", dao.ItemCategory((String) hs.getAttribute("categoryname")));
		return "/admin/itemdetails";
	}

	@GetMapping("/delete")
	public String deleteVendor(Model map, @RequestParam int code, RedirectAttributes flashMap,HttpSession hs) {
		System.out.println("in del vendor " + code);
		flashMap.addFlashAttribute("mesg", dao.deleteItemDetails(code));
		System.out.println("in delete karun pudhe");
		map.addAttribute("item_list", dao.ItemCategory((String) hs.getAttribute("categoryname")));

		// map.addAttribute("code", code);
		return "/admin/itemdetails";
	}

	@GetMapping("/updateitems")
	public String update(@RequestParam int code, Model map, HttpSession hs) {
		Item v = dao.fetchInfo(code);
		System.out.println("inside update");
		map.addAttribute("up_info", v);
		//((RedirectAttributes) map).addAttribute("up_info", v);
		hs.setAttribute("code", v.getCode());
		// map.addAttribute("ownersList", dao.fetchFlatOwners());
		
		return "/admin/updateitems";
	}

	@GetMapping("update_info")
	public String updateInformation(@RequestParam String name, @RequestParam double price,
			HttpSession hs, Model map) {
		int code = (Integer) hs.getAttribute("code");
		System.out.println("Inside update information");
		dao.updateitems(code, name, price);
		//String cat_name = (String) ((HttpSession) map).getAttribute("categoryname");
		//((RedirectAttributes) map).addAttribute("ownersList", dao.ItemCategory(cat_name));
		map.addAttribute("item_list", dao.ItemCategory((String) hs.getAttribute("categoryname")));
		return "/admin/itemdetails";
	}
}
